package com.tradespeople.webservice;

import com.tradespeople.common.api.BaseResponse;
import com.tradespeople.json.request.MediaRequest;
import com.tradespeople.json.response.MediaCollectionResponse;
import com.tradespeople.json.response.MediaResponse;

public interface IMediaEndPoint {
	BaseResponse create(MediaRequest media);
	BaseResponse update(MediaRequest media);
	MediaResponse getMediaBy(Long id);
	MediaCollectionResponse getAllMedia();
	MediaCollectionResponse getAllMediaByStatus(Byte status);
	MediaCollectionResponse getAllMediaByType(String type);
	MediaCollectionResponse getAllMediaByType(String type,String status);

}
