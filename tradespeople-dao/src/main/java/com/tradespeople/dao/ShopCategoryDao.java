package com.tradespeople.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.Shop;
import com.tradespeople.model.Shopcategory;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;

@Repository
public class ShopCategoryDao implements IShopCategoryHibernateDao {

	@Override
	public void save(Shopcategory shopcategory) throws TradesPeopleDaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Shopcategory shopcategory)
			throws TradesPeopleDaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Shop> listShopsByCategory(PaginationSearchCriteria paginationSearchCriteria,
			Long categoryId) throws TradesPeopleDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shopcategory> listCategoriesByShop(
			PaginationSearchCriteria buildFor, Long shopId)
			throws TradesPeopleDaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
