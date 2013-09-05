package com.tradespeople.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
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
 * User generated by hbm2java
 */
@Entity
@Table(name = "user")
public class User extends BaseModel implements java.io.Serializable {

	private String username;
	private String password;
	private String token;
	private Date updateddate;
	private Byte status;
	private String name;
	private String surname;
	private Set<Comment> comments = new HashSet<Comment>(0);
	private Set<Medialookup> medialookups = new HashSet<Medialookup>(0);
	private Set<Shop> shops = new HashSet<Shop>(0);
	private Set<Userrole> userroles = new HashSet<Userrole>(0);

	public User() {
	}

	public User(long id, String username) {
		this.id = id;
		this.username = username;
	}

	public User(long id, String username, String password, String token,
			Date createddate, Date updateddate, Byte status, String name,
			String surname, Set<Comment> comments,
			Set<Medialookup> medialookups, Set<Shop> shops,
			Set<Userrole> userroles) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.token = token;
		this.createddate = createddate;
		this.updateddate = updateddate;
		this.status = status;
		this.name = name;
		this.surname = surname;
		this.comments = comments;
		this.medialookups = medialookups;
		this.shops = shops;
		this.userroles = userroles;
	}
	
	public List<Role> userRoles(){
		List<Role> roles=new ArrayList<Role>();
		for (Userrole userrole : userroles) {
			roles.add(userrole.getRole());
		}
		return roles;
	}
	
	public boolean isExistAnyRole(){
		if (userroles==null) {
			return false;
		}else if (userroles.size()==0) {
			return false;
		}
		return true;
	}
	
	public boolean isNotExistAnyRole() {
		return !isExistAnyRole();
	}
	
	public void addRole(Role role){
		if (isNotExistsUserRoleFor(role)) {
			Userrole userrole=new Userrole();
			userrole.setUser(this);
			userrole.setRole(role);
			userroles.add(userrole);
		}
	}

	private boolean isNotExistsUserRoleFor(Role role) {
		return !userRoles().contains(role);
	}

	@Column(name = "USERNAME", nullable = false, length = 150)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "PASSWORD", length = 100)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "TOKEN", length = 200)
	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
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

	@Column(name = "NAME", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "SURNAME", length = 45)
	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Comment> getComments() {
		return this.comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Medialookup> getMedialookups() {
		return this.medialookups;
	}

	public void setMedialookups(Set<Medialookup> medialookups) {
		this.medialookups = medialookups;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Shop> getShops() {
		return this.shops;
	}

	public void setShops(Set<Shop> shops) {
		this.shops = shops;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Userrole> getUserroles() {
		return this.userroles;
	}

	public void setUserroles(Set<Userrole> userroles) {
		this.userroles = userroles;
	}

}
