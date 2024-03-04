package com.softwarechallange.shopDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softwarechallange.shopDemo.entities.ProductEntity;
import com.softwarechallange.shopDemo.repository.ProductRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    /**
     * Liefert ein Produkt per technischer ID.
     * @param id ID.
     * @return Optional Produkt
     */
    public Optional<ProductEntity> findProductById(long id) {
        return productRepository.findById(id);
    }

    /**
     * Aktualisert (UPDATE) das übergebene Produkt.
     * @param product Produkt.
     * @return Aktualisiertes Produkt.
     */
    public ProductEntity update(ProductEntity product) {
        product.setChangedat(new Date());
        product.setOlVersion(product.getOlVersion().longValue() + 1);
        return productRepository.save(product);
    }

    /**
     * Legt einen neues Produkt an (INSERT).
     * @param product Produkt.
     * @return Neu angelegter Produkt.
     */
    public ProductEntity createProduct(ProductEntity product) {
        product.setChangedat(new Date());
        product.setCreatedat(new Date());
        return productRepository.save(product);
    }

    /**
     * Löscht (DELETE) das übergebene Produkt.
     * @param product Produkt.
     */
    public void deleteProduct(ProductEntity product) {
        productRepository.delete(product);
    }
}
