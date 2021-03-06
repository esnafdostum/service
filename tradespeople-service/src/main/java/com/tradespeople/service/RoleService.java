package com.tradespeople.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.dao.IRoleHibernateDao;
import com.tradespeople.model.Role;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;
import com.tradespeople.utils.ApiUtils;

@Service
public class RoleService implements IRoleService {

	@Autowired
	private IRoleHibernateDao roleHibernateDao;
	
	@Transactional
	public void create(Role role) throws TradesPeopleServiceException {
		try {
			roleHibernateDao.save(role);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	@Transactional
	public void update(Role role) throws TradesPeopleServiceException {
		try {
			if (!role.hasPersisted()) {
				ApiUtils.throwPersistedException();
			}
			roleHibernateDao.update(role);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	@Transactional
	public void delete(Role role) throws TradesPeopleServiceException {
		try {
			if (!role.hasPersisted()) {
				ApiUtils.throwPersistedException();
			}
			if (isExistUserWith(role)) {
				ApiUtils.throwUsersHaveRoleException(role);
			}
			roleHibernateDao.delete(role);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	@Transactional
	private boolean isExistUserWith(Role role) throws TradesPeopleDaoException {
		Integer count=roleHibernateDao.findCountUsersOfRole(role);
		if (count!=null && count>0) {
			return true;
		}
		return false;
	}

	@Transactional(readOnly=true)
	public List<Role> listRoles(PaginationSearchCriteria searchCriteria)throws TradesPeopleServiceException {
		try {
			return roleHibernateDao.listRoles(searchCriteria);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	@Override
	@Transactional
	public List<Role> getAllRoles() throws TradesPeopleServiceException {
		try {
			return roleHibernateDao.getAllRoles();
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	@Override
	@Transactional
	public List<Role> getAllRolesByStatus(Byte status)
			throws TradesPeopleServiceException {
		try {
			return roleHibernateDao.getAllRolesByStatus(status);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	public void setRoleHibernateDao(IRoleHibernateDao roleHibernateDao) {
		this.roleHibernateDao = roleHibernateDao;
	}

}
