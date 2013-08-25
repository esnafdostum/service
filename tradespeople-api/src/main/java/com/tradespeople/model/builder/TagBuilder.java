package com.tradespeople.model.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tradespeople.json.request.TagRequest;
import com.tradespeople.json.response.TagResponse;
import com.tradespeople.model.Tag;

@Component
public class TagBuilder {
	
	@Autowired 
	private TagRequestBuilder requestBuilder;
	
	@Autowired
	private TagResponseBuilder responsebuilder;
	
	public Tag buildFor(TagRequest request){
		return requestBuilder.build(request);
	}
	
	public Tag buildFor(TagResponse response){
		return responsebuilder.build(response);
	}
	
	public TagRequest buildRequest(Tag model){
		return requestBuilder.build(model);
	}
	
	public TagResponse buildResponse(Tag model){
		return responsebuilder.build(model);
	}

	public void setRequestBuilder(TagRequestBuilder requestBuilder) {
		this.requestBuilder = requestBuilder;
	}

	public void setResponsebuilder(TagResponseBuilder responsebuilder) {
		this.responsebuilder = responsebuilder;
	}

}
