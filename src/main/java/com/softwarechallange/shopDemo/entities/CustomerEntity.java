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
 * Kunde Entity.
 */
@Entity
@Table(name = "customer")
public class CustomerEntity {
    /**
	 * Ein Attribut der Entität CustomerEntity.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false, insertable = false, unique = true)
	private Long id;
	
	/**
	 * Ein Attribut der Entität CustomerEntity.
	 */
	@Column(name = "olversion", insertable = false)
	private Long olVersion;
	
	/**
	 * Ein Attribut der Entität CustomerEntity.
	 */
	private String customernumber;

	/**
	 * Ein Attribut der Entität CustomerEntity.
	 */
	private String name;

	/**
	 * Ein Attribut der Entität CustomerEntity.
	 */
	private String forename;

	/**
	 * Ein Attribut der Entität CustomerEntity.
	 */
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date bdate;

	/**
	 * Ein Attribut der Entität CustomerEntity.
	 */
	private String salutation;

	/**
	 * Ein Attribut der Entität CustomerEntity.
	 */
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date createdat;

	/**
	 * Ein Attribut der Entität CustomerEntity.
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
	public String getCustomernumber() {
		return customernumber;
	}

	/**
	 * Getter/Setter für das entsprechende Attribut.
	 */
	public void setCustomernumber(String customernumber) {
		this.customernumber = customernumber;
	}

	/**
	 * Getter/Setter für das entsprechende Attribut.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter/Setter für das entsprechende Attribut.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter/Setter für das entsprechende Attribut.
	 */
	public String getForename() {
		return forename;
	}

	/**
	 * Getter/Setter für das entsprechende Attribut.
	 */
	public void setForename(String forename) {
		this.forename = forename;
	}

	/**
	 * Getter/Setter für das entsprechende Attribut.
	 */
	public Date getBdate() {
		return bdate;
	}

	/**
	 * Getter/Setter für das entsprechende Attribut.
	 */
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	/**
	 * Getter/Setter für das entsprechende Attribut.
	 */
	public String getSalutation() {
		return salutation;
	}

	/**
	 * Getter/Setter für das entsprechende Attribut.
	 */
	public void setSalutation(String salutation) {
		this.salutation = salutation;
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
		result = prime * result + ((customernumber == null) ? 0 : customernumber.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((forename == null) ? 0 : forename.hashCode());
		result = prime * result + ((bdate == null) ? 0 : bdate.hashCode());
		result = prime * result + ((salutation == null) ? 0 : salutation.hashCode());
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
		CustomerEntity other = (CustomerEntity) obj;
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
		if (customernumber == null) {
			if (other.customernumber != null)
				return false;
		} else if (!customernumber.equals(other.customernumber))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (forename == null) {
			if (other.forename != null)
				return false;
		} else if (!forename.equals(other.forename))
			return false;
		if (bdate == null) {
			if (other.bdate != null)
				return false;
		} else if (!bdate.equals(other.bdate))
			return false;
		if (salutation == null) {
			if (other.salutation != null)
				return false;
		} else if (!salutation.equals(other.salutation))
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

	/**
	 * Erstellt den Anzeigenamen für diesen Kunden.
	 * @return Anzeigename.
	 */
	public String getDisplayName() {
		return getSalutation() + " " + getForename() + " " + getName();
	}
}
