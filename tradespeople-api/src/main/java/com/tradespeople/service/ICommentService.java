package com.tradespeople.service;

import java.util.List;

import com.tradespeople.common.api.PaginableRequest;
import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.json.request.CommentRequest;
import com.tradespeople.model.Comment;

public interface ICommentService {

	void create(CommentRequest request) throws TradesPeopleServiceException;

	void update(CommentRequest request) throws TradesPeopleServiceException;

	void delete(CommentRequest request) throws TradesPeopleServiceException;

	List<Comment> listShopComments(PaginableRequest request, Long shopId) throws TradesPeopleServiceException;

}
