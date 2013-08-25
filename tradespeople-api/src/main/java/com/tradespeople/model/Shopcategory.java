package com.tradespeople.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.tradespeople.common.api.BaseModel;

/**
 * Shopcategory generated by hbm2java
 */
@Entity
@Table(name = "shopcategory")
public class Shopcategory extends BaseModel implements java.io.Serializable {

	private String name;
	private String mediapath;
	private Date updateddate;
	private Byte status;
	private Set<Shop> shops = new HashSet<Shop>(0);

	public Shopcategory() {
	}

	public Shopcategory(long id, String name, String mediapath) {
		this.id = id;
		this.name = name;
		this.mediapath = mediapath;
	}

	public Shopcategory(long id, String name, String mediapath,
			Date createddate, Date updateddate, Byte status, Set<Shop> shops) {
		this.id = id;
		this.name = name;
		this.mediapath = mediapath;
		this.createddate = createddate;
		this.updateddate = updateddate;
		this.status = status;
		this.shops = shops;
	}

	@Column(name = "NAME", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "MEDIAPATH", nullable = false, length = 500)
	public String getMediapath() {
		return this.mediapath;
	}

	public void setMediapath(String mediapath) {
		this.mediapath = mediapath;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATEDDATE", length = 0)
	public Date getUpdateddate() {
		return this.updateddate;
	}

	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}

	@Column(name = "STATUS")
	public Byte getStatus() {
		return this.status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shopcategory")
	public Set<Shop> getShops() {
		return this.shops;
	}

	public void setShops(Set<Shop> shops) {
		this.shops = shops;
	}

}
