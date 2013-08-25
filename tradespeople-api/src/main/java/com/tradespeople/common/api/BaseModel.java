package com.tradespeople.common.api;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class BaseModel {

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	protected Long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATEDDATE", length = 0)
	protected Date createddate;
	
	public BaseModel(){
	}
	
	public BaseModel(Long id,Date createdDate){
		this.setId(id);
		this.setCreateddate(createdDate);
	}
	
	public BaseModel(Long id) {
		this(id,new Date());
	}
	
	public boolean isPersisted(){
		return getId()!=null;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
