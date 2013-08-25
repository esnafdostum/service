package com.tradespeople.dao;

import org.springframework.stereotype.Repository;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.Shoptag;

@Repository
public class ShopTagDao implements IShopTagHibernateDao {

	@Override
	public void create(Shoptag shopTag) throws TradesPeopleDaoException {
		
	}

}
