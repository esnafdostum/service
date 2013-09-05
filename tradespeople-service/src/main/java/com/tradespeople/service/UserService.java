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
			if (isExistUserName(user.getUsername(),user.getId())) {
				ApiUtils.throwSameUserNameObligationException();
			}
			user.setCreateddate(new Date());
			user.setToken(generateUniqueUserToken(user));
			userDao.create(user);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}
	
	@Transactional(readOnly=true)
	private boolean isExistUserName(String username,Long id) throws TradesPeopleDaoException {
		User user =userDao.getUserBy(username);
		if (user==null) {
			return false;
		}
		if (user.getUsername().equals(username) && user.getId().equals(id)) {
			return false;
		}
		return true;
	}

	private String generateUniqueUserToken(User user) {
		StringBuilder sb=new StringBuilder();
		sb.append(user.getName());
		sb.append(user.getUsername());
		sb.append(user.getSurname());
		return sb.toString();
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
			if (isUserTokenChanged(user)) {
				ApiUtils.throwUserTokenNotChangedObligationException();
			}
			if (isExistUserName(user.getUsername(),user.getId())) {
				ApiUtils.throwSameUserNameObligationException();
			}
			user.setUpdateddate(new Date());
			userDao.update(user);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}
	
	@Transactional(readOnly=true)
	private boolean isUserTokenChanged(User user) throws TradesPeopleDaoException {
		User updatedUser=userDao.getUserBy(user.getId());
		if (user.getToken().equals(updatedUser.getToken())) {
			return false;
		}
		return true;
	}

	public void setUserDao(IUserHibernateDao userDao) {
		this.userDao = userDao;
	}

}
