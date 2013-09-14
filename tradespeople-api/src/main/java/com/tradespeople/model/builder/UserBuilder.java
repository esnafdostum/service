package com.tradespeople.model.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tradespeople.json.request.UserRequest;
import com.tradespeople.json.response.RoleCollectionResponse;
import com.tradespeople.json.response.UserCollectionResponse;
import com.tradespeople.json.response.UserResponse;
import com.tradespeople.model.User;
import com.tradespeople.model.Userrole;

@Component
public class UserBuilder {

	@Autowired 
	private UserRequestBuilder requestBuilder;
	
	@Autowired
	private UserResponseBuilder responsebuilder;
	
	public User buildFor(UserRequest request){
		return requestBuilder.build(request);
	}
	
	public User buildFor(UserResponse response){
		return responsebuilder.build(response);
	}
	
	public UserCollectionResponse buildFor(List<Userrole> list)
	{
		return responsebuilder.build(list);
	}
	
	public UserRequest buildRequest(User model){
		return requestBuilder.build(model);
	}
	
	public UserResponse buildResponse(User model){
		return responsebuilder.build(model);
	}

	
	public List<UserResponse> buildResponse(List<User> model) {
		
		List<UserResponse> responseList=new ArrayList<>();
		for (User user : model) 
		{
			responseList.add(this.buildResponse(user));
		}
		return responseList;
	}

	public void setRequestBuilder(UserRequestBuilder requestBuilder) {
		this.requestBuilder = requestBuilder;
	}

	public void setResponsebuilder(UserResponseBuilder responsebuilder) {
		this.responsebuilder = responsebuilder;
	}
	
}
