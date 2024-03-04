package com.softwarechallange.shopDemo.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

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

import com.softwarechallange.shopDemo.entities.CustomerEntity;
import com.softwarechallange.shopDemo.entities.ShopOrderEntity;
import com.softwarechallange.shopDemo.service.CustomerService;
import com.softwarechallange.shopDemo.service.OrderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.*;

/**
 * Orders Web API.
 */
@RestController
@RequestMapping({ "/order" })
@CrossOrigin
@Tag(name = "Order", description = "API for Orders")
public class OrderController {
    /**
	 * Service.
	 */
	@Autowired
	private CustomerService customerService;

    /**
	 * Service.
	 */
	@Autowired
	private OrderService orderService;

	/**
	 * Liefert alle Bestellungen.
	 * @return Liste aller Bestellungen.
	 */
	@Operation(description = "Get all 'Order' entities.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful response containing an array of the requested 'Order' entities.", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = OrderDataDto.class))) }),
			@ApiResponse(responseCode = "500", description = "Response in case of a technical error ocurring on the server side.", content = @Content) })

    @GetMapping(value = "/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<List<OrderDataDto>> getAllShopOrders() {
		
		// alle Bestellungen lesen
        List<ShopOrderEntity> orders = orderService.findAllShopOrders();

        // Kunden nachlesen
        List<Long> customerIds = orders.stream().map(o -> o.getCustomer()).collect(Collectors.toList());
        List<CustomerEntity> customers = customerService.findCustomersByIds(customerIds);

        // Daten zusammenführen
        Map<Long, CustomerEntity> customerIdMap = customers.stream().collect(Collectors.toMap(CustomerEntity::getId, Function.identity()));
        List<OrderDataDto> orderDtos = 
            orders.stream().map(o -> new OrderDataDto(o, customerIdMap.get(o.getCustomer()).getDisplayName())).collect(Collectors.toList());

        return ResponseEntity.ok(orderDtos);
	}

    /**
	 * Liefert eine Bestellung für die übergebene id.
	 * @param id Bestellung ID.
	 * @return Bestellungsdaten oder 404.
	 */
	@Operation(description = "Get the 'ShopOrderEntity' entity with the given technical ID.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful response containing the requested single ShopOrderEntity.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ShopOrderEntity.class)) }),
			@ApiResponse(responseCode = "404", description = "Response for requests refering to data which currently does not\n"
					+ " exist on the server side (e.g. an entity with the given technical id does\n"
					+ " not exist in the database)", content = @Content),
			@ApiResponse(responseCode = "500", description = "Response in case of a technical error ocurring on the server side.", content = @Content) })

	@GetMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<ShopOrderEntity> getShopOrderById(@PathVariable(name = "id") long id) {
		
		Optional<ShopOrderEntity> order = orderService.findShopOrderById(id);
		if (!order.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return ResponseEntity.ok(order.get());
	}

    /**
	 * Aktualisiert die übergebene Bestellung.
	 * @param id Bestellung ID.
	 * @param updatedOrder Zu aktualisierende Daten.
	 * @return Aktualisierte Bestellung.
	 */
	@Operation(description = "Updates the 'ShopOrder' entity with the given technical ID.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful response containing the updated single ShopOrder.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ShopOrderEntity.class)) }),
			@ApiResponse(responseCode = "404", description = "Response for requests refering to data which currently does not\n"
					+ " exist on the server side (e.g. an entity with the given technical id does\n"
					+ " not exist in the database)", content = @Content),
			@ApiResponse(responseCode = "409", description = "Response for requests which resulted in a conflict.", content = @Content),
			@ApiResponse(responseCode = "500", description = "Response in case of a technical error ocurring on the server side.", content = @Content) })

	@PatchMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ShopOrderEntity> updateShopOrder(
		@PathVariable(name = "id") long id,
		@RequestBody ShopOrderEntity updatedOrder) {
	
		Optional<ShopOrderEntity> currentorder = orderService.findShopOrderById(id);
		if (!currentorder.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		if (currentorder.get().getOlVersion().longValue() != updatedOrder.getOlVersion().longValue()) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

		return ResponseEntity.ok(orderService.updateShopOrder(updatedOrder));
	}

	/**
	 * Es wird eine neue Bestellung mit den übergebenen Daten angelegt.
	 * @param order Bestellungsdaten.
	 * @return Die angelegte Bestellung.
	 */
	@Operation(description = "Creates the 'ShopOrder' entity with the given data.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful response containing the created single ShopOrder.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ShopOrderEntity.class)) }),
			@ApiResponse(responseCode = "400", description = "Response for a malformed or semantically illegal request (e.g.\n"
					+ " with an invalid parameter value)", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", description = "Response in case of a technical error ocurring on the server side.", content = @Content) })

	@PutMapping(path = "/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ShopOrderEntity> createShopOrder(
		@RequestBody ShopOrderEntity order) {
	
		try {
			return ResponseEntity.ok(orderService.createShopOrder(order));
		} catch (org.springframework.dao.DataIntegrityViolationException exception) {
			// Constraints verletzt
			throw new ResponseStatusException(
        		HttpStatus.BAD_REQUEST, "Constraint violation!", exception);
		}
	}

    /**
	 * Löscht die Bestellung für die übergebene ID.
	 * @param id Bestellung ID.
	 * @return Bestätigung.
	 */
	@Operation(description = "Deletes the 'ShopOrder' entity with the given technical id.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful response.") })

	@DeleteMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity deleteShopOrder(@PathVariable(name = "id") long id) {

		Optional<ShopOrderEntity> currentorder = orderService.findShopOrderById(id);
		if (currentorder.isPresent()) {
			orderService.deleteShopOrder(currentorder.get());
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
