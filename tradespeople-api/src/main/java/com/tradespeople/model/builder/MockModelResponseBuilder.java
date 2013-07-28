package com.tradespeople.model.builder;

import com.tradespeople.common.builder.ResponseBuilder;
import com.tradespeople.json.response.MockModelResponse;
import com.tradespeople.model.MockModel;

public class MockModelResponseBuilder extends ResponseBuilder<MockModelResponse,MockModel> {
	
	private Long id;
	private String name;
	
	public MockModelResponse build() {
		MockModelResponse response=new MockModelResponse();
		response.setId(this.id);
		response.setName(this.name);
		return response;
	}
	public MockModel build(MockModelResponse obj) {
		MockModel mockModel=new MockModel();
		mockModel.setId(obj.getId());
		mockModel.setName(obj.getName());
		return mockModel;
	}
	public MockModelResponse build(MockModel model) {
		this.id=model.getId();
		this.name=model.getName();
		return build();
	}
	
	
}
