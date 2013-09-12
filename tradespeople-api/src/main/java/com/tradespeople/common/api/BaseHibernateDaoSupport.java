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
	
	
	public void getPaginationCriteria(Criteria criteria ,PaginationSearchCriteria paginationSearchCriteria){
		if (paginationSearchCriteria.hasPagination()) {
			criteria.setMaxResults(paginationSearchCriteria.getCount());
			criteria.setFirstResult(paginationSearchCriteria.getPage());
		}
	}

}
