package com.tradespeople.model.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tradespeople.json.request.RoleRequest;
import com.tradespeople.json.request.RoleResponse;
import com.tradespeople.model.Role;

@Component
public class RoleBuilder {
	
	@Autowired
	private RoleResponseBuilder responseBuilder;
	
	@Autowired
	private RoleRequestBuilder requestBuilder;
	
	
	public Role buildFor(RoleRequest request){
		return requestBuilder.build(request);
	}
	
	public Role buildFor(RoleResponse response){
		return responseBuilder.build(response);
	}
	
	public RoleRequest buildRequest(Role model){
		return requestBuilder.build(model);
	}
	
	public RoleResponse buildResponse(Role model){
		return responseBuilder.build(model);
	}
	
	public void setResponseBuilder(RoleResponseBuilder responseBuilder) {
		this.responseBuilder = responseBuilder;
	}

	public void setRequestBuilder(RoleRequestBuilder requestBuilder) {
		this.requestBuilder = requestBuilder;
	}

}
