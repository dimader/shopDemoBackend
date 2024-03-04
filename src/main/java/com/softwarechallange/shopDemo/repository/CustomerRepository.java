package com.softwarechallange.shopDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softwarechallange.shopDemo.entities.CustomerEntity;

/**
 * Repository für Kunden.
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
    
    /**
     * Liefert die Kunden für die übergebenen IDs.
     * @param someIds ID Liste.
     * @return Kunden Liste.
     */
    List<CustomerEntity> findByIdIn(List<Long> someIds);
}

