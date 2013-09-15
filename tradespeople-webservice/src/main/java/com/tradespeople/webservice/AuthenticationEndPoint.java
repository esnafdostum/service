package com.tradespeople.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tradespeople.common.api.BaseController;
import com.tradespeople.common.api.BaseResponse;
import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.json.request.LoginRequest;
import com.tradespeople.json.response.UserResponse;
import com.tradespeople.model.User;
import com.tradespeople.model.builder.UserBuilder;
import com.tradespeople.service.IUserService;

@Controller
@RequestMapping("/authentication")
public class AuthenticationEndPoint extends BaseController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private UserBuilder userBuilder;
	
	@RequestMapping("/login")
	@ResponseBody
	public UserResponse login(@RequestBody LoginRequest loginRequest){
		try {
			User user=userService.login(loginRequest.username,loginRequest.bytesPassword);
			return userBuilder.buildResponse(user);
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail(e.getMessage(), UserResponse.class); 
		}
		
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setUserBuilder(UserBuilder userBuilder) {
		this.userBuilder = userBuilder;
	}
	
}
