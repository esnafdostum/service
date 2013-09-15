package com.tradespeople.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tradespeople.common.api.BaseController;
import com.tradespeople.common.api.BaseResponse;
import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.json.request.RoleRequest;
import com.tradespeople.json.response.RoleCollectionResponse;
import com.tradespeople.json.response.UserCollectionResponse;
import com.tradespeople.json.response.UserRoleCollectionResponse;
import com.tradespeople.model.Role;
import com.tradespeople.model.User;
import com.tradespeople.model.Userrole;
import com.tradespeople.model.builder.RoleBuilder;
import com.tradespeople.model.builder.UserBuilder;
import com.tradespeople.model.builder.UserRoleBuilder;
import com.tradespeople.service.IUserRoleService;

@Controller
@RequestMapping("/userrole")
public class UserRoleEndPoint extends BaseController implements IUserRoleEndPoint {

	@Autowired
	private IUserRoleService userRoleService;

	@Autowired
	private UserRoleBuilder userRoleBuilder;

	@Autowired
	private RoleBuilder roleBuilder;

	@Autowired
	private UserBuilder userBuilder;

	@Override
	@RequestMapping("/create")
	@ResponseBody
	public BaseResponse create(@RequestBody List<RoleRequest> roleList,@PathVariable Long userid){
		try {
			User user = new User();
			user.setId(userid);

			for (int i = 0; i < roleList.size(); i++) {
				Role role = new Role();
				role.setId(roleList.get(i).getId());

				Userrole userrole = new Userrole();
				userrole.setRole(role);
				userrole.setUser(user);
				userRoleService.create(userrole);
			}

			return BaseResponse.successful();
		} catch (Exception e) {
			return BaseResponse.fail(e.getMessage());
		}

	}

	@Override
	@RequestMapping("/update")
	@ResponseBody
	public BaseResponse update(@PathVariable Long roleid,@PathVariable Long userid,@PathVariable Byte status){
		try {
			userRoleService.update(roleid, userid, status);
			return BaseResponse.successful();
		} catch (Exception e) {
			return BaseResponse.fail(e.getMessage());
		}
	}

	@Override
	@RequestMapping("/getRoleofUser")
	@ResponseBody
	public RoleCollectionResponse getRoleofUser(@PathVariable Long userid){
		User user = new User();
		user.setId(userid);
		List<Userrole> list = null;
		try {
			list = userRoleService.getUserRole(user);
		} catch (TradesPeopleServiceException e) {
			BaseResponse.fail(e.getMessage(), UserRoleCollectionResponse.class);
		}
		return roleBuilder.buildFor(list);
		
	}

	@Override
	@RequestMapping("/getUserofRole")
	@ResponseBody
	public UserCollectionResponse getUserofRole(@PathVariable Long roleid)
			 {
		Role role = new Role();
		role.setId(roleid);
		List<Userrole> list = null;
		try {
			list = userRoleService.getUserRole(role);
		} catch (TradesPeopleServiceException e) {
			BaseResponse.fail(e.getMessage(), UserRoleCollectionResponse.class);
		}
		return userBuilder.buildFor(list);
	}

	public void setUserRoleService(IUserRoleService userRoleService) {
		this.userRoleService = userRoleService;
	}

	public void setUserRoleBuilder(UserRoleBuilder userRoleBuilder) {
		this.userRoleBuilder = userRoleBuilder;
	}

	public void setRoleBuilder(RoleBuilder roleBuilder) {
		this.roleBuilder = roleBuilder;
	}

	public void setUserBuilder(UserBuilder userBuilder) {
		this.userBuilder = userBuilder;
	}
}
