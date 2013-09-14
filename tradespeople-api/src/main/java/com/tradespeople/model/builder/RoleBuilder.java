package com.tradespeople.model.builder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tradespeople.json.request.RoleRequest;
import com.tradespeople.json.response.RoleCollectionResponse;
import com.tradespeople.json.response.RoleResponse;
import com.tradespeople.model.Role;
import com.tradespeople.model.Userrole;

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
	
	public RoleCollectionResponse buildFor(List<Userrole> list)
	{
		return responseBuilder.build(list);
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
