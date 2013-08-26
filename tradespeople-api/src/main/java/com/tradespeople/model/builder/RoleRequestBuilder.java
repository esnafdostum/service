package com.tradespeople.model.builder;

import org.springframework.stereotype.Component;

import com.tradespeople.common.builder.RequestBuilder;
import com.tradespeople.json.request.RoleRequest;
import com.tradespeople.model.Role;

@Component
public class RoleRequestBuilder extends RequestBuilder<RoleRequest, Role> {

	@Override
	public RoleRequest build() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Role build(RoleRequest obj) {
		Role role=new Role();
		role.setName(obj.getName());
		role.setId(obj.getId());
		role.setStatus(obj.getStatus());
		return role;
	}

	@Override
	public RoleRequest build(Role model) {
		RoleRequest request=new RoleRequest();
		request.setName(model.getName());
		request.setId(model.getId());
		request.setStatus(model.getStatus());
		return request;
	}

}
