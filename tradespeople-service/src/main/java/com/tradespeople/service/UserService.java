package com.tradespeople.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.dao.IUserHibernateDao;
import com.tradespeople.model.User;
import com.tradespeople.utils.ApiUtils;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserHibernateDao userDao;

	@Transactional
	public void create(User user)throws TradesPeopleServiceException {
		try {
			if (user.isPersisted()) {
				ApiUtils.throwNotPersistedException();
			}
			if (user.isNotExistAnyRole()) {
				ApiUtils.throwUserRolesObligationException();
			}
			user.setCreateddate(new Date());
			userDao.create(user);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}
	
	@Transactional
	public void update(User user)throws TradesPeopleServiceException {
		try {
			if (!user.isPersisted()) {
				ApiUtils.throwPersistedException();
			}
			if (user.isNotExistAnyRole()) {
				ApiUtils.throwUserRolesObligationException();
			}
			user.setUpdateddate(new Date());
			userDao.update(user);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}
	
	public void setUserDao(IUserHibernateDao userDao) {
		this.userDao = userDao;
	}

}
