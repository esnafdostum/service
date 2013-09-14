package com.tradespeople.model.builder;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tradespeople.common.builder.ResponseBuilder;
import com.tradespeople.json.request.MediaLookUpRequest;
import com.tradespeople.json.response.MediaLookUpCollectionResponse;
import com.tradespeople.json.response.MediaLookUpResponse;
import com.tradespeople.json.response.RoleResponse;
import com.tradespeople.model.Medialookup;
import com.tradespeople.model.Role;


@Component
public class MediaLookupResponseBuilder extends ResponseBuilder<MediaLookUpResponse,Medialookup>{


	public MediaLookUpCollectionResponse build(List<Medialookup> list)
	{
		MediaLookUpCollectionResponse collectionResponse=new MediaLookUpCollectionResponse();
		
		for (Medialookup medialookup : list) {
			collectionResponse.add(this.build(medialookup));
		}
		return collectionResponse;
	}
	
	
	public MediaLookUpResponse build(Medialookup model)
	{
		MediaLookUpResponse response=new MediaLookUpResponse();
		
		response.createddate=model.getCreateddate();
		response.id=model.getId();
		response.mediaid=model.getMedia().getId();
		response.shopid=model.getShop().getId();
		response.status=model.getStatus();
		response.updateddate=model.getUpdateddate();
		response.userid=model.getUser().getId();
		
		return response;
	}


	@Override
	public MediaLookUpResponse build() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Medialookup build(MediaLookUpResponse obj) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
