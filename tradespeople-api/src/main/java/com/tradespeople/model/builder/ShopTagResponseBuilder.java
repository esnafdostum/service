package com.tradespeople.model.builder;

import org.springframework.stereotype.Component;

import com.tradespeople.common.builder.ResponseBuilder;
import com.tradespeople.json.response.ShopTagResponse;
import com.tradespeople.model.Shoptag;

@Component
public class ShopTagResponseBuilder extends ResponseBuilder<ShopTagResponse, Shoptag> {

	@Override
	public ShopTagResponse build() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shoptag build(ShopTagResponse obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShopTagResponse build(Shoptag model) {
		ShopTagResponse response=new ShopTagResponse();
		
		response.setShopId(model.getShop().getId());
		//response.setTags(tags);
		return null;
	}

}
