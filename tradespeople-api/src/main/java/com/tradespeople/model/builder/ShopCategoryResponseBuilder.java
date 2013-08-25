package com.tradespeople.model.builder;

import org.springframework.stereotype.Component;

import com.tradespeople.common.builder.ResponseBuilder;
import com.tradespeople.json.response.ShopCategoryResponse;
import com.tradespeople.model.Shopcategory;

@Component
public class ShopCategoryResponseBuilder extends ResponseBuilder<ShopCategoryResponse, Shopcategory> {

	@Override
	public ShopCategoryResponse build() {
		return null;
	}

	@Override
	public Shopcategory build(ShopCategoryResponse obj) {
		Shopcategory model=new Shopcategory();
		model.setId(obj.getId());
		model.setName(obj.getName());
		model.setMediapath(obj.getMediapath());
		model.setStatus(obj.getStatus());
		model.setUpdateddate(obj.getUpdateddate());
		model.setCreateddate(obj.getCreatedDate());
		return model;
	}

	@Override
	public ShopCategoryResponse build(Shopcategory model) {
		ShopCategoryResponse response=new ShopCategoryResponse();
		response.setId(model.getId());
		response.setName(model.getName());
		response.setMediapath(model.getMediapath());
		response.setStatus(model.getStatus());
		response.setUpdateddate(model.getUpdateddate());
		response.setCreatedDate(model.getCreateddate());
		return response;
	}

}
