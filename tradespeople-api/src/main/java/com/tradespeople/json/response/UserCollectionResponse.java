package com.tradespeople.json.response;

import java.util.ArrayList;
import java.util.List;

import com.tradespeople.common.api.BaseResponse;

public class UserCollectionResponse extends BaseResponse{

	List<UserResponse> responses;
	
	public UserCollectionResponse() {
		responses=new ArrayList<UserResponse>();
	}
	
	public void add(UserResponse response)
	{
		responses.add(response);
	}
}
