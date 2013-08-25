package com.tradespeople.dao;

import java.util.List;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.Shop;
import com.tradespeople.model.Shopcategory;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;

public interface IShopCategoryHibernateDao {

	public void save(Shopcategory shopcategory) throws TradesPeopleDaoException;

	public void update(Shopcategory shopcategory) throws TradesPeopleDaoException;

	public List<Shop> listShopsByCategory(PaginationSearchCriteria paginationSearchCriteria,Long categoryId) throws TradesPeopleDaoException;

	public List<Shopcategory> listCategoriesByShop(PaginationSearchCriteria buildFor,Long shopId) throws TradesPeopleDaoException;

}
