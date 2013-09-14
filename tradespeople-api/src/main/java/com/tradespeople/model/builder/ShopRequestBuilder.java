package com.tradespeople.model.builder;

import org.springframework.stereotype.Component;

import com.tradespeople.common.builder.RequestBuilder;
import com.tradespeople.json.request.ShopRequest;
import com.tradespeople.model.Shop;
import com.tradespeople.model.User;

@Component
public class ShopRequestBuilder extends RequestBuilder<ShopRequest, Shop> {

	@Override
	public ShopRequest build() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shop build(ShopRequest request) {
		User user=new User();
		user.setId(request.userid);
		
		Shop shop=new Shop();
		shop.setAbout(request.about);
		shop.setAddress(request.address);
		shop.setCity(request.city);
		shop.setDistrict(request.district);
		shop.setLatitude(request.latitude);
		shop.setLongitude(request.longitude);
		shop.setName(request.name);
		shop.setUser(user);
		
		return shop;
	}

	@Override
	public ShopRequest build(Shop model) {
		// TODO Auto-generated method stub
		return null;
	}

}
