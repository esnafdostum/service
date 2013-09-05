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

	@Override
	public User getUserBy(Long id) throws TradesPeopleDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserBy(String username) throws TradesPeopleDaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
