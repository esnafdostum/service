package com.tradespeople.model.builder;

import org.springframework.stereotype.Component;

import com.tradespeople.common.builder.ResponseBuilder;
import com.tradespeople.json.response.CommentResponse;
import com.tradespeople.model.Comment;

@Component
public class CommentResponseBuilder extends ResponseBuilder<CommentResponse, Comment> {

	@Override
	public CommentResponse build() {
		return null;
	}

	@Override
	public Comment build(CommentResponse obj) {
		return null;
	}

	@Override
	public CommentResponse build(Comment model) {
		CommentResponse response=new CommentResponse();
		
		response.commenttext=model.getCommenttext();
		response.createddate=model.getCreateddate();
		response.id=model.getId();
		response.shopid=model.getShop().getId();
		response.status=model.getStatus();
		response.userid=model.getUser().getId();
		return response;
	}

}
