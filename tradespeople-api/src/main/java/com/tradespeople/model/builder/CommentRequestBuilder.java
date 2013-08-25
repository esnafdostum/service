package com.tradespeople.model.builder;

import org.springframework.stereotype.Component;

import com.tradespeople.common.builder.RequestBuilder;
import com.tradespeople.json.request.CommentRequest;
import com.tradespeople.model.Comment;
import com.tradespeople.model.Shop;
import com.tradespeople.model.User;

@Component
public class CommentRequestBuilder extends RequestBuilder<CommentRequest,Comment> {

	@Override
	public CommentRequest build() {
		return null;
	}

	@Override
	public Comment build(CommentRequest obj) {
		Shop shop=new Shop();
		shop.setId(obj.getShopId());
		User user=new User();
		user.setId(obj.getUserId());
		
		Comment comment=new Comment();
		comment.setCommenttext(obj.getCommenttext());
		comment.setShop(shop);
		comment.setUser(user);
		comment.setStatus(obj.getStatus());
		comment.setId(obj.getId());
		
		return comment;
	}

	@Override
	public CommentRequest build(Comment model) {
		return null;
	}

}
