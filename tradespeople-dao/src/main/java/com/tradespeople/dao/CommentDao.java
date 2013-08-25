package com.tradespeople.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.Comment;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;

@Repository
public class CommentDao implements ICommentHibernateDao {

	@Override
	public void create(Comment buildFor) throws TradesPeopleDaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Comment buildFor) throws TradesPeopleDaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Comment comment) throws TradesPeopleDaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Comment> listShopCategories(PaginationSearchCriteria buildFor,Long shopId) throws TradesPeopleDaoException {
		// TODO Auto-generated method stub
		return null;
	}

}
