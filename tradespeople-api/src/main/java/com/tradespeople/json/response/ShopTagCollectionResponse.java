package com.tradespeople.json.response;

import java.util.ArrayList;
import java.util.List;

import com.tradespeople.common.api.BaseResponse;

public class ShopTagCollectionResponse extends BaseResponse{

	List<ShopTagResponse> responses;
	
	public ShopTagCollectionResponse() {
		responses=new ArrayList<ShopTagResponse>();
	}
	
	public void add(ShopTagResponse response)
	{
		responses.add(response);
	}
}
