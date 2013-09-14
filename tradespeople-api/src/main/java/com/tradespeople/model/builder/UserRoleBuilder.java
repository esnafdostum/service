package com.tradespeople.model.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserRoleBuilder {

	@Autowired
	private
	UserRoleRequestBuilder userRoleRequestBuilder;
	
	@Autowired
	private
	UserRoleResponseBuilder userRoleResponseBuilder;
	

	public UserRoleRequestBuilder getUserRoleRequestBuilder() {
		return userRoleRequestBuilder;
	}

	public void setUserRoleRequestBuilder(UserRoleRequestBuilder userRoleRequestBuilder) {
		this.userRoleRequestBuilder = userRoleRequestBuilder;
	}

	public UserRoleResponseBuilder getUserRoleResponseBuilder() {
		return userRoleResponseBuilder;
	}

	public void setUserRoleResponseBuilder(UserRoleResponseBuilder userRoleResponseBuilder) {
		this.userRoleResponseBuilder = userRoleResponseBuilder;
	}
}
