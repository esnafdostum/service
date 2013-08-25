package com.tradespeople.model.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tradespeople.json.request.CommentRequest;
import com.tradespeople.json.response.CommentResponse;
import com.tradespeople.model.Comment;

@Component
public class CommentBuilder {

	@Autowired
	private CommentRequestBuilder requestBuilder;
	
	@Autowired
	private CommentResponseBuilder responseBuilder;
	
	public Comment buildFor(CommentRequest request){
		return requestBuilder.build(request);
	}
	
	public Comment buildFor(CommentResponse response){
		return responseBuilder.build(response);
	}
	
	public CommentRequest buildRequest(Comment model){
		return requestBuilder.build(model);
	}
	
	public CommentResponse buildResponse(Comment model){
		return responseBuilder.build(model);
	}
	
	public void setRequestBuilder(CommentRequestBuilder requestBuilder) {
		this.requestBuilder = requestBuilder;
	}

	public void setResponseBuilder(CommentResponseBuilder responseBuilder) {
		this.responseBuilder = responseBuilder;
	}
	
}
