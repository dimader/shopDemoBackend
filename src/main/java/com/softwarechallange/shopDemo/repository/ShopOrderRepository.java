package com.softwarechallange.shopDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softwarechallange.shopDemo.entities.ShopOrderEntity;
/**
 * Repository für Bestellungen.
 */
@Repository
public interface ShopOrderRepository extends JpaRepository<ShopOrderEntity, Long> {
    
    /**
     * Liefert alle Bestellungen eines Kunden.
     * @param customerId Kunden ID.
     * @return Liste der Bestellungen.
     */
    List<ShopOrderEntity> findByCustomer(Long customerId);
}
