package com.tradespeople.dao;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.Shoptag;

public interface IShopTagHibernateDao {

	public void create(Shoptag shopTag) throws TradesPeopleDaoException;

}
