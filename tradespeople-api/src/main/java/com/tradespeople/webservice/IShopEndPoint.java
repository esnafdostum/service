package com.tradespeople.webservice;

import java.util.List;

import com.tradespeople.common.api.BaseResponse;
import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.json.request.ShopRequest;
import com.tradespeople.json.response.ShopCollectionResponse;
import com.tradespeople.json.response.ShopResponse;
import com.tradespeople.model.Shop;

public interface IShopEndPoint {
	public BaseResponse save(ShopRequest shop);

	public BaseResponse update(ShopRequest shop);

	public ShopCollectionResponse getAllShops();
	
	public ShopCollectionResponse getAllShopsByStatus(Byte status);
	
	ShopResponse  getShopById(Long id);

	ShopCollectionResponse getShopsByName(String name);
	
	ShopCollectionResponse getShopsByCity(String city);
}
