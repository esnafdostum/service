package com.tradespeople.service;

import java.util.List;

import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.model.Media;

public interface IMediaService {
	
	void create(Media media) throws TradesPeopleServiceException;

	void update(Media media) throws TradesPeopleServiceException;

	Media getMediaBy(Long id) throws TradesPeopleServiceException;
	
	List<Media> getAllMedia() throws TradesPeopleServiceException;
	
	List<Media> getAllMediaByStatus(Byte status) throws TradesPeopleServiceException;
	
	List<Media> getAllMediaByType(String type) throws TradesPeopleServiceException;
	
	List<Media> getAllMediaByType(String type,String status) throws TradesPeopleServiceException;

}
