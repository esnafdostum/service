package com.tradespeople.dao;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.Tag;


public interface ITagHibernateDao{

	public void create(Tag tag) throws TradesPeopleDaoException;

	public void update(Tag tag) throws TradesPeopleDaoException;

}
