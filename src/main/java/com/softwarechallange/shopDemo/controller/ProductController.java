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

import com.softwarechallange.shopDemo.entities.ProductEntity;
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

	/**
	 * Liefert ein Produkt mit der übergebenen id.
	 * @param id Produkt ID.
	 * @return Produktdaten oder 404.
	 */
	@Operation(description = "Get the 'Product' entity with the given technical ID.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful response containing the requested single Product.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ProductEntity.class)) }),
			@ApiResponse(responseCode = "404", description = "Response for requests refering to data which currently does not\n"
					+ " exist on the server side (e.g. an entity with the given technical id does\n"
					+ " not exist in the database)", content = @Content),
			@ApiResponse(responseCode = "500", description = "Response in case of a technical error ocurring on the server side.", content = @Content) })

	@GetMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<ProductEntity> getProductById(@PathVariable(name = "id") long id) {
		
		Optional<ProductEntity> product = productService.findProductById(id);
		if (!product.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return ResponseEntity.ok(product.get());
	}

	/**
	 * Aktualisiert die übergebenen Produktdaten.
	 * @param id Produkt ID.
	 * @param updatedProduct Zu aktualisierende Daten.
	 * @return Aktualisierte Produktdaten.
	 */
	@Operation(description = "Updates the 'Product' entity with the given technical ID.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful response containing the updated single Product.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ProductEntity.class)) }),
			@ApiResponse(responseCode = "404", description = "Response for requests refering to data which currently does not\n"
					+ " exist on the server side (e.g. an entity with the given technical id does\n"
					+ " not exist in the database)", content = @Content),
			@ApiResponse(responseCode = "409", description = "Response for requests which resulted in a conflict.", content = @Content),
			@ApiResponse(responseCode = "500", description = "Response in case of a technical error ocurring on the server side.", content = @Content) })

	@PatchMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ProductEntity> updateProduct(
		@PathVariable(name = "id") long id,
		@RequestBody ProductEntity updatedProduct) {
	
		Optional<ProductEntity> currentProduct = productService.findProductById(id);
		if (!currentProduct.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		if (currentProduct.get().getOlVersion().longValue() != updatedProduct.getOlVersion().longValue()) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}

		return ResponseEntity.ok(productService.update(updatedProduct));
	}

	/**
	 * Es wird ein neues Produkt mit den übergebenen Daten angelegt.
	 * @param product Produktndaten.
	 * @return Der angelegte Produkt.
	 */
	@Operation(description = "Creates the 'Product' entity with the given data.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful response containing the created single Product.", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = ProductEntity.class)) }),
			@ApiResponse(responseCode = "400", description = "Response for a malformed or semantically illegal request (e.g.\n"
					+ " with an invalid parameter value)", content = {
					@Content(mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", description = "Response in case of a technical error ocurring on the server side.", content = @Content) })

	@PutMapping(path = "/", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ProductEntity> createProduct(
		@RequestBody ProductEntity product) {
	
		try {
			return ResponseEntity.ok(productService.createProduct(product));
		} catch (org.springframework.dao.DataIntegrityViolationException exception) {
			// Constraints verletzt
			throw new ResponseStatusException(
        		HttpStatus.BAD_REQUEST, "Constraint violation!", exception);
		}
	}

	/**
	 * Löscht die Produktdaten für die übergebene ID.
	 * @param id Produkt ID.
	 * @return Bestätigung.
	 */
	@Operation(description = "Deletes the 'Product' entity with the given technical id.")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Successful response.") })

	@DeleteMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity deleteProduct(@PathVariable(name = "id") long id) {

		Optional<ProductEntity> currentProduct = productService.findProductById(id);
		if (currentProduct.isPresent()) {
			productService.deleteProduct(currentProduct.get());
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}
}
