package com.tradespeople.common.api;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class BaseModel {

	protected Long id;
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
	
	public boolean hasPersisted(){
		return getId()!=null;
	}


	@Temporal(TemporalType.DATE)
	@Column(name = "CREATEDDATE", length = 0)
	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	@Id
	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
