package com.tradespeople.service;

import java.util.List;

import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.model.Shop;
import com.tradespeople.model.Shopcategory;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;

public interface IShopCategoryService {

	public void create(Shopcategory shopcategory) throws TradesPeopleServiceException;

	public void update(Shopcategory shopcategory) throws TradesPeopleServiceException;

	public List<Shop> listShopsByCategory(PaginationSearchCriteria searchCriteria,Long categoryId) throws TradesPeopleServiceException;

	public List<Shopcategory> listCategoriesByShop(PaginationSearchCriteria searchCriteria,Long shopId)  throws TradesPeopleServiceException;

}
