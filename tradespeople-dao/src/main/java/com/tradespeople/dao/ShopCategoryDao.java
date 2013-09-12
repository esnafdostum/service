package com.tradespeople.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tradespeople.common.api.BaseHibernateDaoSupport;
import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.Shop;
import com.tradespeople.model.Shopcategory;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;

@Repository
public class ShopCategoryDao extends BaseHibernateDaoSupport implements IShopCategoryHibernateDao {

	@Override
	public void save(Shopcategory shopcategory) throws TradesPeopleDaoException {
		try {
			getHibernateTemplate().save(shopcategory);
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e);
		}
		
	}

	@Override
	public void update(Shopcategory shopcategory)throws TradesPeopleDaoException {
		try {
			getHibernateTemplate().update(shopcategory);
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shop> listShopsByCategory(PaginationSearchCriteria paginationSearchCriteria,Long categoryId) throws TradesPeopleDaoException {
		try {
			Criteria criteria=createPaginationCriteria(Shop.class, paginationSearchCriteria);
			criteria.createAlias("shopcategory", "shopcategory");
			criteria.add(Restrictions.eq("shopcategory.id", categoryId));
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			addActiveStatusRestrictions(criteria);
			return criteria.list();
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shopcategory> listCategoriesByShop(PaginationSearchCriteria paginationSearchCriteria, Long shopId)throws TradesPeopleDaoException {
		try {
			Criteria criteria=createPaginationCriteria(Shopcategory.class, paginationSearchCriteria);
			criteria.createAlias("shops", "shops");
			criteria.add(Restrictions.eq("shops.id", shopId));
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			addActiveStatusRestrictions(criteria);
			return criteria.list();
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e);
		}
	}

}
