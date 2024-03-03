package com.softwarechallange.shopDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softwarechallange.shopDemo.entities.CustomerEntity;

/**
 * Repository für Kunden.
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    
}

