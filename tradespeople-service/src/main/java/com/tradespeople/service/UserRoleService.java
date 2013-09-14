package com.tradespeople.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.dao.IUserRoleHibernateDao;
import com.tradespeople.model.Role;
import com.tradespeople.model.User;
import com.tradespeople.model.Userrole;

@Service
public class UserRoleService implements IUserRoleService{
	
	@Autowired
	private
	IUserRoleHibernateDao userRoleHibernateDao;

	@Override
	@Transactional
	public void create(Userrole userrole) throws TradesPeopleServiceException {
		try {
			userRoleHibernateDao.create(userrole);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	@Override
	@Transactional
	public void update(Userrole userrole) throws TradesPeopleServiceException {
		try {
			userRoleHibernateDao.update(userrole);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}
	
	@Override
	@Transactional
	public void update(Long roleid,Long userid,Byte status) throws TradesPeopleServiceException {
		try {
			userRoleHibernateDao.update(roleid,userid,status);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	@Override
	@Transactional
	public List<Userrole> getUserRole(User user)
			throws TradesPeopleServiceException {
		try {
			return userRoleHibernateDao.getUserRole(user);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	@Override
	@Transactional
	public List<Userrole> getUserRole(Role role)
			throws TradesPeopleServiceException {
		try {
			return userRoleHibernateDao.getUserRole(role);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	public IUserRoleHibernateDao getUserRoleHibernateDao() {
		return userRoleHibernateDao;
	}

	public void setUserRoleHibernateDao(IUserRoleHibernateDao userRoleHibernateDao) {
		this.userRoleHibernateDao = userRoleHibernateDao;
	}

}