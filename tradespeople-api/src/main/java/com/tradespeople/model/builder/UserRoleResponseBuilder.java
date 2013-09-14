package com.tradespeople.model.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tradespeople.common.builder.ResponseBuilder;
import com.tradespeople.json.response.CommentResponse;
import com.tradespeople.json.response.UserResponse;
import com.tradespeople.json.response.UserRoleResponse;
import com.tradespeople.model.Comment;
import com.tradespeople.model.User;
import com.tradespeople.model.Userrole;


@Component
public class UserRoleResponseBuilder extends ResponseBuilder<UserRoleResponse, Userrole> {

	@Override
	public UserRoleResponse build() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserRoleResponse build(Userrole ur) {
		UserRoleResponse response=new UserRoleResponse();
		response.createddate=ur.getCreateddate();
		response.id=ur.getId();
		response.rolename=ur.getRole().getName();
		response.updateddate=ur.getUpdateddate();
		response.username=ur.getUser().getName();
		return response;
	}

	
	public List<UserRoleResponse> build(List<Userrole> userRoleList)
	{
		List<UserRoleResponse> list=new ArrayList<UserRoleResponse>();
		
		for (Userrole item : userRoleList) 
		{
			list.add(this.build(item));
		}
		
	return list;
	}

	@Override
	public Userrole build(UserRoleResponse obj) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
