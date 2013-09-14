package com.tradespeople.model.builder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tradespeople.json.request.MediaRequest;
import com.tradespeople.json.response.MediaCollectionResponse;
import com.tradespeople.json.response.MediaResponse;
import com.tradespeople.model.Media;


@Component
public class MediaBuilder {

	@Autowired
	private
	MediaRequestBuilder mediaRequestBuilder;
	
	@Autowired
	private
	MediaResponseBuilder mediaResponseBuilder;
	
	public Media buildFor(MediaRequest request){
		return mediaRequestBuilder.build(request);
	}
	
	public Media buildFor(MediaResponse response){
		return mediaResponseBuilder.build(response);
	}
	
	public MediaCollectionResponse buildFor(List<Media> list)
	{
		return mediaResponseBuilder.build(list);
	}
	
	public MediaRequest buildRequest(Media model){
		return mediaRequestBuilder.build(model);
	}
	
	public MediaResponse buildResponse(Media model){
		return mediaResponseBuilder.build(model);
	}

	public MediaRequestBuilder getMediaRequestBuilder() {
		return mediaRequestBuilder;
	}

	public void setMediaRequestBuilder(MediaRequestBuilder mediaRequestBuilder) {
		this.mediaRequestBuilder = mediaRequestBuilder;
	}

	public MediaResponseBuilder getMediaResponseBuilder() {
		return mediaResponseBuilder;
	}

	public void setMediaResponseBuilder(MediaResponseBuilder mediaResponseBuilder) {
		this.mediaResponseBuilder = mediaResponseBuilder;
	}
}
