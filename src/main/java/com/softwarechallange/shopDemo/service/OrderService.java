package com.softwarechallange.shopDemo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softwarechallange.shopDemo.entities.ShopOrderEntity;
import com.softwarechallange.shopDemo.entities.ShopOrderItemEntity;
import com.softwarechallange.shopDemo.repository.ShopOrderItemRepository;
import com.softwarechallange.shopDemo.repository.ShopOrderRepository;

/**
 * Service für Bestellungen.
 */
@Service
@Transactional
public class OrderService {
    /**
     * Order Repository.
     */
	@Autowired
	private ShopOrderRepository orderRepository;

    /**
     * Order-Item Repository.
     */
	@Autowired
    private ShopOrderItemRepository orderItemRepository;

    /**
     * Liefert alle Bestellungen aus der DB.
     * @return Liste aller Bestellungen.
     */
    public List<ShopOrderEntity> findAllShopOrders() {
        return orderRepository.findAll();
    }

    /**
     * Liefert die Bestellung für die übergebene id.
     * @param id Bestellung ID.
     * @return Optional Bestellung.
     */
    public Optional<ShopOrderEntity> findShopOrderById(Long id) {
        return orderRepository.findById(id);
    }

    /**
     * Liefert das ShopOrderItem für die übergebene id.
     * @param id ShopOrderItem ID.
     * @return Optional ShopOrderItem.
     */
    public Optional<ShopOrderItemEntity> findShopOrderItemById(Long id) {
        return orderItemRepository.findById(id);
    }

    /**
     * Liefert alle ShopOrderItems für eine ShopOrder zurück.
     * @param id ShopOrder ID.
     * @return Liste der ShopOrderItems.
     */
    public List<ShopOrderItemEntity> findShopOrderItemsByShopOrderId(Long id) {
        return orderItemRepository.findByShoporder(id);
    }

    /**
     * Aktualisert (UPDATE) die übergebene Bestellung.
     * @param order Bestellung.
     * @return Aktualisierter Bestellung.
     */
    public ShopOrderEntity updateShopOrder(ShopOrderEntity order) {
        order.setChangedat(new Date());
        order.setOlVersion(order.getOlVersion().longValue() + 1);
        return orderRepository.save(order);
    }

    /**
     * Legt einen neue Bestellung an (INSERT).
     * @param order Bestellung.
     * @return Neu angelegte Bestellung.
     */
    public ShopOrderEntity createShopOrder(ShopOrderEntity order) {
        order.setChangedat(new Date());
        order.setCreatedat(new Date());
        return orderRepository.save(order);
    }

    /**
     * Legt einen neue Bestellung-Position an (INSERT).
     * @param item Position.
     * @return Neu angelegte Position.
     */
    public ShopOrderItemEntity createShopOrderItem(ShopOrderItemEntity item) {
        item.setCreatedat(new Date());
        return orderItemRepository.save(item);
    }

    /**
     * Löscht (DELETE) die übergebene Bestellung.
     * @param order Bestellung.
     */
    public void deleteShopOrder(ShopOrderEntity order) {
        orderItemRepository.deleteByShoporder(order.getId());
        orderRepository.delete(order);
    }

    /**
     * Löscht (DELETE) die übergebene Position.
     * @param item Position.
     */
    public void deleteShopOrderItem(ShopOrderItemEntity item) {
        orderItemRepository.delete(item);
    }

    /**
     * Löscht alle Bestellungen eines Kunden.
     * @param customerId Kunden ID.
     */
    public void deleteShopOrdersByCustomer(Long customerId) {
        List<ShopOrderEntity> orders = orderRepository.findByCustomer(customerId);
        for (ShopOrderEntity shopOrderEntity : orders) {
            deleteShopOrder(shopOrderEntity);
        }
    }
}
