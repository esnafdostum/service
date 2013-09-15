package com.tradespeople.model.builder;

import org.springframework.stereotype.Component;

import com.tradespeople.common.builder.RequestBuilder;
import com.tradespeople.json.request.MediaRequest;
import com.tradespeople.model.Media;


@Component
public class MediaRequestBuilder extends RequestBuilder<MediaRequest,Media> {

	@Override
	public MediaRequest build() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Media build(MediaRequest request) {
		Media media=new Media();
		media.setCreateddate(request.createddate);
		media.setCreatoruserid(request.creatoruserid);
		media.setDescription(request.description);
		media.setId(request.id);
		media.setPath(request.path);
		media.setStatus(request.status);
		media.setType(request.type);
		media.setUpdateddate(request.updateddate);
		
		return media;
	}

	@Override
	public MediaRequest build(Media model) {
		// TODO Auto-generated method stub
		return null;
	}
	



}
