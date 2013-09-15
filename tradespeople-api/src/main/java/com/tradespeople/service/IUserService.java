package com.tradespeople.service;

import java.util.List;

import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.model.User;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;

public interface IUserService {

	void create(User user) throws TradesPeopleServiceException;

	void update(User user) throws TradesPeopleServiceException;

	public List<User> all(PaginationSearchCriteria searchCriteria) throws TradesPeopleServiceException;
	
	User getUserBy(Long id) throws TradesPeopleServiceException;

	User getUserBy(String username) throws TradesPeopleServiceException;
	
	User login(String user ,byte [] pass) throws TradesPeopleServiceException;
	
}
