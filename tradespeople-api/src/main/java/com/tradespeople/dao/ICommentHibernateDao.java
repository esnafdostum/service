package com.tradespeople.dao;

import java.util.List;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.Comment;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;

public interface ICommentHibernateDao {

	void create(Comment buildFor) throws  TradesPeopleDaoException;

	void update(Comment buildFor) throws  TradesPeopleDaoException;

	void delete(Comment comment) throws  TradesPeopleDaoException;

	List<Comment> listShopCategories(PaginationSearchCriteria buildFor, Long shopId) throws  TradesPeopleDaoException;
}
