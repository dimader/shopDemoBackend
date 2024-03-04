package com.softwarechallange.shopDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softwarechallange.shopDemo.entities.ShopOrderItemEntity;

/**
 * Repository für Bestellung-Positionen.
 */
@Repository
public interface ShopOrderItemRepository extends JpaRepository<ShopOrderItemEntity, Long> {
    
    /**
     * Liefert alle Positionen zu einer Bestellung.
     * @param shopOrderId Bestellung ID.
     * @return Alle Positionen. 
     */
    List<ShopOrderItemEntity> findByShoporder(Long shopOrderId);

    /**
     * Löscht alle Positionen zu einer Bestellung.
     * @param shopOrderId Bestellung ID.
     */
    void deleteByShoporder(Long shopOrderId);
}
