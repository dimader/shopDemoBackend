package com.softwarechallange.shopDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softwarechallange.shopDemo.entities.ProductEntity;

/**
 * Repository für Produkte.
 */
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    
}
