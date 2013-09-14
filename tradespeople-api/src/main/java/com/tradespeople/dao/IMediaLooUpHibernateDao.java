package com.tradespeople.dao;

import java.util.List;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.Media;
import com.tradespeople.model.Medialookup;
import com.tradespeople.model.Shop;
import com.tradespeople.model.User;

public interface IMediaLooUpHibernateDao {

	void create(Medialookup medialookup) throws TradesPeopleDaoException;

	void update(Medialookup medialookup) throws TradesPeopleDaoException;

	Medialookup getMediaLookupBy(Long id) throws TradesPeopleDaoException;
	
	List<Medialookup> getAllMediaLookUp() throws TradesPeopleDaoException;
	
	List<Medialookup> getAllMediaLookUpByStatus(Byte status) throws TradesPeopleDaoException;
	
	List<Medialookup> getAllMediaLookupByUser() throws TradesPeopleDaoException;
	
	List<Medialookup> getAllMediaLookUpByShop() throws TradesPeopleDaoException;
	
	List<Medialookup> getMediaByLookUpUser(User user) throws TradesPeopleDaoException;
	
	List<Medialookup> getMediaLookUpByShop(Shop shop) throws TradesPeopleDaoException;


}
