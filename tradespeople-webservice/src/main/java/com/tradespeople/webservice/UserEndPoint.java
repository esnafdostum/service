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
import com.tradespeople.json.request.UserRequest;
import com.tradespeople.json.response.UserCollectionResponse;
import com.tradespeople.json.response.UserResponse;
import com.tradespeople.model.User;
import com.tradespeople.model.builder.UserBuilder;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;
import com.tradespeople.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserEndPoint extends BaseController implements IUserEndPoint {
	
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private UserBuilder userBuilder;
	
	@RequestMapping("/createUser")
	@ResponseBody
	public BaseResponse save(@RequestBody UserRequest request){
		try {
			userService.create(userBuilder.buildFor(request));
			return BaseResponse.successful();
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail(e.getMessage());
		}
	}
	
	@RequestMapping("/updateUser")
	@ResponseBody
	public BaseResponse update(@RequestBody UserRequest request){
		try {
			userService.update(userBuilder.buildFor(request));
			return BaseResponse.successful();
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail(e.getMessage());
		}
	}

	@RequestMapping("/allUser")
	@ResponseBody
	public UserCollectionResponse  allUser(){
		try {
			List<User> users=userService.all(PaginationSearchCriteria.emptyPaginationSearchCriteria());
			UserCollectionResponse response=new UserCollectionResponse();
			for (User user : users) {
				response.add(userBuilder.buildResponse(user));
			}
			return response;
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail(e.getMessage(), UserCollectionResponse.class);
		}
		
	}
	
	@RequestMapping("/allWithPagination")
	@ResponseBody
	public UserCollectionResponse all(@RequestBody PaginableRequest request){
		try {
			List<User> users=userService.all(PaginationSearchCriteria.buildFor(request));
			UserCollectionResponse response=new UserCollectionResponse();
			for (User user : users) {
				response.add(userBuilder.buildResponse(user));
			}
			return response;
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail(e.getMessage(), UserCollectionResponse.class);
		}
		
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setUserBuilder(UserBuilder userBuilder) {
		this.userBuilder = userBuilder;
	}

}
 	