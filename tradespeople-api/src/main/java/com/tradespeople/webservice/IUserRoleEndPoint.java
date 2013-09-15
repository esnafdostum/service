package com.tradespeople.webservice;


import java.util.List;

import com.tradespeople.common.api.BaseResponse;
import com.tradespeople.json.request.RoleRequest;
import com.tradespeople.json.response.RoleCollectionResponse;
import com.tradespeople.json.response.UserCollectionResponse;


public interface IUserRoleEndPoint {

	BaseResponse create(List<RoleRequest> roleList,Long userid) ;
 
	BaseResponse update(Long roleid,Long userid,Byte status) ;

	RoleCollectionResponse getRoleofUser(Long userid) ;

	UserCollectionResponse getUserofRole(Long roleid) ;

}
