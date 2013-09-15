package com.tradespeople.service;

import java.util.List;

import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.json.request.MediaRequest;
import com.tradespeople.model.Media;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;

public interface IMediaService {
	
	void create(Media media) throws TradesPeopleServiceException;

	void update(Media media) throws TradesPeopleServiceException;

	Media getMediaBy(Long id) throws TradesPeopleServiceException;
	
	List<Media> getAllMedia() throws TradesPeopleServiceException;
	
	List<Media> getAllMediaByStatus(Byte status) throws TradesPeopleServiceException;
	
	List<Media> getAllMediaByType(String type) throws TradesPeopleServiceException;
	
	List<Media> getAllMediaByType(String type,String status) throws TradesPeopleServiceException;

	List<Media> getAllMedia(PaginationSearchCriteria searchCriteria) throws TradesPeopleServiceException;

	List<Media> getAllMediaByStatus(PaginationSearchCriteria buildFor,Byte status) throws TradesPeopleServiceException;

}
