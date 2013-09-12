package com.tradespeople.common.api;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tradespeople.searchcriteria.PaginationSearchCriteria;

public class BaseHibernateDaoSupport extends HibernateDaoSupport {
	
	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}
	
	
	public Criteria createPaginationCriteria(Class clazz ,PaginationSearchCriteria paginationSearchCriteria){
		Criteria criteria=getSession().createCriteria(clazz);
		if (paginationSearchCriteria.hasPagination()) {
			criteria.setMaxResults(paginationSearchCriteria.getCount());
			criteria.setFirstResult(paginationSearchCriteria.getPage());
		}
		return criteria;
	}

}
