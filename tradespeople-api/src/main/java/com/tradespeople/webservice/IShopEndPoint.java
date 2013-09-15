package com.tradespeople.webservice;

import com.tradespeople.common.api.BaseResponse;
import com.tradespeople.json.request.ShopRequest;
import com.tradespeople.json.response.ShopCollectionResponse;
import com.tradespeople.json.response.ShopResponse;

public interface IShopEndPoint {
	public BaseResponse save(ShopRequest shop);

	public BaseResponse update(ShopRequest shop);

	public ShopCollectionResponse getAllShops();
	
	public ShopCollectionResponse getAllShopsByStatus(Byte status);
	
	ShopResponse  getShopById(Long id);

	ShopCollectionResponse getShopsByName(String name);
	
	ShopCollectionResponse getShopsByCity(String city);
}
