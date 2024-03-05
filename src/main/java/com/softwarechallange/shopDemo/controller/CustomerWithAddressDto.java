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

    /**
     * HashCode.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customer == null) ? 0 : customer.hashCode());
        result = prime * result + ((addresses == null) ? 0 : addresses.hashCode());
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
        CustomerWithAddressDto other = (CustomerWithAddressDto) obj;
        if (customer == null) {
            if (other.customer != null)
                return false;
        } else if (!customer.equals(other.customer))
            return false;
        if (addresses == null) {
            if (other.addresses != null)
                return false;
        } else if (!addresses.equals(other.addresses))
            return false;
        return true;
    }
}
