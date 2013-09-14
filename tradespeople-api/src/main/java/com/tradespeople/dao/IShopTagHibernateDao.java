package com.tradespeople.dao;

import java.util.List;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.Shop;
import com.tradespeople.model.Shoptag;
import com.tradespeople.model.Tag;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;

public interface IShopTagHibernateDao {

	public void create(Shoptag shopTag) throws TradesPeopleDaoException;

	public void update(Shoptag shoptag) throws TradesPeopleDaoException;
	
	public void removeTagsFromShop(Shop shop, List<Tag> removedTags) throws TradesPeopleDaoException;

	public List<Tag> listShopTags(PaginationSearchCriteria searchCriteria,Long shopId) throws TradesPeopleDaoException;

	public Shoptag findShopTagBy(Long shopId, Long tagId) throws TradesPeopleDaoException;

	public List<Shop> listShopsByTag(PaginationSearchCriteria searchCriteria,Long tagid) throws TradesPeopleDaoException;

	public List<Shoptag> getShopsTagsByStatus(Shop shop,Byte status) throws TradesPeopleDaoException;
	
	public List<Shoptag> getShopTags(Tag tag) throws TradesPeopleDaoException;
	
	public List<Shoptag> getShopsTagsByStatus(Tag tag,Byte status) throws TradesPeopleDaoException;

	Shoptag  getShopTagById(Long id) throws TradesPeopleDaoException;

}
