package com.softwarechallange.shopDemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.softwarechallange.shopDemo.entities.AddressEntity;
import com.softwarechallange.shopDemo.service.CustomerService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.*;

/**
 * Customer-Address Web API.
 */
@RestController
@RequestMapping({ "/address" })
@CrossOrigin
@Tag(name = "Address", description = "API for Customer-Addresses")
public class AddressController {
    /**
	 * Service.
	 */
	@Autowired
	private CustomerService customerService;

    /**
	 * Es wird eine neue Adresse mit den übergebenen Daten angelegt.
	 * @param address Adressdaten.
	 * @return Die angelegte Adresse.
	 */
	@Operation(description = "Creates the 'Address' entity with the given data.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful response containing the created single Address.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = AddressEntity.class)) }),
			@ApiResponse(responseCode = "400", description = "Response for a malformed or semantically illegal request (e.g.\n"
					+ " with an invalid parameter value)", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", description = "Response in case of a technical error ocurring on the server side.", content = @Content) })

	@PutMapping(path = "/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<AddressEntity> createAddress(
		@RequestBody AddressEntity address) {
	
		try {
			return ResponseEntity.ok(customerService.createAddress(address));
		} catch (org.springframework.dao.DataIntegrityViolationException exception) {
			// Constraints verletzt
			throw new ResponseStatusException(
        		HttpStatus.BAD_REQUEST, "Constraint violation!", exception);
		}
	}

    /**
	 * Löscht die Adresse mit der übergebenen ID.
	 * @param id Adress ID.
	 * @return Bestätigung.
	 */
	@Operation(description = "Deletes the 'Address' entity with the given technical id.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful response.") })

	@DeleteMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity deleteAddress(@PathVariable(name = "id") long id) {

		Optional<AddressEntity> currentAddress = customerService.findAddressById(id);
		if (currentAddress.isPresent()) {
			customerService.deleteAddress(currentAddress.get());
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
