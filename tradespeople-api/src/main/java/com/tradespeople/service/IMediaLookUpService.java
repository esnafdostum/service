package com.tradespeople.service;

import java.util.List;

import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.model.Medialookup;
import com.tradespeople.model.Shop;
import com.tradespeople.model.User;

public interface IMediaLookUpService {
	
	void create(Medialookup medialookup) throws TradesPeopleServiceException;

	void update(Medialookup medialookup) throws TradesPeopleServiceException;

	Medialookup getMediaLookupBy(Long id) throws TradesPeopleServiceException;
	
	List<Medialookup> getAllMediaLookUp() throws TradesPeopleServiceException;
	
	List<Medialookup> getAllMediaLookUpByStatus(Byte status) throws TradesPeopleServiceException;
	
	List<Medialookup> getAllMediaLookupByUser() throws TradesPeopleServiceException;
	
	List<Medialookup> getAllMediaLookUpByShop() throws TradesPeopleServiceException;
	
	List<Medialookup> getMediaByLookUpUser(User user) throws TradesPeopleServiceException;
	
	List<Medialookup> getMediaLookUpByShop(Shop shop) throws TradesPeopleServiceException;


}
