package com.tradespeople.json.response;

import java.util.Date;

import com.tradespeople.common.api.BaseResponse;

public class MediaLookUpResponse extends BaseResponse{

	public Long id;
	public Long mediaid;
	public Long shopid;
	public Long userid;
	public Byte status;
	public Date createddate;
	public Date updateddate;
}
