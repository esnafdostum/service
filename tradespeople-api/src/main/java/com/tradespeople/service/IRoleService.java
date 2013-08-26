package com.tradespeople.service;

import java.util.List;

import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.model.Role;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;

public interface IRoleService {

	void create(Role role) throws TradesPeopleServiceException;

	void update(Role role) throws TradesPeopleServiceException;

	void delete(Role role) throws TradesPeopleServiceException;

	List<Role> listRoles(PaginationSearchCriteria searchCriteria) throws TradesPeopleServiceException;
}
