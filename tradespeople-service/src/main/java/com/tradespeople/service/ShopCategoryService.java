package com.tradespeople.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tradespeople.common.api.PaginableRequest;
import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.dao.IShopCategoryHibernateDao;
import com.tradespeople.json.request.ShopCategoryRequest;
import com.tradespeople.model.Shop;
import com.tradespeople.model.Shopcategory;
import com.tradespeople.model.builder.ShopCategoryBuilder;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;
import com.tradespeople.utils.ApiUtils;

@Service
public class ShopCategoryService implements IShopCategoryService {

	@Autowired
	private IShopCategoryHibernateDao shopCategoryDao;
	
	@Autowired
	private ShopCategoryBuilder shopCategoryBuilder; 

	@Transactional 
	public void create(ShopCategoryRequest request)throws TradesPeopleServiceException {
		try {
			Shopcategory shopcategory=shopCategoryBuilder.buildFor(request);
			shopcategory.setCreateddate(new Date());
			shopCategoryDao.save(shopcategory);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}
	
	@Transactional(readOnly=true)
	public List<Shopcategory> listCategoriesByShop(PaginableRequest request,Long shopId) throws TradesPeopleServiceException {
		try {
			return shopCategoryDao.listCategoriesByShop(PaginationSearchCriteria.buildFor(request),shopId);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}
	
	
	@Transactional(readOnly=true)
	public List<Shop> listShopsByCategory(PaginableRequest request, Long categoryId) throws TradesPeopleServiceException {
		try {
			return shopCategoryDao.listShopsByCategory(PaginationSearchCriteria.buildFor(request),categoryId);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}
	
	@Transactional
	public void update(ShopCategoryRequest request)throws TradesPeopleServiceException {
		Shopcategory shopcategory=shopCategoryBuilder.buildFor(request);
		shopcategory.setUpdateddate(new Date());
		try {
			if (!shopcategory.isPersisted()) {
			    ApiUtils.throwPersistedException();
			}
			shopCategoryDao.update(shopcategory);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}
	
	public void setShopCategoryDao(IShopCategoryHibernateDao shopCategoryDao) {
		this.shopCategoryDao = shopCategoryDao;
	}

	public void setShopCategoryBuilder(ShopCategoryBuilder shopCategoryBuilder) {
		this.shopCategoryBuilder = shopCategoryBuilder;
	}

}
