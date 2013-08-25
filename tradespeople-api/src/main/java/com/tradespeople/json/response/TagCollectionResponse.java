package com.tradespeople.json.response;

import java.util.ArrayList;
import java.util.List;

import com.tradespeople.common.api.BaseResponse;

public class TagCollectionResponse extends BaseResponse {

	private List<TagResponse> responses;
	
	public TagCollectionResponse(){
		responses=new ArrayList<TagResponse>();
	}
	
	public void add(TagResponse tagResponse){
		responses.add(tagResponse);
	}

	public List<TagResponse> getResponses() {
		return responses;
	}

	public void setResponses(List<TagResponse> responses) {
		this.responses = responses;
	}
	
	public TagCollectionResponse failResponse(){
		TagCollectionResponse response=new TagCollectionResponse();
		BaseResponse fail=BaseResponse.fail();
		response.setResponseStatus(fail.getResponseStatus());
		response.setErrorCode(fail.getErrorCode());
		response.setErrorMessage(fail.getErrorMessage());
		return response;
	}
	
}
