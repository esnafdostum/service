package com.tradespeople.dao;

import java.util.List;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.Shop;

public interface IShopHibernateDao {

	public void save(Shop shop) throws TradesPeopleDaoException;

	public void update(Shop shop) throws TradesPeopleDaoException;

	public List<Shop> getAllShops() throws TradesPeopleDaoException;
	
	public List<Shop> getAllShopsByStatus(Byte status) throws TradesPeopleDaoException;
	
	Shop  getShopById(Long id) throws TradesPeopleDaoException;

	List<Shop> getShopsByName(String name) throws TradesPeopleDaoException;
	
	List<Shop> getShopsByCity(String city) throws TradesPeopleDaoException;

}
