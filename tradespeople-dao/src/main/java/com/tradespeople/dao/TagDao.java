package com.tradespeople.dao;

import org.springframework.stereotype.Repository;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.Tag;

@Repository
public class TagDao implements ITagHibernateDao {

	public void create(Tag tag) throws TradesPeopleDaoException{
		
	}

	@Override
	public void update(Tag tag) throws TradesPeopleDaoException {
		
	}
}
