package com.tradespeople.json.response;

import java.util.ArrayList;
import java.util.List;

import com.tradespeople.common.api.BaseResponse;

public class RoleCollectionResponse extends BaseResponse {

	private List<RoleResponse> responses;

	public RoleCollectionResponse() {
		responses=new ArrayList<RoleResponse>();
	}

	public void add(RoleResponse commentResponse) {
		responses.add(commentResponse);
	}

	public RoleCollectionResponse failResponse(String errorMessage) {
		RoleCollectionResponse response = new RoleCollectionResponse();
		BaseResponse fail = BaseResponse.fail(errorMessage);
		response.setResponseStatus(fail.getResponseStatus());
		response.setErrorCode(fail.getErrorCode());
		response.setErrorMessage(fail.getErrorMessage());
		return response;
	}
	
}
