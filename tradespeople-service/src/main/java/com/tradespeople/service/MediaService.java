package com.tradespeople.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.dao.IMediaHibernateDao;
import com.tradespeople.json.request.MediaRequest;
import com.tradespeople.model.Media;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;

@Service
public class MediaService implements IMediaService{

	@Autowired
	private
	IMediaHibernateDao mediaDao;
	
	@Override
	@Transactional
	public void create(Media media) throws TradesPeopleServiceException {
		try {
			mediaDao.create(media);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	@Override
	@Transactional
	public void update(Media media) throws TradesPeopleServiceException {
		try {
			mediaDao.update(media);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Media getMediaBy(Long id) throws TradesPeopleServiceException {
		try {
			return mediaDao.getMediaBy(id);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<Media> getAllMedia() throws TradesPeopleServiceException {
		try {
			return mediaDao.getAllMedia();
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<Media> getAllMediaByStatus(Byte status)throws TradesPeopleServiceException {
		try {
			return mediaDao.getAllMediaByStatus(status);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}
	

	@Override
	@Transactional(readOnly=true)
	public List<Media> getAllMedia(PaginationSearchCriteria searchCriteria)throws TradesPeopleServiceException {
		try {
			return mediaDao.getAllMedia(searchCriteria);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	@Override
	public List<Media> getAllMediaByType(String type)throws TradesPeopleServiceException {
		try {
			return mediaDao.getAllMediaByType(type);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<Media> getAllMediaByType(String type, String status)
			throws TradesPeopleServiceException {
		try {
			return mediaDao.getAllMediaByType(type, status);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}
	

	@Override
	@Transactional(readOnly=true)
	public List<Media> getAllMediaByStatus(PaginationSearchCriteria searchCriteria,Byte status) throws TradesPeopleServiceException {
		try {
			return mediaDao.getAllMediaByStatus(searchCriteria,status);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}


	public IMediaHibernateDao getMediaDao() {
		return mediaDao;
	}

	public void setMediaDao(IMediaHibernateDao mediaDao) {
		this.mediaDao = mediaDao;
	}
}