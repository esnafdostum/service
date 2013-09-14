package com.tradespeople.json.response;

import java.util.ArrayList;
import java.util.List;

import com.tradespeople.common.api.BaseResponse;

public class MediaCollectionResponse extends BaseResponse{

	List<MediaResponse> responseList;
	
	public MediaCollectionResponse()
	{
		responseList=new ArrayList<MediaResponse>();
	}
	
	public void add(MediaResponse response)
	{
		responseList.add(response);
	}
}
