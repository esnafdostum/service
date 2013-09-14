package com.tradespeople.webservice;

import java.util.List;

import com.tradespeople.common.api.BaseResponse;
import com.tradespeople.json.request.MediaLookUpRequest;
import com.tradespeople.json.response.MediaLookUpCollectionResponse;
import com.tradespeople.json.response.MediaLookUpResponse;
import com.tradespeople.model.Medialookup;
import com.tradespeople.model.Shop;
import com.tradespeople.model.User;

public interface IMediaLookUpEndPoint {
	BaseResponse create(MediaLookUpRequest medialookup);

	BaseResponse update(MediaLookUpRequest medialookup);

	MediaLookUpResponse getMediaLookupBy(Long id);
	
	MediaLookUpCollectionResponse getAllMediaLookUp();
	
	MediaLookUpCollectionResponse getAllMediaLookUpByStatus(Byte status);
	
	MediaLookUpCollectionResponse getAllMediaLookupByUser();
	
	MediaLookUpCollectionResponse getAllMediaLookUpByShop();
	
	MediaLookUpCollectionResponse getMediaLookUpByUser(Long userid);
	
	MediaLookUpCollectionResponse getMediaLookUpByShop(Long shopid);

}
