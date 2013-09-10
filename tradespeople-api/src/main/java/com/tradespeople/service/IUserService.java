package com.tradespeople.service;

import java.util.List;

import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.model.User;

public interface IUserService {

	void create(User user) throws TradesPeopleServiceException;
	void update(User user)throws TradesPeopleServiceException;
	public List<User> all();
}
