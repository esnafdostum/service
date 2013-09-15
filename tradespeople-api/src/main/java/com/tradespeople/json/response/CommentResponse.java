package com.tradespeople.json.response;

import java.util.Date;

import com.tradespeople.common.api.BaseResponse;

public class CommentResponse extends BaseResponse{
	public Long id;
	public Long shopid;
	public Long userid;
	public String commenttext;
	public Date createddate;
	public Byte status;
}
