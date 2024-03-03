package com.softwarechallange.shopDemo.controller;

import java.util.List;

import com.softwarechallange.shopDemo.entities.AddressEntity;
import com.softwarechallange.shopDemo.entities.CustomerEntity;

/**
 * DTO mit der Antwortstruktur für die getCustomerById REST-Anfrage.
 */
public class CustomerWithAddressDto {
    /**
     * Kunde.
     */
    private CustomerEntity customer;
    /**
     * Liste aller Adressen zum Kunden.
     */
    private List<AddressEntity> addresses;

    /**
     * Getter Kunde.
     * @return Kunde.
     */
    public CustomerEntity getCustomer() {
        return customer;
    }

    /**
     * Setter Kunde.
     * @param customer Kunde.
     */
    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    /**
     * Getter für alle Adressen eines Kunden. 
     * @return Liste von Adressen.
     */
    public List<AddressEntity> getAddresses() {
        return addresses;
    }

    /**
     * Setter für Adressen.
     * @param addresses Adressen.
     */
    public void setAddresses(List<AddressEntity> addresses) {
        this.addresses = addresses;
    }
}
