package com.tradespeople.model.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tradespeople.common.builder.RequestBuilder;
import com.tradespeople.json.request.RoleRequest;
import com.tradespeople.json.request.UserRequest;
import com.tradespeople.model.User;

@Component
public class UserRequestBuilder extends RequestBuilder<UserRequest, User> {

	@Autowired
	private RoleRequestBuilder roleRequestBuilder;
	
	@Override
	public UserRequest build() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User build(UserRequest obj) {
		User user=new User();
		user.setId(obj.getId());
		user.setName(obj.getName());
		user.setPassword(obj.getPassword());
		user.setStatus(obj.getStatus());
		user.setSurname(obj.getUsername());
		user.setToken(obj.getToken());
		user.setUsername(obj.getUsername());
		for (RoleRequest roleRequest : obj.getRoles()) {
			user.addRole(roleRequestBuilder.build(roleRequest));
		}
		return user;
	}

	@Override
	public UserRequest build(User model) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setRoleRequestBuilder(RoleRequestBuilder roleRequestBuilder) {
		this.roleRequestBuilder = roleRequestBuilder;
	}

}
