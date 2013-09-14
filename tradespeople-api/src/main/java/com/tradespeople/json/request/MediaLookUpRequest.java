package com.tradespeople.json.request;

import java.util.Date;

import com.tradespeople.common.api.BaseRequest;

public class MediaLookUpRequest extends BaseRequest {

	public Long id;
	public Long mediaid;
	public Long shopid;
	public Long userid;
	public Byte status;
	public Date createddate;
	public Date updateddate;
}
