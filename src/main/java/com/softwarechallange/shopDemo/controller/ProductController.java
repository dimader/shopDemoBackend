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
import com.softwarechallange.shopDemo.entities.ProductEntity;
import com.softwarechallange.shopDemo.service.CustomerService;
import com.softwarechallange.shopDemo.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.*;

/**
 * Product Web API.
 */
@RestController
@RequestMapping({ "/product" })
@CrossOrigin
@Tag(name = "Product", description = "API for Products")
public class ProductController {
    /**
	 * Service.
	 */
	@Autowired
	private ProductService productService;

    /**
	 * Liefert alle Produkte.
	 * @return Liste aller Produkte.
	 */
	@Operation(description = "Get all 'Product' entities.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful response containing an array of the requested 'Product' entities.", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProductEntity.class))) }),
			@ApiResponse(responseCode = "500", description = "Response in case of a technical error ocurring on the server side.", content = @Content) })

    @GetMapping(value = "/", produces = "application/json", consumes = "application/json")
	public ResponseEntity<List<ProductEntity>> getAllProducts() {
		
		List<ProductEntity> theResult = productService.findAllProducts();
		return ResponseEntity.ok(theResult);
	}
}
