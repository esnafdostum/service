package com.tradespeople.service;

import java.util.List;

import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.json.request.ShopTagRequest;
import com.tradespeople.model.Shop;
import com.tradespeople.model.Shoptag;
import com.tradespeople.model.Tag;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;

public interface IShopTagService {
	
	public List<Tag> listShopTags(PaginationSearchCriteria searchCriteria, Long shopId) throws TradesPeopleServiceException ;

	public void addTagsToShop(ShopTagRequest request)  throws TradesPeopleServiceException;

	public void deleteTagsFromShop(ShopTagRequest request) throws TradesPeopleServiceException;

	public List<Shop> listShopsByTag(PaginationSearchCriteria searchCriteria, Long tagid) throws TradesPeopleServiceException;
	
	public void save(Shoptag shoptag) throws TradesPeopleServiceException;

	public void update(Shoptag shoptag) throws TradesPeopleServiceException;
	
	public List<Shoptag> getShopsTagsByStatus(Shop shop,Byte status) throws TradesPeopleServiceException;
	
	public List<Shoptag> getShopsTagsByStatus(Tag tag,Byte status) throws TradesPeopleServiceException;

	Shoptag  getShopTagById(Long id) throws TradesPeopleServiceException;
	
}
