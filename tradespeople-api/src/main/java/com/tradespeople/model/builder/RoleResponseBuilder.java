package com.tradespeople.model.builder;

import org.springframework.stereotype.Component;

import com.tradespeople.common.builder.ResponseBuilder;
import com.tradespeople.json.request.RoleResponse;
import com.tradespeople.model.Role;

@Component
public class RoleResponseBuilder extends ResponseBuilder<RoleResponse, Role> {

	@Override
	public RoleResponse build() {
		return null;
	}

	@Override
	public Role build(RoleResponse obj) {
		Role role=new Role();
		role.setCreateddate(obj.getCreateddate());
		role.setId(obj.getId());
		role.setName(obj.getName());
		role.setStatus(obj.getStatus());
		role.setUpdateddate(obj.getUpdateddate());
		return role;		
	}

	@Override
	public RoleResponse build(Role model) {
		RoleResponse response=new RoleResponse();
		response.setCreateddate(model.getCreateddate());
		response.setId(model.getId());
		response.setName(model.getName());
		response.setStatus(model.getStatus());
		response.setUpdateddate(model.getUpdateddate());
		return response;
	}

}
