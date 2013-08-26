package com.tradespeople.service;

import java.util.List;

import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.json.request.ShopTagRequest;
import com.tradespeople.model.Shop;
import com.tradespeople.model.Tag;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;

public interface IShopTagService {
	
	public List<Tag> listShopTags(PaginationSearchCriteria searchCriteria, Long shopId) throws TradesPeopleServiceException ;

	public void addTagsToShop(ShopTagRequest request)  throws TradesPeopleServiceException;

	public void deleteTagsFromShop(ShopTagRequest request) throws TradesPeopleServiceException;

	public List<Shop> listShopsByTag(PaginationSearchCriteria searchCriteria, Long tagid) throws TradesPeopleServiceException;
	
}
