package com.tradespeople.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.dao.IShopCategoryHibernateDao;
import com.tradespeople.model.Shop;
import com.tradespeople.model.Shopcategory;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;
import com.tradespeople.utils.ApiUtils;

@Service
public class ShopCategoryService implements IShopCategoryService {

	@Autowired
	private IShopCategoryHibernateDao shopCategoryDao;

	@Transactional 
	public void create(Shopcategory shopcategory)throws TradesPeopleServiceException {
		try {
			shopcategory.setCreateddate(new Date());
			shopCategoryDao.save(shopcategory);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}
	
	@Transactional(readOnly=true)
	public List<Shopcategory> listCategoriesByShop(PaginationSearchCriteria searchCriteria,Long shopId) throws TradesPeopleServiceException {
		try {
			return shopCategoryDao.listCategoriesByShop(searchCriteria,shopId);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}
	
	
	@Transactional(readOnly=true)
	public List<Shop> listShopsByCategory(PaginationSearchCriteria searchCriteria, Long categoryId) throws TradesPeopleServiceException {
		try {
			return shopCategoryDao.listShopsByCategory(searchCriteria,categoryId);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}
	
	@Transactional
	public void update(Shopcategory shopcategory)throws TradesPeopleServiceException {
		shopcategory.setUpdateddate(new Date());
		try {
			if (!shopcategory.hasPersisted()) {
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

}
