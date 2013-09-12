package com.tradespeople.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.dao.ICommentHibernateDao;
import com.tradespeople.model.Comment;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;
import com.tradespeople.utils.ApiUtils;

@Service
public class CommentService implements ICommentService {
	
	@Autowired
	private ICommentHibernateDao commentHibernateDao;
	
	@Transactional
	public void create(Comment comment)throws TradesPeopleServiceException {
		try {
			comment.setCreateddate(new Date());
			commentHibernateDao.create(comment);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}
	
	@Transactional
	public void update(Comment comment)throws TradesPeopleServiceException {
		try {
			if (!comment.hasPersisted()) {
				ApiUtils.throwPersistedException();
			}
			commentHibernateDao.update(comment);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}
	
	@Transactional
	public void delete(Comment comment)throws TradesPeopleServiceException {
		try {
			if (!comment.hasPersisted()) {
				ApiUtils.throwPersistedException();
			}
			commentHibernateDao.delete(comment);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}
	

	@Transactional(readOnly=true)
	public List<Comment> listShopComments(PaginationSearchCriteria searchCriteria, Long shopId) throws TradesPeopleServiceException {
		try {
			return commentHibernateDao.listShopComments(searchCriteria,shopId);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}
	
	@Transactional(readOnly=true)
	public List<Comment> listUserComments(PaginationSearchCriteria searchCriteria,Long userId) throws TradesPeopleServiceException {
		try {
			return commentHibernateDao.listUserComments(searchCriteria,userId);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}
	
	@Transactional(readOnly=true)
	public List<Comment> listCommentsByShopAndUser(PaginationSearchCriteria searchCriteria, Long userId, Long shopId) throws TradesPeopleServiceException {
		try {
			return commentHibernateDao.listCommentsByShopAndUser(searchCriteria,userId,shopId);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	
	public void setCommentHibernateDao(ICommentHibernateDao commentHibernateDao) {
		this.commentHibernateDao = commentHibernateDao;
	}


}
