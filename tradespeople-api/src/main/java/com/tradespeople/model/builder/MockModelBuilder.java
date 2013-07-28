package com.tradespeople.model.builder;

import com.tradespeople.json.request.MockModelRequest;
import com.tradespeople.json.response.MockModelResponse;
import com.tradespeople.model.MockModel;

public class MockModelBuilder {
	
	private MockModelRequestBuilder requestBuilder;
	private MockModelResponseBuilder responsebuilder;
	
	public MockModelBuilder(){
		requestBuilder=new MockModelRequestBuilder();
		responsebuilder=new MockModelResponseBuilder();
	}
	
	public MockModel buildFor(MockModelRequest request){
		return requestBuilder.build(request);
	}
	
	public MockModel buildFor(MockModelResponse response){
		return responsebuilder.build(response);
	}
	
	public MockModelRequest buildRequest(MockModel model){
		return requestBuilder.build(model);
	}
	
	public MockModelResponse buildResponse(MockModel model){
		return responsebuilder.build(model);
	}

}
