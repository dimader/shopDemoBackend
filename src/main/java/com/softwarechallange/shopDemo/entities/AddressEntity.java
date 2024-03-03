package com.softwarechallange.shopDemo.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Kunden-Adresse Entity.
 */
@Entity
@Table(name = "address")
public class AddressEntity {
    /**
	 * Ein Attribut der Entität AddressEntity.
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false, insertable = false, unique = true)
	private Long id;
	
	/**
	 * Ein Attribut der Entität AddressEntity.
	 */
    @Column(name = "olversion", insertable = false)
	private Long olVersion;

    /**
	 * Ein Attribut der Entität AddressEntity.
	 */
    private String street;

    /**
	 * Ein Attribut der Entität AddressEntity.
	 */
    private String housenumber;

    /**
	 * Ein Attribut der Entität AddressEntity.
	 */
    private String citycode;

    /**
	 * Ein Attribut der Entität AddressEntity.
	 */
    private String city;

    /**
	 * Ein Attribut der Entität AddressEntity.
	 */
    @Column(name = "addresstype")
    private String addressType;

    /**
	 * Ein Attribut der Entität AddressEntity.
	 */
    private Long customer;

    /**
	 * Ein Attribut der Entität AddressEntity.
	 */
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date createdat;

	/**
	 * Ein Attribut der Entität AddressEntity.
	 */
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date changedat;

    /**
	 * Getter/Setter für das entsprechende Attribut.
	 */
    public Long getId() {
        return id;
    }

    /**
	 * Getter/Setter für das entsprechende Attribut.
	 */
    public void setId(Long id) {
        this.id = id;
    }

    /**
	 * Getter/Setter für das entsprechende Attribut.
	 */
    public Long getOlVersion() {
        return olVersion;
    }

    /**
	 * Getter/Setter für das entsprechende Attribut.
	 */
    public void setOlVersion(Long olVersion) {
        this.olVersion = olVersion;
    }

    /**
	 * Getter/Setter für das entsprechende Attribut.
	 */
    public String getStreet() {
        return street;
    }

    /**
	 * Getter/Setter für das entsprechende Attribut.
	 */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
	 * Getter/Setter für das entsprechende Attribut.
	 */
    public String getHousenumber() {
        return housenumber;
    }

    /**
	 * Getter/Setter für das entsprechende Attribut.
	 */
    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    /**
	 * Getter/Setter für das entsprechende Attribut.
	 */
    public String getCitycode() {
        return citycode;
    }

    /**
	 * Getter/Setter für das entsprechende Attribut.
	 */
    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    /**
	 * Getter/Setter für das entsprechende Attribut.
	 */
    public String getCity() {
        return city;
    }

    /**
	 * Getter/Setter für das entsprechende Attribut.
	 */
    public void setCity(String city) {
        this.city = city;
    }

    /**
	 * Getter/Setter für das entsprechende Attribut.
	 */
    public String getAddressType() {
        return addressType;
    }

    /**
	 * Getter/Setter für das entsprechende Attribut.
	 */
    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    /**
	 * Getter/Setter für das entsprechende Attribut.
	 */
    public Long getCustomer() {
        return customer;
    }

    /**
	 * Getter/Setter für das entsprechende Attribut.
	 */
    public void setCustomer(Long customer) {
        this.customer = customer;
    }

    /**
	 * Getter/Setter für das entsprechende Attribut.
	 */
    public Date getCreatedat() {
        return createdat;
    }

    /**
	 * Getter/Setter für das entsprechende Attribut.
	 */
    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    /**
	 * Getter/Setter für das entsprechende Attribut.
	 */
    public Date getChangedat() {
        return changedat;
    }

    /**
	 * Getter/Setter für das entsprechende Attribut.
	 */
    public void setChangedat(Date changedat) {
        this.changedat = changedat;
    }

    /**
	 * HashCode.
	 */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((olVersion == null) ? 0 : olVersion.hashCode());
        result = prime * result + ((street == null) ? 0 : street.hashCode());
        result = prime * result + ((housenumber == null) ? 0 : housenumber.hashCode());
        result = prime * result + ((citycode == null) ? 0 : citycode.hashCode());
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((addressType == null) ? 0 : addressType.hashCode());
        result = prime * result + ((customer == null) ? 0 : customer.hashCode());
        result = prime * result + ((createdat == null) ? 0 : createdat.hashCode());
        result = prime * result + ((changedat == null) ? 0 : changedat.hashCode());
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
        AddressEntity other = (AddressEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (olVersion == null) {
            if (other.olVersion != null)
                return false;
        } else if (!olVersion.equals(other.olVersion))
            return false;
        if (street == null) {
            if (other.street != null)
                return false;
        } else if (!street.equals(other.street))
            return false;
        if (housenumber == null) {
            if (other.housenumber != null)
                return false;
        } else if (!housenumber.equals(other.housenumber))
            return false;
        if (citycode == null) {
            if (other.citycode != null)
                return false;
        } else if (!citycode.equals(other.citycode))
            return false;
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        if (addressType == null) {
            if (other.addressType != null)
                return false;
        } else if (!addressType.equals(other.addressType))
            return false;
        if (customer == null) {
            if (other.customer != null)
                return false;
        } else if (!customer.equals(other.customer))
            return false;
        if (createdat == null) {
            if (other.createdat != null)
                return false;
        } else if (!createdat.equals(other.createdat))
            return false;
        if (changedat == null) {
            if (other.changedat != null)
                return false;
        } else if (!changedat.equals(other.changedat))
            return false;
        return true;
    }

    
}
