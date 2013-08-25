package com.tradespeople.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.Shop;
import com.tradespeople.model.Shoptag;
import com.tradespeople.model.Tag;

@Repository
@Transactional
public class ShopTagDao implements IShopTagHibernateDao {

	@Override
	public void create(Shoptag shopTag) throws TradesPeopleDaoException {
		
	}

	@Override
	public void removeTagsFromShop(Shop shop, List<Tag> removedTags) throws TradesPeopleDaoException {
		
	}

}
