package com.tradespeople.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.dao.IMediaLooUpHibernateDao;
import com.tradespeople.model.Medialookup;
import com.tradespeople.model.Shop;
import com.tradespeople.model.User;

@Service
public class MediaLookUpService implements IMediaLookUpService{

	@Autowired
	private
	IMediaLooUpHibernateDao mediaLooUpHibernateDao;
	
	
	@Override
	@Transactional
	public void create(Medialookup medialookup)
			throws TradesPeopleServiceException {
		try {
			mediaLooUpHibernateDao.create(medialookup);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	@Override
	@Transactional
	public void update(Medialookup medialookup)
			throws TradesPeopleServiceException {
		try {
			mediaLooUpHibernateDao.update(medialookup);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	@Override
	@Transactional
	public Medialookup getMediaLookupBy(Long id)
			throws TradesPeopleServiceException {
		try {
			return mediaLooUpHibernateDao.getMediaLookupBy(id);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	@Override
	@Transactional
	public List<Medialookup> getAllMediaLookUp()
			throws TradesPeopleServiceException {
		try {
			return mediaLooUpHibernateDao.getAllMediaLookUp();
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	@Override
	@Transactional
	public List<Medialookup> getAllMediaLookUpByStatus(Byte status)
			throws TradesPeopleServiceException {
		try {
			return mediaLooUpHibernateDao.getAllMediaLookUpByStatus(status);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	@Override
	@Transactional
	public List<Medialookup> getAllMediaLookupByUser()
			throws TradesPeopleServiceException {
		try {
			return mediaLooUpHibernateDao.getAllMediaLookupByUser();
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	@Override
	@Transactional
	public List<Medialookup> getAllMediaLookUpByShop()
			throws TradesPeopleServiceException {
		try {
			return mediaLooUpHibernateDao.getAllMediaLookUpByShop();
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	@Override
	@Transactional
	public List<Medialookup> getMediaByLookUpUser(User user)
			throws TradesPeopleServiceException {
		try {
			return mediaLooUpHibernateDao.getMediaByLookUpUser(user);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	@Override
	@Transactional
	public List<Medialookup> getMediaLookUpByShop(Shop shop)
			throws TradesPeopleServiceException {
		try {
			return mediaLooUpHibernateDao.getMediaLookUpByShop(shop);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}
	
	
	public IMediaLooUpHibernateDao getMediaLooUpHibernateDao() {
		return mediaLooUpHibernateDao;
	}

	public void setMediaLooUpHibernateDao(IMediaLooUpHibernateDao mediaLooUpHibernateDao) {
		this.mediaLooUpHibernateDao = mediaLooUpHibernateDao;
	}


}
