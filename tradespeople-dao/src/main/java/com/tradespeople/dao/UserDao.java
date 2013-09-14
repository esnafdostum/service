package com.tradespeople.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tradespeople.common.api.BaseHibernateDaoSupport;
import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.User;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;

@Repository
public class UserDao extends BaseHibernateDaoSupport implements IUserHibernateDao {

	@Override
	public void create(User user) throws TradesPeopleDaoException {
		try {
			getSession().save(user);
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e.getMessage());
		}
	}

	@Override
	public void update(User user) throws TradesPeopleDaoException {
		try {
			getSession().update(user);
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e.getMessage());
		}
	}

	@Override
	public User getUserBy(Long id) throws TradesPeopleDaoException {
		try {
		return (User) getSession().createCriteria(User.class).add(Restrictions.eq("id",id)).uniqueResult();
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e.getMessage());
		}
	}

	@Override
	public User getUserBy(String username) throws TradesPeopleDaoException {
		try {
			return (User) getSession().createCriteria(User.class).add(Restrictions.eq("username",username)).uniqueResult();
			} catch (DataAccessException e) {
				throw new TradesPeopleDaoException(e.getMessage());
	}
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers(PaginationSearchCriteria paginationSearchCriteria) throws TradesPeopleDaoException {
		Criteria criteria=createPaginationCriteria(User.class, paginationSearchCriteria);
		return criteria.list();
	}
	
}
