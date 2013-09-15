package com.tradespeople.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.dao.IShopHibernateDao;
import com.tradespeople.model.Shop;

@Service
public class ShopService implements IShopService{
	
	@Autowired
	private
	IShopHibernateDao shopHibernateDao;

	@Override
	@Transactional
	public void save(Shop shop) throws TradesPeopleServiceException {
		try {
			shopHibernateDao.save(shop);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	@Override
	@Transactional
	public void update(Shop shop) throws TradesPeopleServiceException {
		try {
			shopHibernateDao.update(shop);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	@Override
	@Transactional
	public List<Shop> getAllShops() throws TradesPeopleServiceException {
		try {
			return shopHibernateDao.getAllShops();
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	@Override
	@Transactional
	public List<Shop> getAllShopsByStatus(Byte status)
			throws TradesPeopleServiceException {
		try {
			return shopHibernateDao.getAllShopsByStatus(status);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	@Override
	@Transactional
	public Shop getShopById(Long id) throws TradesPeopleServiceException {
		try {
			return shopHibernateDao.getShopById(id);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	@Override
	@Transactional
	public List<Shop> getShopsByName(String name)
			throws TradesPeopleServiceException {
		try {
			return shopHibernateDao.getShopsByName(name);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	@Override
	@Transactional
	public List<Shop> getShopsByCity(String city)
			throws TradesPeopleServiceException {
		try {
			return shopHibernateDao.getShopsByCity(city);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	public IShopHibernateDao getShopHibernateDao() {
		return shopHibernateDao;
	}

	public void setShopHibernateDao(IShopHibernateDao shopHibernateDao) {
		this.shopHibernateDao = shopHibernateDao;
	}

}
