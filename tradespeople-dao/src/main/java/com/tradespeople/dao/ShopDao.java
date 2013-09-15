package com.tradespeople.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tradespeople.common.api.BaseHibernateDaoSupport;
import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.Shop;

@Repository
public class ShopDao extends BaseHibernateDaoSupport implements IShopHibernateDao {


	@Override
	public void save(Shop shop) throws TradesPeopleDaoException {
		try {
			getSession().save(shop);
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e.getMessage());
		}
	}

	@Override
	public void update(Shop shop) throws TradesPeopleDaoException {
		try {
			getSession().update(shop);
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shop> getAllShops() throws TradesPeopleDaoException {
		try {
			return getSession().createCriteria(Shop.class)
					.list();
			} catch (DataAccessException e) {
				throw new TradesPeopleDaoException(e.getMessage());
			}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shop> getAllShopsByStatus(Byte status) throws TradesPeopleDaoException {
		try {
			return getSession().createCriteria(Shop.class)
					.add(Restrictions.eq("status",status))
					.list();
			} catch (DataAccessException e) {
				throw new TradesPeopleDaoException(e.getMessage());
			}
	}

	@Override
	public Shop getShopById(Long id) throws TradesPeopleDaoException {
		try {
			return (Shop) getSession().createCriteria(Shop.class).add(Restrictions.eq("id",id)).uniqueResult();
			} catch (DataAccessException e) {
				throw new TradesPeopleDaoException(e.getMessage());
			}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shop> getShopsByName(String name)
			throws TradesPeopleDaoException {
		try {
			return getSession().createCriteria(Shop.class)
					.add(Restrictions.like("name",name))
					.list();
			} catch (DataAccessException e) {
				throw new TradesPeopleDaoException(e.getMessage());
			}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Shop> getShopsByCity(String city)
			throws TradesPeopleDaoException {
		try {
			return getSession().createCriteria(Shop.class)
					.add(Restrictions.like("city",city))
					.list();
			} catch (DataAccessException e) {
				throw new TradesPeopleDaoException(e.getMessage());
			}
}
	

}