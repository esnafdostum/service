package com.tradespeople.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tradespeople.common.api.PaginableRequest;
import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.dao.ICommentHibernateDao;
import com.tradespeople.json.request.CommentRequest;
import com.tradespeople.model.Comment;
import com.tradespeople.model.builder.CommentBuilder;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;
import com.tradespeople.utils.ApiUtils;

@Service
public class CommentService implements ICommentService {
	
	@Autowired
	private ICommentHibernateDao commentHibernateDao;
	
	@Autowired
	private CommentBuilder commentBuilder;
	
	
	@Transactional
	public void create(CommentRequest request)throws TradesPeopleServiceException {
		try {
			Comment comment=commentBuilder.buildFor(request);
			comment.setCreateddate(new Date());
			commentHibernateDao.create(comment);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}
	
	@Transactional
	public void update(CommentRequest request)throws TradesPeopleServiceException {
		try {
			Comment comment=commentBuilder.buildFor(request);
			if (!comment.isPersisted()) {
				ApiUtils.throwPersistedException();
			}
			commentHibernateDao.update(comment);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}
	
	@Transactional
	public void delete(CommentRequest request)throws TradesPeopleServiceException {
		try {
			Comment comment=commentBuilder.buildFor(request);
			if (!comment.isPersisted()) {
				ApiUtils.throwPersistedException();
			}
			commentHibernateDao.delete(comment);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}
	

	@Transactional(readOnly=true)
	public List<Comment> listShopComments(PaginableRequest request, Long shopId) throws TradesPeopleServiceException {
		try {
			return commentHibernateDao.listShopCategories(PaginationSearchCriteria.buildFor(request),shopId);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	
	public void setCommentHibernateDao(ICommentHibernateDao commentHibernateDao) {
		this.commentHibernateDao = commentHibernateDao;
	}

}
