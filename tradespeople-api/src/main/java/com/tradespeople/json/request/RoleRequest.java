package com.tradespeople.json.request;

import com.tradespeople.common.api.BaseRequest;

public class RoleRequest extends BaseRequest {

	private String id;
	private String name;
	private Byte status;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	
	
	
}
