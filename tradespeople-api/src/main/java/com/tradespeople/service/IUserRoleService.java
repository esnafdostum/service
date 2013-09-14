package com.tradespeople.service;

import java.util.List;

import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.model.Role;
import com.tradespeople.model.User;
import com.tradespeople.model.Userrole;

public interface IUserRoleService {
	
	void create(Userrole userrole) throws TradesPeopleServiceException;

	void update(Userrole userrole) throws TradesPeopleServiceException;
	
	public void update(Long roleid,Long userid,Byte status) throws TradesPeopleServiceException;

	List<Userrole> getUserRole(User user) throws TradesPeopleServiceException;

	List<Userrole> getUserRole(Role role) throws TradesPeopleServiceException;

}
