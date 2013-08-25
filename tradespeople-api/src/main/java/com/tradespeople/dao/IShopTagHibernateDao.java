package com.tradespeople.dao;

import java.util.List;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.Shop;
import com.tradespeople.model.Shoptag;
import com.tradespeople.model.Tag;

public interface IShopTagHibernateDao {

	public void create(Shoptag shopTag) throws TradesPeopleDaoException;

	public void removeTagsFromShop(Shop shop, List<Tag> removedTags) throws TradesPeopleDaoException;

}
