package com.softwarechallange.shopDemo.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Shop Order Entity.
 */
@Entity
@Table(name = "shoporder")
public class ShopOrderEntity {
    /**
	 * Ein Attribut der Entität ShopOrderEntity.
	 */
	@Id
	private Long id;

    /**
	 * Ein Attribut der Entität ShopOrderEntity.
	 */
    private Long customer;

    /**
	 * Ein Attribut der Entität ShopOrderEntity.
	 */
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date createdat;

	/**
	 * Ein Attribut der Entität ShopOrderEntity.
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
        ShopOrderEntity other = (ShopOrderEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
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
