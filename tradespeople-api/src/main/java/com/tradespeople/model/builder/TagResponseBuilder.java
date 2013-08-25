package com.tradespeople.model.builder;

import org.springframework.stereotype.Component;

import com.tradespeople.common.builder.ResponseBuilder;
import com.tradespeople.json.response.TagResponse;
import com.tradespeople.model.Tag;

@Component
public class TagResponseBuilder extends ResponseBuilder<TagResponse, Tag> {

	@Override
	public TagResponse build() {
		return null;
	}
	
	@Override
	public Tag build(TagResponse obj) {
		return null;
	}

	@Override
	public TagResponse build(Tag model) {
		TagResponse response=new  TagResponse();
		response.setId(model.getId());
		response.setName(model.getName());
		return response;
	}

}
