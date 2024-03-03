package com.softwarechallange.shopDemo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softwarechallange.shopDemo.entities.AddressEntity;
import com.softwarechallange.shopDemo.entities.CustomerEntity;
import com.softwarechallange.shopDemo.repository.AddressRepository;
import com.softwarechallange.shopDemo.repository.CustomerRepository;

/**
 * Service für Kundendaten.
 */
@Service
public class CustomerService {
    /**
     * Kunden Repository.
     */
    @Autowired
	private CustomerRepository customerRepository;

    /**
     * Adressen Repository.
     */
	@Autowired
	private AddressRepository addressRepository;

    /**
     * Liefert alle Kunden aus der DB.
     * @return Liste aller Kunden.
     */
    public List<CustomerEntity> findAllCustomers() {
        return customerRepository.findAll();
    }

    /**
     * Liefert einen Kunden per technischer ID.
     * @param id ID.
     * @return Optional Kunde
     */
    public Optional<CustomerEntity> findCustomerById(long id) {
        return customerRepository.findById(id);
    }

    /**
     * Liefert alle Adressen zum Kunden.
     * @param customerid Kunde ID.
     * @return Liste von Adressen.
     */
    public List<AddressEntity> findAddressesByCustomer(long customerid) {
        return addressRepository.findByCustomer(customerid);
    }

    /**
     * Aktualisert (UPDATE) den übergebenen Kunden.
     * @param customer Kunde.
     * @return Aktualisierter Kunde.
     */
    public CustomerEntity update(CustomerEntity customer) {
        customer.setChangedat(new Date());
        customer.setOlVersion(customer.getOlVersion().longValue() + 1);
        return customerRepository.save(customer);
    }

    /**
     * Legt einen neuen Kunden an (INSERT).
     * @param customer Kunde.
     * @return Neu angelegter Kunde.
     */
    public CustomerEntity createCustomer(CustomerEntity customer) {
        customer.setChangedat(new Date());
        customer.setCreatedat(new Date());
        return customerRepository.save(customer);
    }

    /**
     * Löscht (DELETE) den übergebenen Kunden.
     * @param customer Kunde.
     */
    public void deleteCustomer(CustomerEntity customer) {
        // Vorher die Adressen des Kuden löschen
        List<AddressEntity> theAddresses = findAddressesByCustomer(customer.getId());
        addressRepository.deleteAll(theAddresses);
        
        customerRepository.delete(customer);
    }

    /**
     * Legt eine neue Adresse an (INSERT).
     * @param address Adresse.
     * @return Neu angelegte Adresse.
     */
    public AddressEntity createAddress(AddressEntity address) {
        address.setChangedat(new Date());
        address.setCreatedat(new Date());
        return addressRepository.save(address);
    }

    /**
     * Liefert die Adresse mit der übergebenen ID.
     * @param id Adresse ID.
     * @return Optional Adresse.
     */
    public Optional<AddressEntity> findAddressById(long id) {
        return addressRepository.findById(id);
    }

    /**
     * Löscht (DELETE) die übergebene Adresse.
     * @param address Adresse.
     */
    public void deleteAddress(AddressEntity address) {
        addressRepository.delete(address);
    }
}
