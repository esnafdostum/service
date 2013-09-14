package com.tradespeople.model.builder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tradespeople.json.request.ShopRequest;
import com.tradespeople.json.response.ShopCollectionResponse;
import com.tradespeople.json.response.ShopResponse;
import com.tradespeople.model.Shop;

@Component
public class ShopBuilder  {
	
	@Autowired
	private ShopResponseBuilder responseBuilder;
	
	@Autowired
	private ShopRequestBuilder requestBuilder;
	
	public Shop buildFor(ShopRequest request){
		return requestBuilder.build(request);
	}
	
	public Shop buildFor(ShopResponse response){
		return responseBuilder.build(response);
	}
	
	public ShopRequest buildRequest(Shop model){
		return requestBuilder.build(model);
	}
	
	public ShopResponse buildResponse(Shop model){
		return responseBuilder.build(model);
	}

	public ShopCollectionResponse buildResponse(List<Shop> list){
		ShopCollectionResponse response=new ShopCollectionResponse();
		for (Shop shop : list) {
			response.add(this.buildResponse(shop));
		}
		return response;
	}

	public void setResponseBuilder(ShopResponseBuilder responseBuilder) {
		this.responseBuilder = responseBuilder;
	}

	public void setRequestBuilder(ShopRequestBuilder requestBuilder) {
		this.requestBuilder = requestBuilder;
	}

}
