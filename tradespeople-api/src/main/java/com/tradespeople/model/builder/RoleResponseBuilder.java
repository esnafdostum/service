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
		return null;
	}

	@Override
	public RoleResponse build(Role model) {
		return null;
	}

}
