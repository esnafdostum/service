package com.tradespeople.json.request;

import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.tradespeople.common.api.BaseRequest;

public class TagRequest extends BaseRequest {

	private Long id;
	
	@NotEmpty
	@NotBlank
	@Length(max=10,min=2)
	private String name;
	private Date updatedDate;
	private Date createdDate;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public boolean isPersisted() {
		return id!=null;
	}
	
}
