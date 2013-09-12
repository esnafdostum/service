package com.tradespeople.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.tradespeople.common.api.BaseHibernateDaoSupport;
import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.User;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;

@Repository
public class UserDao extends BaseHibernateDaoSupport implements IUserHibernateDao {

	@Override
	public void create(User user) throws TradesPeopleDaoException {
		getHibernateTemplate().save(user);
	}

	@Override
	public void update(User user) throws TradesPeopleDaoException {
		getHibernateTemplate().update(user);
		
	}

	@Override
	public User getUserBy(Long id) throws TradesPeopleDaoException {
		return getHibernateTemplate().get(User.class, id);
	}

	@Override
	public User getUserBy(String username) throws TradesPeopleDaoException {
		Criteria criteria=getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		return (User)criteria.uniqueResult();
	}
	
	public List<User> listUsers() throws TradesPeopleDaoException{
		return getHibernateTemplate().loadAll(User.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers(PaginationSearchCriteria paginationSearchCriteria) throws TradesPeopleDaoException {
		Criteria criteria=createPaginationCriteria(User.class, paginationSearchCriteria);
		return criteria.list();
	}
	
}
