package com.tradespeople.json.response;

import java.util.ArrayList;
import java.util.List;

import com.tradespeople.common.api.BaseResponse;

public class CommentCollectionResponse extends BaseResponse {

	private List<CommentResponse> responses;

	public CommentCollectionResponse() {
		setResponses(new ArrayList<CommentResponse>());
	}

	public void add(CommentResponse commentResponse) {
		responses.add(commentResponse);
	}

	public List<CommentResponse> getResponses() {
		return responses;
	}

	public void setResponses(List<CommentResponse> responses) {
		this.responses = responses;
	}
	
}
