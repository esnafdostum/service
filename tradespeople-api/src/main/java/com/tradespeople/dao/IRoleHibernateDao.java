package com.tradespeople.dao;

import java.util.List;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.Role;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;

public interface IRoleHibernateDao {

	void save(Role role) throws TradesPeopleDaoException;

	void update(Role role) throws TradesPeopleDaoException;

	void delete(Role role) throws TradesPeopleDaoException;

	List<Role> listRoles(PaginationSearchCriteria searchCriteria) throws TradesPeopleDaoException;

}
