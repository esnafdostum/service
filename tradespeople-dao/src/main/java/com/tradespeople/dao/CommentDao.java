package com.tradespeople.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tradespeople.common.api.BaseHibernateDaoSupport;
import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.Comment;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;

@Repository
public class CommentDao extends BaseHibernateDaoSupport implements ICommentHibernateDao {

	@Override
	public void create(Comment comment) throws TradesPeopleDaoException {
		try {
			getHibernateTemplate().save(comment);
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e);
		}
	}

	@Override
	public void update(Comment comment) throws TradesPeopleDaoException {
		try {
			getHibernateTemplate().update(comment);
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e);
		}
		
	}

	@Override
	public void delete(Comment comment) throws TradesPeopleDaoException {
		try {
			getHibernateTemplate().delete(comment);
		} catch (DataAccessException e) {
			throw new TradesPeopleDaoException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> listShopComments(PaginationSearchCriteria paginationSearchCriteria,Long shopId) throws TradesPeopleDaoException {
		Criteria criteria=createPaginationCriteria(Comment.class, paginationSearchCriteria);
		criteria.createAlias("shop", "shop");
		criteria.add(Restrictions.eq("shop.id", shopId));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> listUserComments(PaginationSearchCriteria searchCriteria, Long userId) throws TradesPeopleDaoException {
		Criteria criteria=createPaginationCriteria(Comment.class, searchCriteria);
		criteria.createAlias("user", "user");
		criteria.add(Restrictions.eq("user.id", userId));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> listCommentsByShopAndUser(PaginationSearchCriteria searchCriteria, Long userId, Long shopId)throws TradesPeopleDaoException {
		Criteria criteria=createPaginationCriteria(Comment.class, searchCriteria);
		criteria.createAlias("user", "user");
		criteria.createAlias("shop", "shop");
		criteria.add(Restrictions.eq("user.id", userId));
		criteria.add(Restrictions.eq("shop.id", shopId));
		return criteria.list();
	}

}
