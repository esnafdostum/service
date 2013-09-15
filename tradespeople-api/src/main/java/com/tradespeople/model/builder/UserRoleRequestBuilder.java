package com.tradespeople.model.builder;

import org.springframework.stereotype.Component;

import com.tradespeople.common.builder.RequestBuilder;
import com.tradespeople.json.request.UserRoleRequest;
import com.tradespeople.model.Role;
import com.tradespeople.model.User;
import com.tradespeople.model.Userrole;

@Component
public class UserRoleRequestBuilder extends RequestBuilder<UserRoleRequest,Userrole> {

	@Override
	public UserRoleRequest build() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Userrole build(UserRoleRequest request) {
		
		Role role=new Role();
		role.setId(request.roleid);
		
		User user=new User();
		user.setId(request.userid);
		
		Userrole userrole=new Userrole();
		userrole.setCreateddate(request.createddate);
		userrole.setId(request.id);
		userrole.setRole(role);
		userrole.setStatus(request.status);
		userrole.setUpdateddate(request.updateddate);
		userrole.setUser(user);
		return userrole;
	}

	@Override
	public UserRoleRequest build(Userrole model) {
		// TODO Auto-generated method stub
		return null;
	}

}
