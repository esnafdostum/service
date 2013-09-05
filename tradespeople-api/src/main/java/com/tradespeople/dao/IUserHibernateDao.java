package com.tradespeople.dao;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.User;

public interface IUserHibernateDao {

	void create(User user) throws TradesPeopleDaoException;

	void update(User user) throws TradesPeopleDaoException;

	User getUserBy(Long id) throws TradesPeopleDaoException;

	User getUserBy(String username) throws TradesPeopleDaoException;

}
