package com.tradespeople.model.builder;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tradespeople.common.builder.ResponseBuilder;
import com.tradespeople.json.response.MediaCollectionResponse;
import com.tradespeople.json.response.MediaResponse;
import com.tradespeople.model.Media;

@Component
public class MediaResponseBuilder extends ResponseBuilder<MediaResponse, Media> {

	@Override
	public MediaResponse build() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Media build(MediaResponse obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MediaResponse build(Media model) {
		
		MediaResponse response=new MediaResponse();
		response.createddate=model.getCreateddate();
		response.creatoruserid=model.getCreatoruserid();
		response.description=model.getDescription();
		response.id=model.getId();
		response.path=model.getPath();
		response.status=model.getStatus();
		response.type=model.getType();
		response.updateddate=model.getUpdateddate();
		return response;
	}
	
	
	public MediaCollectionResponse build(List<Media> list)
	{
		MediaCollectionResponse collectionResponse=new MediaCollectionResponse();
		
		for (Media media : list) {
			collectionResponse.add(this.build(media));
		}
		return collectionResponse;
	}
	

	

}
