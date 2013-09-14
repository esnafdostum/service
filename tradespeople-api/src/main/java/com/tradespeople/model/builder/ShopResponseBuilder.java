package com.tradespeople.model.builder;


import org.springframework.stereotype.Component;

import com.tradespeople.common.builder.ResponseBuilder;
import com.tradespeople.json.response.ShopResponse;
import com.tradespeople.model.Shop;

@Component
public class ShopResponseBuilder extends ResponseBuilder<ShopResponse, Shop>  {

	@Override
	public ShopResponse build() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shop build(ShopResponse obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShopResponse build(Shop model) {

		ShopResponse response=new ShopResponse();
		
		response.about=model.getAbout();
		response.address=model.getAddress();
		response.categoryname=model.getShopcategory().getName();
		response.city=model.getCity();
		response.district=model.getDistrict();
		response.id=model.getId();
		response.latitude=model.getLatitude();
		response.longitude=model.getLongitude();
		response.name=model.getName();
		response.status=model.getStatus();
		response.username=model.getUser().getName();
		return response;
	}



}
