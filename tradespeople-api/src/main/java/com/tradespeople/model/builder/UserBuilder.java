package com.tradespeople.model.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tradespeople.json.request.UserRequest;
import com.tradespeople.json.response.UserResponse;
import com.tradespeople.model.User;

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
	
	public UserRequest buildRequest(User model){
		return requestBuilder.build(model);
	}
	
	public UserResponse buildResponse(User model){
		return responsebuilder.build(model);
	}

	public void setRequestBuilder(UserRequestBuilder requestBuilder) {
		this.requestBuilder = requestBuilder;
	}

	public void setResponsebuilder(UserResponseBuilder responsebuilder) {
		this.responsebuilder = responsebuilder;
	}
	
}
