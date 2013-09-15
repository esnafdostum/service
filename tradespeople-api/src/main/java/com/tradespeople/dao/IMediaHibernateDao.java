package com.tradespeople.dao;

import java.util.List;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.Media;

public interface IMediaHibernateDao {

	void create(Media media) throws TradesPeopleDaoException;

	void update(Media media) throws TradesPeopleDaoException;

	Media getMediaBy(Long id) throws TradesPeopleDaoException;
	
	List<Media> getAllMedia() throws TradesPeopleDaoException;
	
	List<Media> getAllMediaByStatus(Byte status) throws TradesPeopleDaoException;
	
	List<Media> getAllMediaByType(String type) throws TradesPeopleDaoException;
	
	List<Media> getAllMediaByType(String type,String status) throws TradesPeopleDaoException;
}
