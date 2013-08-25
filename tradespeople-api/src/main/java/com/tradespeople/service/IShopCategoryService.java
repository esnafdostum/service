package com.tradespeople.service;

import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.json.request.ShopCategoryRequest;

public interface IShopCategoryService {

	public void create(ShopCategoryRequest request) throws TradesPeopleServiceException;

	public void update(ShopCategoryRequest request) throws TradesPeopleServiceException;

}
