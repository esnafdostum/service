package com.tradespeople.json.response;

import java.util.ArrayList;
import java.util.List;

import com.tradespeople.common.api.BaseResponse;

public class UserRoleCollectionResponse extends BaseResponse {
	List<UserRoleResponse> responses;

	public UserRoleCollectionResponse() {
		responses = new ArrayList<UserRoleResponse>();
	}

	public void add(UserRoleResponse response) {
		responses.add(response);
	}
}
