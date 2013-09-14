package com.tradespeople.json.request;

import java.util.Date;

import com.tradespeople.common.api.BaseRequest;
import com.tradespeople.model.Role;
import com.tradespeople.model.User;

public class UserRoleRequest extends BaseRequest {

	public Long id;
	public Long roleid;
	public Long userid;
	public Date createddate;
	public Date updateddate;
	public Byte status;
}
