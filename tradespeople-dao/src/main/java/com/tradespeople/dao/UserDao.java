package com.tradespeople.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.User;

@Repository
public class UserDao extends HibernateDaoSupport implements IUserHibernateDao {

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
	
	public List<User> getusers(){
		return getHibernateTemplate().loadAll(User.class);
	}
	
	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(factory);
	}

}
