package com.tradespeople.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.dao.IShopTagHibernateDao;
import com.tradespeople.json.request.ShopTagRequest;
import com.tradespeople.json.request.TagRequest;
import com.tradespeople.model.Shop;
import com.tradespeople.model.Shoptag;
import com.tradespeople.model.Tag;
import com.tradespeople.model.builder.ShopTagBuilder;
import com.tradespeople.model.builder.TagBuilder;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;

@Service
public class ShopTagService implements IShopTagService {

	@Autowired
	private IShopTagHibernateDao shopTagDao;

	@Autowired
	private TagBuilder tagBuilder;
	
	@Autowired
	private ShopTagBuilder shopTagBuilder; 
	
	@Transactional(readOnly=true)
	public List<Tag> listShopTags(PaginationSearchCriteria searchCriteria, Long shopId) throws TradesPeopleServiceException {
		try {
			return shopTagDao.listShopTags(searchCriteria,shopId);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	@Transactional
	public void addTagsToShop(ShopTagRequest request) throws TradesPeopleServiceException {
		Long shopId=request.getShopId();
		Shop shop=new Shop();
		shop.setId(shopId);
		for (TagRequest tagRequest : request.getTags()) {
			
			if (isNotExistTagsFor(shopId,tagRequest.getId())) {
				Shoptag shopTag=new Shoptag();
				shopTag.setTag(tagBuilder.buildFor(tagRequest));
				shopTag.setShop(shop);
				shopTag.setCreateddate(new Date());
				try {
					shopTagDao.create(shopTag);
				} catch (TradesPeopleDaoException e) {
					throw new TradesPeopleServiceException(e);
				}
			}
		}
	}
	
	@Override
	public List<Shop> listShopsByTag(PaginationSearchCriteria searchCriteria, Long tagid) throws TradesPeopleServiceException {
		try {
			return shopTagDao.listShopsByTag(searchCriteria,tagid);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}
	
	@Transactional
	public void deleteTagsFromShop(ShopTagRequest request) throws TradesPeopleServiceException {
		Long shopId=request.getShopId();
		Shop shop=new Shop();
		shop.setId(shopId);
		List<Tag> removedTags=new ArrayList<Tag>();
		
		for (TagRequest tagRequest : request.getTags()) {
			removedTags.add(tagBuilder.buildFor(tagRequest));
		}
		try {
			shopTagDao.removeTagsFromShop(shop,removedTags);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
		
	}
	
	@Transactional
	private boolean isNotExistTagsFor(Long shopId, Long tagId) throws TradesPeopleServiceException {
		try {
			Shoptag shoptag=shopTagDao.findShopTagBy(shopId,tagId);
			if (shoptag==null) {
				return true;
			}else{
				return false;
			}
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	public void setShopTagDao(IShopTagHibernateDao shopTagDao) {
		this.shopTagDao = shopTagDao;
	}

	public void setTagBuilder(TagBuilder tagBuilder) {
		this.tagBuilder = tagBuilder;
	}

	public void setShopTagBuilder(ShopTagBuilder shopTagBuilder) {
		this.shopTagBuilder = shopTagBuilder;
	}

}
