package com.tradespeople.json.response;

import java.util.ArrayList;
import java.util.List;

import com.tradespeople.common.api.BaseResponse;

public class MediaLookUpCollectionResponse extends BaseResponse{
List<MediaLookUpResponse> responses;
	
	public MediaLookUpCollectionResponse() {
		responses=new ArrayList<MediaLookUpResponse>();
	}
	
	public void add(MediaLookUpResponse response)
	{
		responses.add(response);
	}
}
