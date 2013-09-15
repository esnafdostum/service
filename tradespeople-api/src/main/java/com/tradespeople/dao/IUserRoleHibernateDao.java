package com.tradespeople.dao;

import java.util.List;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.Role;
import com.tradespeople.model.User;
import com.tradespeople.model.Userrole;

public interface IUserRoleHibernateDao {

	void create(Userrole userrole) throws TradesPeopleDaoException;

	void update(Userrole userrole) throws TradesPeopleDaoException;
	
	public void update(Long roleid,Long userid,Byte status) throws TradesPeopleDaoException;

	List<Userrole> getUserRole(User user) throws TradesPeopleDaoException;

	List<Userrole> getUserRole(Role role) throws TradesPeopleDaoException;
}
