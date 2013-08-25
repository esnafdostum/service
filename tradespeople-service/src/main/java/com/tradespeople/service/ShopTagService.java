package com.tradespeople.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tradespeople.common.api.PaginableRequest;
import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.dao.IShopTagHibernateDao;
import com.tradespeople.json.request.ShopTagRequest;
import com.tradespeople.json.request.TagRequest;
import com.tradespeople.model.Shoptag;
import com.tradespeople.model.Tag;
import com.tradespeople.model.builder.ShopTagBuilder;
import com.tradespeople.model.builder.TagBuilder;

@Service
public class ShopTagService implements IShopTagService {

	@Autowired
	private IShopTagHibernateDao shopTagDao;

	@Autowired
	private TagBuilder tagBuilder;
	
	@Autowired
	private ShopTagBuilder shopTagBuilder; 
	
	@Override
	public List<Tag> listShopTags(PaginableRequest request, Long shopId) throws TradesPeopleServiceException {
		return new ArrayList<Tag>();
	}

	@Transactional
	public void addTagsToShop(ShopTagRequest request) throws TradesPeopleServiceException {
		Long shopId=request.getShopId();
		for (TagRequest tagRequest : request.getTags()) {
			
			if (!isExistTagsFor(shopId,tagRequest.getId())) {
				Shoptag shopTag=new Shoptag();
				shopTag.setCreateddate(new Date());
				try {
					shopTagDao.create(shopTag);
				} catch (TradesPeopleDaoException e) {
					throw new TradesPeopleServiceException(e);
				}
			}
			
		}
	}
	
	private boolean isExistTagsFor(Long shopId, Long id) {
		// TODO Auto-generated method stub
		return false;
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
