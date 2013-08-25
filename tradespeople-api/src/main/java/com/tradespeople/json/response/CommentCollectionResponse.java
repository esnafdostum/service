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

	public CommentCollectionResponse failResponse(String errorMessage) {
		CommentCollectionResponse response = new CommentCollectionResponse();
		BaseResponse fail = BaseResponse.fail(errorMessage);
		response.setResponseStatus(fail.getResponseStatus());
		response.setErrorCode(fail.getErrorCode());
		response.setErrorMessage(fail.getErrorMessage());
		return response;
	}

	public List<CommentResponse> getResponses() {
		return responses;
	}

	public void setResponses(List<CommentResponse> responses) {
		this.responses = responses;
	}
	
}
