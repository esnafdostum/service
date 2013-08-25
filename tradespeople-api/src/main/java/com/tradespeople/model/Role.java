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
 * Role generated by hbm2java
 */
@Entity
@Table(name = "role")
public class Role extends BaseModel implements java.io.Serializable {

	private String name;
	private Date updateddate;
	private Byte status;
	private Set<Userrole> userroles = new HashSet<Userrole>(0);

	public Role() {
	}

	public Role(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Role(long id, String name, Date createddate, Date updateddate,
			Byte status, Set<Userrole> userroles) {
		this.id = id;
		this.name = name;
		this.createddate = createddate;
		this.updateddate = updateddate;
		this.status = status;
		this.userroles = userroles;
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

	@Column(name = "STATUS")
	public Byte getStatus() {
		return this.status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	public Set<Userrole> getUserroles() {
		return this.userroles;
	}

	public void setUserroles(Set<Userrole> userroles) {
		this.userroles = userroles;
	}

}
