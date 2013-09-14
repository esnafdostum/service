package com.tradespeople.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tradespeople.common.api.BaseController;
import com.tradespeople.common.api.BaseResponse;
import com.tradespeople.common.api.PaginableRequest;
import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.json.request.RoleRequest;
import com.tradespeople.json.response.RoleCollectionResponse;
import com.tradespeople.model.Role;
import com.tradespeople.model.builder.RoleBuilder;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;
import com.tradespeople.service.IRoleService;

@Controller("/role")
public class RoleEndPoint extends BaseController implements IRoleEndPoint {
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private RoleBuilder roleBuilder;
	
	@RequestMapping("/createRole")
	@ResponseBody
	public BaseResponse save(@RequestBody RoleRequest request){
		try {
			roleService.create(roleBuilder.buildFor(request));
			return BaseResponse.successful();
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail(e.getMessage());
		}
	}
	
	@RequestMapping("/updateRole")
	@ResponseBody
	public BaseResponse update(@RequestBody RoleRequest request){
		try {
			roleService.update(roleBuilder.buildFor(request));
			return BaseResponse.successful();
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail(e.getMessage());
		}
	}
	
	@RequestMapping("/deleteRole")
	@ResponseBody
	public BaseResponse delete(@RequestBody RoleRequest request){
		try {
			roleService.delete(roleBuilder.buildFor(request));
			return BaseResponse.successful();
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail(e.getMessage());
		}
	}
	
	@RequestMapping("/listRole")
	public RoleCollectionResponse listRole(@RequestBody PaginableRequest request){
		
		try {
			List<Role> roles=roleService.listRoles(PaginationSearchCriteria.buildFor(request));
			RoleCollectionResponse response=new RoleCollectionResponse();
			for (Role role : roles) {
				response.add(roleBuilder.buildResponse(role));
			}
			return response;
		} catch (TradesPeopleServiceException e) {
			return new RoleCollectionResponse().failResponse(e.getMessage());
		}
	}

	public void setRoleBuilder(RoleBuilder roleBuilder) {
		this.roleBuilder = roleBuilder;
	}

	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}

}
