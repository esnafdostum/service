package com.tradespeople.json.response;

import java.util.Date;

import com.tradespeople.common.api.BaseResponse;
import com.tradespeople.model.Media;
import com.tradespeople.model.Shop;
import com.tradespeople.model.User;

public class MediaLookUpResponse extends BaseResponse{

	public Long id;
	public Long mediaid;
	public Long shopid;
	public Long userid;
	public Byte status;
	public Date createddate;
	public Date updateddate;
}