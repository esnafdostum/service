package com.tradespeople.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tradespeople.common.api.BaseHibernateDaoSupport;
import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.Tag;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;

@Repository
public class TagDao extends BaseHibernateDaoSupport implements ITagHibernateDao {

	public void create(Tag tag) throws TradesPeopleDaoException{
		try {
			getHibernateTemplate().save(tag);
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e);
		}
	}

	@Override
	public void update(Tag tag) throws TradesPeopleDaoException {
		try {
			getHibernateTemplate().update(tag);
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tag> listTags(PaginationSearchCriteria searchCriteria)throws TradesPeopleDaoException {
		try {
			Criteria criteria=createPaginationCriteria(Tag.class, searchCriteria);
			return criteria.list();
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e);
		}
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Tag> getAllTagsByStatus(Byte status)
			throws TradesPeopleDaoException {
		try {
			return getSession().createCriteria(Tag.class)
					.add(Restrictions.eq("status", status))
					.list();
			} catch (DataAccessException e) {
				throw new TradesPeopleDaoException(e.getMessage());
			}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tag> getTagsByName(String name) throws TradesPeopleDaoException {
		try {
			return getSession().createCriteria(Tag.class)
					.add(Restrictions.eq("name", name))
					.list();
			} catch (DataAccessException e) {
				throw new TradesPeopleDaoException(e.getMessage());
			}
	}

	@Override
	public Tag getTagById(Long id) throws TradesPeopleDaoException {
		try {
			return  (Tag) getSession().createCriteria(Tag.class)
					.add(Restrictions.eq("id", id))
					.uniqueResult();
			} catch (DataAccessException e) {
				throw new TradesPeopleDaoException(e.getMessage());
			}
	}
	

}
