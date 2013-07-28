package com.tradespeople.model.builder;

import com.tradespeople.common.builder.RequestBuilder;
import com.tradespeople.json.request.MockModelRequest;
import com.tradespeople.model.MockModel;

public class MockModelRequestBuilder extends RequestBuilder<MockModelRequest, MockModel> {
	
	private Long id;
	private String name;
	
	public MockModelRequest build() {
		MockModelRequest request=new MockModelRequest();
		request.setId(this.id);
		request.setName(this.name);
		return request;
	}

	public MockModel build(MockModelRequest request) {
		MockModel model=new MockModel();
		model.setId(request.getId());
		model.setName(request.getName());
		return model;
	}

	public MockModelRequest build(MockModel model) {
		this.id=model.getId();
		this.name=model.getName();
		return build();
	}

}
