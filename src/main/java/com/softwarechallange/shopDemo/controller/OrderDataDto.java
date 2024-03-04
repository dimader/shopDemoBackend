package com.softwarechallange.shopDemo.controller;

import com.softwarechallange.shopDemo.entities.ShopOrderEntity;

/**
 * DTO mit der Antwortstruktur für die getAllOrders REST-Anfrage.
 */
public class OrderDataDto {
    /**
	 * Ein Attribut der Entität OrderDataDto.
	 */
    private ShopOrderEntity order;

    /**
	 * Ein Attribut der Entität OrderDataDto.
	 */
    private String customername;

    /**
     * Konstruktor.
     * @param order Bestellung.
     * @param name Anzeigename für Kunde.
     */
    public OrderDataDto(ShopOrderEntity order, String name) {
        this.order = order;
        this.customername = name;
    }

    /**
	 * Getter/Setter für das entsprechende Attribut.
	 */
    public ShopOrderEntity getOrder() {
        return order;
    }

    /**
	 * Getter/Setter für das entsprechende Attribut.
	 */
    public void setOrder(ShopOrderEntity order) {
        this.order = order;
    }

    /**
	 * Getter/Setter für das entsprechende Attribut.
	 */
    public String getCustomername() {
        return customername;
    }

    /**
	 * Getter/Setter für das entsprechende Attribut.
	 */
    public void setCustomername(String customername) {
        this.customername = customername;
    }

    /**
     * HashCode.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((order == null) ? 0 : order.hashCode());
        result = prime * result + ((customername == null) ? 0 : customername.hashCode());
        return result;
    }

    /**
     * Equals.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderDataDto other = (OrderDataDto) obj;
        if (order == null) {
            if (other.order != null)
                return false;
        } else if (!order.equals(other.order))
            return false;
        if (customername == null) {
            if (other.customername != null)
                return false;
        } else if (!customername.equals(other.customername))
            return false;
        return true;
    }
}
