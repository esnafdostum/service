package com.tradespeople.common.api;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseHibernateDaoSupport extends HibernateDaoSupport {
	
	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

}
