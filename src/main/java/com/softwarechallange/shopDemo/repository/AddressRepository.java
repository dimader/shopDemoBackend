package com.softwarechallange.shopDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softwarechallange.shopDemo.entities.AddressEntity;

/**
 * Repository für Kunden-Adressen.
 */
@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
    /**
     * Liefert alle Adressen zur Kunden ID.
     * @param customerid Kunden ID.
     * @return Liste aller Adressen.
     */
    List<AddressEntity> findByCustomer(Long customerid);
}
