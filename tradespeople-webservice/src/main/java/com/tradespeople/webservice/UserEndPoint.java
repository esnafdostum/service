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
	
	@RequestMapping("/all")
	@ResponseBody
	public List<User> all() throws TradesPeopleServiceException{
		return userService.all();
	}
	
	@RequestMapping("/allWithPagination")
	@ResponseBody
	public List<User> all(@RequestBody PaginableRequest request) throws TradesPeopleServiceException{
		return userService.all(PaginationSearchCriteria.buildFor(request));
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public BaseResponse save(@RequestBody UserRequest request){
		try {
			userService.create(userBuilder.buildFor(request));
			return BaseResponse.successful();
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail(e.getMessage());
		}
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public BaseResponse update(@RequestBody UserRequest request){
		try {
			userService.update(userBuilder.buildFor(request));
			return BaseResponse.successful();
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail(e.getMessage());
		}
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public void setUserBuilder(UserBuilder userBuilder) {
		this.userBuilder = userBuilder;
	}

}
