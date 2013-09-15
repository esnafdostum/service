package com.tradespeople.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tradespeople.common.api.BaseHibernateDaoSupport;
import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.Media;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;

@Repository
public class MediaDao extends BaseHibernateDaoSupport implements IMediaHibernateDao {

	@Override
	public void create(Media media) throws TradesPeopleDaoException {
		try {
			getSession().save(media);
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e.getMessage());
		}
	}

	@Override
	public void update(Media media) throws TradesPeopleDaoException {
		try {
			getSession().update(media);
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e.getMessage());
		}
	}

	@Override
	public Media getMediaBy(Long id) throws TradesPeopleDaoException {
		try {
			return (Media) getSession().createCriteria(Media.class)
					.add(Restrictions.eq("id", id)).uniqueResult();
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Media> getAllMedia() throws TradesPeopleDaoException {
		try {
			return getSession().createCriteria(Media.class).list();
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Media> getAllMediaByStatus(Byte status)throws TradesPeopleDaoException {
		try {
			return getSession().createCriteria(Media.class)
					.add(Restrictions.eq("status", status)).list();
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Media> getAllMediaByType(String type)throws TradesPeopleDaoException {
		try {
			return getSession().createCriteria(Media.class)
					.add(Restrictions.eq("type", type)).list();
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Media> getAllMediaByType(String type, String status)throws TradesPeopleDaoException {
		try {
			return getSession().createCriteria(Media.class)
					.add(Restrictions.eq("type", type))
					.add(Restrictions.eq("status", status)).list();
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Media> getAllMedia(PaginationSearchCriteria searchCriteria)throws TradesPeopleDaoException {
		try {
			return createPaginationCriteria(Media.class, searchCriteria).list();
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Media> getAllMediaByStatus(PaginationSearchCriteria searchCriteria, Byte status)throws TradesPeopleDaoException {
		try {
			Criteria criteria=createPaginationCriteria(Media.class, searchCriteria);
			return criteria.add(Restrictions.eq("status", status)).list();
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e.getMessage());
		}
	}

}
