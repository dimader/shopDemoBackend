package com.softwarechallange.shopDemo.entities;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Shop Order Item Entity.
 */
@Entity
@Table(name = "shoporderitem")
public class ShopOrderItemEntity {
    /**
	 * Ein Attribut der Entität ShopOrderItemEntity.
	 */
	@Id
	private Long id;

    /**
	 * Ein Attribut der Entität ShopOrderItemEntity.
	 */
    private Long shoporder;

    /**
	 * Ein Attribut der Entität ShopOrderItemEntity.
	 */
    private Long product;

    /**
	 * Ein Attribut der Entität ShopOrderItemEntity.
	 */
    private BigDecimal price;

    /**
	 * Ein Attribut der Entität ShopOrderItemEntity.
	 */
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date createdat;

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
    public Long getShoporder() {
        return shoporder;
    }

    /**
	 * Getter/Setter für das entsprechende Attribut.
	 */
    public void setShoporder(Long shoporder) {
        this.shoporder = shoporder;
    }

    /**
	 * Getter/Setter für das entsprechende Attribut.
	 */
    public Long getProduct() {
        return product;
    }

    /**
	 * Getter/Setter für das entsprechende Attribut.
	 */
    public void setProduct(Long product) {
        this.product = product;
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
	 * HashCode.
	 */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((shoporder == null) ? 0 : shoporder.hashCode());
        result = prime * result + ((product == null) ? 0 : product.hashCode());
        result = prime * result + ((price == null) ? 0 : price.hashCode());
        result = prime * result + ((createdat == null) ? 0 : createdat.hashCode());
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
        ShopOrderItemEntity other = (ShopOrderItemEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (shoporder == null) {
            if (other.shoporder != null)
                return false;
        } else if (!shoporder.equals(other.shoporder))
            return false;
        if (product == null) {
            if (other.product != null)
                return false;
        } else if (!product.equals(other.product))
            return false;
        if (price == null) {
            if (other.price != null)
                return false;
        } else if (!price.equals(other.price))
            return false;
        if (createdat == null) {
            if (other.createdat != null)
                return false;
        } else if (!createdat.equals(other.createdat))
            return false;
        return true;
    }

    
}
