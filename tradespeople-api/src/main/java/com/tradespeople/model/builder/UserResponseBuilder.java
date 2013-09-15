package com.tradespeople.model.builder;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tradespeople.common.builder.ResponseBuilder;
import com.tradespeople.json.response.UserCollectionResponse;
import com.tradespeople.json.response.UserResponse;
import com.tradespeople.model.User;
import com.tradespeople.model.Userrole;

@Component
public class UserResponseBuilder extends ResponseBuilder<UserResponse, User> {

	@Override
	public UserResponse build() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User build(UserResponse obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserResponse build(User model) {
		UserResponse response=new UserResponse();
		response.setCreateddate(model.getCreateddate());
		response.setName(model.getName());
		response.setPassword(model.getPassword());
		response.setStatus(model.getStatus());
		response.setSurname(model.getSurname());
		response.setToken(model.getToken());
		response.setUpdateddate(model.getUpdateddate());
		response.setUsername(model.getUsername());
		return response;
	}
	
	
	public UserCollectionResponse build(List<Userrole> list)
	{
		UserCollectionResponse response=new UserCollectionResponse();
			
			for (int i = 0; i < list.size(); i++) {
				response.add(this.build(list.get(i).getUser()));
	}
			return response;
	}
	

}
