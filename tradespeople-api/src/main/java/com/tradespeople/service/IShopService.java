package com.tradespeople.service;

import java.util.List;

import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.model.Shop;

public interface IShopService {
	public void save(Shop shop) throws TradesPeopleServiceException;

	public void update(Shop shop) throws TradesPeopleServiceException;

	public List<Shop> getAllShops() throws TradesPeopleServiceException;
	
	public List<Shop> getAllShopsByStatus(Byte status) throws TradesPeopleServiceException;
	
	Shop  getShopById(Long id) throws TradesPeopleServiceException;

	List<Shop> getShopsByName(String name) throws TradesPeopleServiceException;
	
	List<Shop> getShopsByCity(String city) throws TradesPeopleServiceException;
}
