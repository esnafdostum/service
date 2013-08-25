package com.tradespeople.service;

import java.util.List;

import com.tradespeople.common.api.PaginableRequest;
import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.json.request.ShopCategoryRequest;
import com.tradespeople.model.Shop;
import com.tradespeople.model.Shopcategory;

public interface IShopCategoryService {

	public void create(ShopCategoryRequest request) throws TradesPeopleServiceException;

	public void update(ShopCategoryRequest request) throws TradesPeopleServiceException;

	public List<Shop> listShopsByCategory(PaginableRequest request,Long categoryId) throws TradesPeopleServiceException;

	public List<Shopcategory> listCategoriesByShop(PaginableRequest request,Long shopId)  throws TradesPeopleServiceException;

}
