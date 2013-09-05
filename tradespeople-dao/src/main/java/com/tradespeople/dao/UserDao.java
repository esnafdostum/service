package com.tradespeople.dao;

import org.springframework.stereotype.Repository;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.User;

@Repository
public class UserDao implements IUserHibernateDao {

	@Override
	public void create(User user) throws TradesPeopleDaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User user) throws TradesPeopleDaoException {
		// TODO Auto-generated method stub
		
	}

}
