package com.tradespeople.model.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tradespeople.json.request.ShopTagRequest;
import com.tradespeople.json.response.ShopTagResponse;
import com.tradespeople.model.Shoptag;

@Component
public class ShopTagBuilder {

	@Autowired
	private ShopTagRequestBuilder requestBuilder;
	@Autowired
	private ShopTagResponseBuilder responseBuilder;
	
	public Shoptag buildFor(ShopTagRequest request){
		return requestBuilder.build(request);
	}
	
	public Shoptag buildFor(ShopTagResponse response){
		return responseBuilder.build(response);
	}
	
	public ShopTagRequest buildRequest(Shoptag model){
		return requestBuilder.build(model);
	}
	
	public ShopTagResponse buildResponse(Shoptag model){
		return responseBuilder.build(model);
	}
	
	
	public void setRequestBuilder(ShopTagRequestBuilder requestBuilder) {
		this.requestBuilder = requestBuilder;
	}
	
	public void setResponseBuilder(ShopTagResponseBuilder responseBuilder) {
		this.responseBuilder = responseBuilder;
	}
	
}
