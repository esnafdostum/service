package com.tradespeople.service;

import java.util.List;

import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.model.Comment;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;

public interface ICommentService {

	void create(Comment comment) throws TradesPeopleServiceException;

	void update(Comment comment) throws TradesPeopleServiceException;

	void delete(Comment comment) throws TradesPeopleServiceException;

	List<Comment> listShopComments(PaginationSearchCriteria searchCriteria, Long shopId) throws TradesPeopleServiceException;

}
