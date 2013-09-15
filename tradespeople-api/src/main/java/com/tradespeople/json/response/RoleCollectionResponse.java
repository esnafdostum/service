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
}
