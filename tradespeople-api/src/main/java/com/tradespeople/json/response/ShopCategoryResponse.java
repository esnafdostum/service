package com.tradespeople.json.response;

import java.util.Date;

import com.tradespeople.common.api.BaseResponse;

public class ShopCategoryResponse extends BaseResponse {

	private Long id;
	private String name;
	private String mediapath;
	private Date updateddate;
	private Date createdDate;
	private Byte status;
	
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
	public String getMediapath() {
		return mediapath;
	}
	public void setMediapath(String mediapath) {
		this.mediapath = mediapath;
	}
	public Date getUpdateddate() {
		return updateddate;
	}
	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	
}
