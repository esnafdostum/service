package com.tradespeople.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.tradespeople.common.api.BaseHibernateDaoSupport;
import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.Medialookup;
import com.tradespeople.model.Shop;
import com.tradespeople.model.User;
@Repository
public class MediaLookupDao extends BaseHibernateDaoSupport implements
		IMediaLooUpHibernateDao {

	@Override
	public void create(Medialookup medialookup) throws TradesPeopleDaoException {
		try {
			getSession().save(medialookup);
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e.getMessage());
		}
	}

	@Override
	public void update(Medialookup medialookup) throws TradesPeopleDaoException {
		try {
			getSession().update(medialookup);
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e.getMessage());
		}
	}

	@Override
	public Medialookup getMediaLookupBy(Long id)
			throws TradesPeopleDaoException {
		try {
			return (Medialookup) getSession().createCriteria(Medialookup.class)
					.add(Restrictions.eq("id", id)).uniqueResult();
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medialookup> getAllMediaLookUp() throws TradesPeopleDaoException {
		try {
			return getSession().createCriteria(Medialookup.class).list();
			} catch (DataAccessException e) {
				throw new TradesPeopleDaoException(e.getMessage());
			}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medialookup> getAllMediaLookUpByStatus(Byte status)
			throws TradesPeopleDaoException {
		try {
			return getSession().createCriteria(Medialookup.class).add(Restrictions.eq("status",status)).list();
			} catch (DataAccessException e) {
				throw new TradesPeopleDaoException(e.getMessage());
			}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medialookup> getAllMediaLookupByUser()
			throws TradesPeopleDaoException {
		try {
			return getSession().createCriteria(Medialookup.class).add(Restrictions.isNotNull("user")).list();
			} catch (DataAccessException e) {
				throw new TradesPeopleDaoException(e.getMessage());
			}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medialookup> getAllMediaLookUpByShop()
			throws TradesPeopleDaoException {
		try {
			return getSession().createCriteria(Medialookup.class).add(Restrictions.isNotNull("shop")).list();
			} catch (DataAccessException e) {
				throw new TradesPeopleDaoException(e.getMessage());
			}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medialookup> getMediaByLookUpUser(User user)
			throws TradesPeopleDaoException {
		try {
			return getSession().createCriteria(Medialookup.class).add(Restrictions.eq("user",user)).list();
			} catch (DataAccessException e) {
				throw new TradesPeopleDaoException(e.getMessage());
			}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Medialookup> getMediaLookUpByShop(Shop shop)
			throws TradesPeopleDaoException {
		try {
			return getSession().createCriteria(Medialookup.class).add(Restrictions.eq("shop",shop)).list();
			} catch (DataAccessException e) {
				throw new TradesPeopleDaoException(e.getMessage());
			}
	}

}
