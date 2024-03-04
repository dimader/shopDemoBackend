package com.softwarechallange.shopDemo.entities;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Produkt Entity.
 */
@Entity
@Table(name = "product")
public class ProductEntity {
    /**
	 * Ein Attribut der Entität ProductEntity.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false, insertable = false, unique = true)
	private Long id;
	
	/**
	 * Ein Attribut der Entität ProductEntity.
	 */
    @Column(name = "olversion", insertable = false)
	private Long olVersion;

    /**
	 * Ein Attribut der Entität ProductEntity.
	 */
    private BigDecimal price;

    /**
	 * Ein Attribut der Entität ProductEntity.
	 */
    private String productnumber;

    /**
	 * Ein Attribut der Entität ProductEntity.
	 */
    private String description;

    /**
	 * Ein Attribut der Entität ProductEntity.
	 */
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date createdat;

	/**
	 * Ein Attribut der Entität ProductEntity.
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
    public BigDecimal getPrice() {
        return price;
    }

    /**
	 * Getter/Setter für das entsprechende Attribut.
	 */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
	 * Getter/Setter für das entsprechende Attribut.
	 */
    public String getProductnumber() {
        return productnumber;
    }

    /**
	 * Getter/Setter für das entsprechende Attribut.
	 */
    public void setProductnumber(String productnumber) {
        this.productnumber = productnumber;
    }

    /**
	 * Getter/Setter für das entsprechende Attribut.
	 */
    public String getDescription() {
        return description;
    }

    /**
	 * Getter/Setter für das entsprechende Attribut.
	 */
    public void setDescription(String description) {
        this.description = description;
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
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((productnumber == null) ? 0 : productnumber.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
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
        ProductEntity other = (ProductEntity) obj;
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
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        if (productnumber == null) {
            if (other.productnumber != null)
                return false;
        } else if (!productnumber.equals(other.productnumber))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
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
