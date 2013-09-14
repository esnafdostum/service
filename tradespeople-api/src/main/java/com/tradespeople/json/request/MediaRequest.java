package com.tradespeople.json.request;

import java.util.Date;

import com.tradespeople.common.api.BaseRequest;

public class MediaRequest extends BaseRequest {
	public long id;
	public byte type;
	public String path;
	public Date createddate;
	public Date updateddate;
	public Byte status;
	public Long creatoruserid;
	public String description;
}
