package com.tradespeople.json.response;

import java.util.Date;

import com.tradespeople.common.api.BaseResponse;

public class UserRoleResponse extends BaseResponse{

	public long id;
	public String rolename;
	public String username;
	public Date createddate;
	public Date updateddate;
	public Byte status;
}
