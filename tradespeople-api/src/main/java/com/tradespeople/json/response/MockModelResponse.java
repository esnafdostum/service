package com.tradespeople.json.response;

import com.tradespeople.common.api.BaseResponse;
import com.tradespeople.model.MockModel;

public class MockModelResponse extends BaseResponse {
	
	private Long id;
	private String name;
	
	public MockModelResponse(MockModel mockModel){
		this.id=mockModel.getId();
		this.name=mockModel.getName();
	}
	
	public MockModelResponse() {
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
	
	
	

}
