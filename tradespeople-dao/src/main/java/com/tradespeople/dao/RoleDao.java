package com.tradespeople.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.Role;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;

@Repository
public class RoleDao implements IRoleHibernateDao {

	@Override
	public void save(Role role) throws TradesPeopleDaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Role role) throws TradesPeopleDaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Role role) throws TradesPeopleDaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Role> listRoles(PaginationSearchCriteria searchCriteria)
			throws TradesPeopleDaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
