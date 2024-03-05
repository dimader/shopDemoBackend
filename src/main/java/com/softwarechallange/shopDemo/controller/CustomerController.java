package com.softwarechallange.shopDemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.softwarechallange.shopDemo.entities.AddressEntity;
import com.softwarechallange.shopDemo.entities.CustomerEntity;
import com.softwarechallange.shopDemo.service.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.*;

/**
 * Customer Web API.
 */
@RestController
@RequestMapping({ "/customer" })
@CrossOrigin
@Tag(name = "Customer", description = "API for Customers")
public class CustomerController {

	/**
	 * Service.
	 */
	@Autowired
	private CustomerService customerService;

	/**
	 * Liefert alle Kunden.
	 * @return Liste aller Kunden.
	 */
	@Operation(description = "Get all 'Customer' entities.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful response containing an array of the requested 'Customer' entities.", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CustomerEntity.class))) }),
			@ApiResponse(responseCode = "500", description = "Response in case of a technical error ocurring on the server side.", content = @Content) })

    @GetMapping(value = "/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<CustomerEntity>> getAllCustomers() {
		
		List<CustomerEntity> theResult = customerService.findAllCustomers();
		return ResponseEntity.ok(theResult);
	}

	/**
	 * Liefert einen Kunden mit allen seinen Adressen mit der übergebenen id.
	 * @param id Kunden ID.
	 * @return Kundendaten oder 404.
	 */
	@Operation(description = "Get the 'Customer' entity with the given technical ID.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful response containing the requested single Customer.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = CustomerEntity.class)) }),
			@ApiResponse(responseCode = "404", description = "Response for requests refering to data which currently does not\n"
					+ " exist on the server side (e.g. an entity with the given technical id does\n"
					+ " not exist in the database)", content = @Content),
			@ApiResponse(responseCode = "500", description = "Response in case of a technical error ocurring on the server side.", content = @Content) })

	@GetMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<CustomerWithAddressDto> getCustomerById(@PathVariable(name = "id") long id) {
		
		Optional<CustomerEntity> customer = customerService.findCustomerById(id);
		if (!customer.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		List<AddressEntity> addresses = customerService.findAddressesByCustomer(id);

		CustomerWithAddressDto result = new CustomerWithAddressDto();
		result.setCustomer(customer.get());
		result.setAddresses(addresses);

		return ResponseEntity.ok(result);
	}

	/**
	 * Aktualisiert die übergebenen Kundendaten.
	 * @param id Kunden ID.
	 * @param updatedCustomer Zu aktualisierende Daten.
	 * @return Aktualisierte Kundendaten.
	 */
	@Operation(description = "Updates the 'Customer' entity with the given technical ID.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful response containing the updated single Customer.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = CustomerEntity.class)) }),
			@ApiResponse(responseCode = "404", description = "Response for requests refering to data which currently does not\n"
					+ " exist on the server side (e.g. an entity with the given technical id does\n"
					+ " not exist in the database)", content = @Content),
			@ApiResponse(responseCode = "409", description = "Response for requests which resulted in a conflict.", content = @Content),
			@ApiResponse(responseCode = "500", description = "Response in case of a technical error ocurring on the server side.", content = @Content) })

	@PatchMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<CustomerEntity> updateCustomer(
		@PathVariable(name = "id") long id,
		@RequestBody CustomerEntity updatedCustomer) {
	
		Optional<CustomerEntity> currentcustomer = customerService.findCustomerById(id);
		if (!currentcustomer.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		if (currentcustomer.get().getOlVersion().longValue() != updatedCustomer.getOlVersion().longValue()) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

		return ResponseEntity.ok(customerService.updateCustomer(updatedCustomer));
	}

	/**
	 * Es wird ein neuer Kunde mit den übergebenen Daten angelegt.
	 * @param customer Kundendaten.
	 * @return Der angelegte Kunde.
	 */
	@Operation(description = "Creates the 'Customer' entity with the given data.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful response containing the created single Customer.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = CustomerEntity.class)) }),
			@ApiResponse(responseCode = "400", description = "Response for a malformed or semantically illegal request (e.g.\n"
					+ " with an invalid parameter value)", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", description = "Response in case of a technical error ocurring on the server side.", content = @Content) })

	@PutMapping(path = "/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<CustomerEntity> createCustomer(
		@RequestBody CustomerEntity customer) {
	
		try {
			return ResponseEntity.ok(customerService.createCustomer(customer));
		} catch (org.springframework.dao.DataIntegrityViolationException exception) {
			// Constraints verletzt
			throw new ResponseStatusException(
        		HttpStatus.BAD_REQUEST, "Constraint violation!", exception);
		}
	}

	/**
	 * Löscht die Kundendaten (zusammen mit den Adressen) für die übergebene ID.
	 * @param id Kunden ID.
	 * @return Bestätigung.
	 */
	@Operation(description = "Deletes the 'Customer' entity with the given technical id.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful response.") })

	@DeleteMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity deleteCustomer(@PathVariable(name = "id") long id) {

		Optional<CustomerEntity> currentcustomer = customerService.findCustomerById(id);
		if (currentcustomer.isPresent()) {
			customerService.deleteCustomer(currentcustomer.get());
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
