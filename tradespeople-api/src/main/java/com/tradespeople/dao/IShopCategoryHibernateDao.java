package com.tradespeople.dao;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.Shopcategory;

public interface IShopCategoryHibernateDao {

	void save(Shopcategory shopcategory) throws TradesPeopleDaoException;

	void update(Shopcategory shopcategory) throws TradesPeopleDaoException;

}
