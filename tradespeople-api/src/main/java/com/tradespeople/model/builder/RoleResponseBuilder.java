package com.tradespeople.model.builder;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tradespeople.common.builder.ResponseBuilder;
import com.tradespeople.json.response.RoleCollectionResponse;
import com.tradespeople.json.response.RoleResponse;
import com.tradespeople.model.Role;
import com.tradespeople.model.Userrole;

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

	public RoleCollectionResponse build(List<Userrole> list)
	{
		RoleCollectionResponse response=new RoleCollectionResponse();
		
		for (int i = 0; i < list.size(); i++) {
			response.add(this.build(list.get(i).getRole()));
		}
		return response;
	}

}
