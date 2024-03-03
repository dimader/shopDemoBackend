package com.softwarechallange.shopDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softwarechallange.shopDemo.entities.ProductEntity;
import com.softwarechallange.shopDemo.repository.ProductRepository;

import java.util.List;

/**
 * Service für Produktdaten.
 */
@Service
public class ProductService {
    /**
     * Produkte Repository.
     */
    @Autowired
	private ProductRepository productRepository;

    /**
     * Liefert alle Produkte aus der DB.
     * @return Liste aller Produkte.
     */
    public List<ProductEntity> findAllProducts() {
        return productRepository.findAll();
    }
}
