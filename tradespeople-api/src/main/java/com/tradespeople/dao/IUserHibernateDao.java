package com.tradespeople.dao;

import java.util.List;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.User;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;

public interface IUserHibernateDao {

	void create(User user) throws TradesPeopleDaoException;
	
	List<User> listUsers() throws TradesPeopleDaoException;

	void update(User user) throws TradesPeopleDaoException;

	User getUserBy(Long id) throws TradesPeopleDaoException;

	User getUserBy(String username) throws TradesPeopleDaoException;
	
	List<User> listUsers(PaginationSearchCriteria searchCriteria) throws TradesPeopleDaoException;

}
