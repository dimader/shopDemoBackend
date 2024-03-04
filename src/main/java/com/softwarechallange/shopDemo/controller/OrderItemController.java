package com.softwarechallange.shopDemo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.softwarechallange.shopDemo.entities.ShopOrderItemEntity;
import com.softwarechallange.shopDemo.service.OrderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.*;

/**
 * Order Item Web API.
 */
@RestController
@RequestMapping({ "/orderitem" })
@CrossOrigin
@Tag(name = "OrderItem", description = "API for Order items")
public class OrderItemController {
    /**
	 * Service.
	 */
	@Autowired
	private OrderService orderService;

    /**
	 * Liefert alle Positionen zu einer Bestellung.
	 * @return Liste aller Positionen.
	 */
	@Operation(description = "Get all 'ShopOrderItem' entities.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful response containing an array of the requested 'ShopOrderItem' entities.", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ShopOrderItemEntity.class))) }),
			@ApiResponse(responseCode = "500", description = "Response in case of a technical error ocurring on the server side.", content = @Content) })

    @GetMapping(value = "/by-order/{id}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<List<ShopOrderItemEntity>> getAllShopOrderItemsByShopOrderId(@PathVariable(name = "id") long id) {
		
		List<ShopOrderItemEntity> theResult = orderService.findShopOrderItemsByShopOrderId(id);
		return ResponseEntity.ok(theResult);
	}

    /**
	 * Es wird eine neue Position mit den übergebenen Daten angelegt.
	 * @param item Position einer Bestellung.
	 * @return Die angelegte Position.
	 */
	@Operation(description = "Creates the 'ShopOrderItem' entity with the given data.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful response containing the created single ShopOrderItem.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ShopOrderItemEntity.class)) }),
			@ApiResponse(responseCode = "400", description = "Response for a malformed or semantically illegal request (e.g.\n"
					+ " with an invalid parameter value)", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", description = "Response in case of a technical error ocurring on the server side.", content = @Content) })

	@PutMapping(path = "/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ShopOrderItemEntity> createShopOrderItem(
		@RequestBody ShopOrderItemEntity item) {
	
		try {
			return ResponseEntity.ok(orderService.createShopOrderItem(item));
		} catch (org.springframework.dao.DataIntegrityViolationException exception) {
			// Constraints verletzt
			throw new ResponseStatusException(
        		HttpStatus.BAD_REQUEST, "Constraint violation!", exception);
		}
	}

    /**
	 * Löscht die Position mit der übergebenen ID.
	 * @param id ShopOrderItem ID.
	 * @return Bestätigung.
	 */
	@Operation(description = "Deletes the 'ShopOrderItem' entity with the given technical id.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful response.") })

	@DeleteMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity deleteShopOrderItem(@PathVariable(name = "id") long id) {

		Optional<ShopOrderItemEntity> currentItem = orderService.findShopOrderItemById(id);
		if (currentItem.isPresent()) {
			orderService.deleteShopOrderItem(currentItem.get());
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
