package com.tradespeople.model.builder;

import org.springframework.stereotype.Component;

import com.tradespeople.common.builder.RequestBuilder;
import com.tradespeople.json.request.MediaLookUpRequest;
import com.tradespeople.json.response.MediaLookUpResponse;
import com.tradespeople.model.Media;
import com.tradespeople.model.Medialookup;
import com.tradespeople.model.Shop;
import com.tradespeople.model.User;

@Component
public class MediaLookupRequestBuilder extends RequestBuilder<MediaLookUpRequest,Medialookup> {

	
	@Override
	public Medialookup build(MediaLookUpRequest request){
		Medialookup medialookup=new Medialookup();
		Media media=new Media();
		User user=new User();
		Shop shop=new Shop();
		
		media.setId(request.mediaid);
		user.setId(request.userid);
		shop.setId(request.shopid);
		
		medialookup.setCreateddate(request.createddate);
		medialookup.setId(request.id);
		medialookup.setMedia(media);
		medialookup.setShop(shop);
		medialookup.setStatus(request.status);
		medialookup.setUpdateddate(request.updateddate);
		medialookup.setUser(user);
		
		return medialookup;
	}
	
	
	public MediaLookUpResponse buildRequest(Medialookup model){
		return null;
	}


	@Override
	public MediaLookUpRequest build() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public MediaLookUpRequest build(Medialookup model) {
		// TODO Auto-generated method stub
		return null;
	}

}
