package com.tradespeople.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.tradespeople.common.api.BaseModel;

/**
 * Tag generated by hbm2java
 */
@Entity
@Table(name = "tag")
public class Tag extends BaseModel implements java.io.Serializable {

	private String name;
	private Date updateddate;
	private Set<Shoptag> shoptags = new HashSet<Shoptag>(0);

	public Tag() {
	}

	public Tag(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Tag(long id, String name, Date createddate, Date updateddate,
			Set<Shoptag> shoptags) {
		this.id = id;
		this.name = name;
		this.createddate = createddate;
		this.updateddate = updateddate;
		this.shoptags = shoptags;
	}

	@Column(name = "NAME", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATEDDATE", length = 0)
	public Date getUpdateddate() {
		return this.updateddate;
	}

	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tag")
	public Set<Shoptag> getShoptags() {
		return this.shoptags;
	}

	public void setShoptags(Set<Shoptag> shoptags) {
		this.shoptags = shoptags;
	}

}
