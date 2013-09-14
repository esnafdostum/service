package com.tradespeople.json.response;

import java.util.Date;

import com.tradespeople.common.api.BaseResponse;

public class MediaResponse extends BaseResponse{
	public long id;
	public byte type;
	public String path;
	public Date createddate;
	public Date updateddate;
	public Byte status;
	public Long creatoruserid;
	public String description;
}
