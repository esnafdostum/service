package com.tradespeople.json.request;

import com.tradespeople.common.api.BaseRequest;

public class ShopCategoryRequest extends BaseRequest {

	private Long id;
	private String name;
	private String mediapath;
	private Byte status;
	
	public ShopCategoryRequest(){
	}
	
	public ShopCategoryRequest(Long id, String name, String mediapath,Byte status) {
		super();
		this.id = id;
		this.name = name;
		this.mediapath = mediapath;
		this.status = status;
	}



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
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	
}
