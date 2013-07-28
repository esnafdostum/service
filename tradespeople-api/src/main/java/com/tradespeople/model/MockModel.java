package com.tradespeople.model;

import com.tradespeople.common.api.BaseModel;

public class MockModel extends BaseModel {
	
	private String name;
	private Long id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
