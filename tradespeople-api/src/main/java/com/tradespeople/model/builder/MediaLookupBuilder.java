package com.tradespeople.model.builder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tradespeople.json.request.MediaLookUpRequest;
import com.tradespeople.json.response.MediaLookUpCollectionResponse;
import com.tradespeople.json.response.MediaLookUpResponse;
import com.tradespeople.model.Medialookup;

@Component
public class MediaLookupBuilder {

	@Autowired
	private
	MediaLookupRequestBuilder mediaLookupRequestBuilder;
	
	@Autowired
	private
	MediaLookupResponseBuilder mediaLookupResponseBuilder;
	
	
	public Medialookup buildFor(MediaLookUpRequest request){
		return mediaLookupRequestBuilder.build(request);
	}
	
	
	public MediaLookUpCollectionResponse buildFor(List<Medialookup> list)
	{
		return mediaLookupResponseBuilder.build(list);
	}
	
	public MediaLookUpResponse buildResponse(Medialookup model){
		return mediaLookupResponseBuilder.build(model);
	}
	
	public MediaLookupRequestBuilder getMediaLookupRequestBuilder() {
		return mediaLookupRequestBuilder;
	}

	public void setMediaLookupRequestBuilder(MediaLookupRequestBuilder mediaLookupRequestBuilder) {
		this.mediaLookupRequestBuilder = mediaLookupRequestBuilder;
	}

	public MediaLookupResponseBuilder getMediaLookupResponseBuilder() {
		return mediaLookupResponseBuilder;
	}

	public void setMediaLookupResponseBuilder(MediaLookupResponseBuilder mediaLookupResponseBuilder) {
		this.mediaLookupResponseBuilder = mediaLookupResponseBuilder;
	}
	
}
