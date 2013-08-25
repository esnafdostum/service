package com.tradespeople.model.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tradespeople.json.request.ShopCategoryRequest;
import com.tradespeople.json.response.ShopCategoryResponse;
import com.tradespeople.model.Shopcategory;

@Component
public class ShopCategoryBuilder {

	@Autowired
	private ShopCategoryResponseBuilder responseBuilder;
	
	@Autowired
	private ShopCategoryRequestBuilder requestBuilder;
	
	public Shopcategory buildFor(ShopCategoryRequest request){
		return requestBuilder.build(request);
	}
	
	public Shopcategory buildFor(ShopCategoryResponse response){
		return responseBuilder.build(response);
	}
	
	public ShopCategoryRequest buildRequest(Shopcategory model){
		return requestBuilder.build(model);
	}
	
	public ShopCategoryResponse buildResponse(Shopcategory model){
		return responseBuilder.build(model);
	}

	public void setResponseBuilder(ShopCategoryResponseBuilder responseBuilder) {
		this.responseBuilder = responseBuilder;
	}

	public void setRequestBuilder(ShopCategoryRequestBuilder requestBuilder) {
		this.requestBuilder = requestBuilder;
	}
	
}
