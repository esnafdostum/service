package com.tradespeople.common.api;

import org.apache.commons.lang.StringUtils;
import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tradespeople.searchcriteria.PaginationSearchCriteria;
import com.tradespeople.utils.ApiConstants;

public class BaseHibernateDaoSupport extends HibernateDaoSupport {
	
	private static  final String STATUS_ALIAS="status"; 
	
	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	public Criteria createPaginationCriteria(Class clazz ,PaginationSearchCriteria paginationSearchCriteria){
		Criteria criteria=getSession().createCriteria(clazz);
		if (paginationSearchCriteria!=null && paginationSearchCriteria.hasPagination()) {
			paginationSearchCriteria.setTotal(Integer.valueOf(criteria.setProjection(Projections.rowCount()).uniqueResult().toString()));
			criteria.setProjection(null);
			criteria.setMaxResults(paginationSearchCriteria.getCount());
			criteria.setFirstResult(paginationSearchCriteria.getPage());
		}
		
		if (StringUtils.isNotBlank(paginationSearchCriteria.getSortBy()))
            criteria.addOrder(paginationSearchCriteria.isSortDescending() ? Order
                    .desc(paginationSearchCriteria.getSortBy()) : Order
                    .asc(paginationSearchCriteria.getSortBy()));
		if (paginationSearchCriteria.isCached()) {
            criteria.setCacheable(true).setCacheMode(CacheMode.NORMAL);
        }
		
		return criteria;
	}
	
	public void addActiveStatusRestrictions(Criteria criteria){
		criteria.add(Restrictions.eq(STATUS_ALIAS, ApiConstants.Enums.BaseStatus.Active.getValue()));
	}
	
	public void addPassiveStatusRestrictions(Criteria criteria){
		criteria.add(Restrictions.eq(STATUS_ALIAS, ApiConstants.Enums.BaseStatus.Passive.getValue()));
	}

}
