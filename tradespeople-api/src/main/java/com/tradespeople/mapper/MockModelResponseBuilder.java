package com.tradespeople.mapper;

import com.tradespeople.json.response.MockModelResponse;
import com.tradespeople.model.MockModel;

public class MockModelResponseBuilder implements IObjectBuilder<MockModelResponse> {

	private Long id;
	private String name;
	
	public MockModelResponseBuilder(){
	}
	
	public MockModelResponseBuilder(MockModel mock){
		this.id=mock.getId();
		this.name=mock.getName();
	}
	
	public MockModelResponseBuilder id(Long id){
		this.id=id;
		return this;
	}
	
	public MockModelResponseBuilder name(String name){
		this.name=name;
		return this;
	}
	
	public MockModelResponse build() {
		MockModelResponse response=new MockModelResponse();
		response.setId(this.id);
		response.setName(this.name);
		return response;
	}
	
	
	

}
