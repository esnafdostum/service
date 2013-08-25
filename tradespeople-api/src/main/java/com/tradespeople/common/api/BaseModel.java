package com.tradespeople.common.api;

import java.util.Date;

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
