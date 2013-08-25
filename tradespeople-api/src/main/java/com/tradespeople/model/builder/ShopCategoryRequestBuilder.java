package com.tradespeople.model.builder;

import org.springframework.stereotype.Component;

import com.tradespeople.common.builder.RequestBuilder;
import com.tradespeople.json.request.ShopCategoryRequest;
import com.tradespeople.model.Shopcategory;

@Component
public class ShopCategoryRequestBuilder extends RequestBuilder<ShopCategoryRequest, Shopcategory>  {

	@Override
	public ShopCategoryRequest build() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shopcategory build(ShopCategoryRequest obj) {
		Shopcategory shopcategory=new Shopcategory();
		shopcategory.setId(obj.getId());
		shopcategory.setMediapath(obj.getMediapath());
		shopcategory.setStatus(obj.getStatus());
		shopcategory.setName(obj.getName());
		return shopcategory;
	}

	@Override
	public ShopCategoryRequest build(Shopcategory model) {
		ShopCategoryRequest shopcategory=new ShopCategoryRequest();
		shopcategory.setId(model.getId());
		shopcategory.setMediapath(model.getMediapath());
		shopcategory.setStatus(model.getStatus());
		shopcategory.setName(model.getName());
		return shopcategory;
	}

}
