package com.tradespeople.model.builder;

import org.springframework.stereotype.Component;

import com.tradespeople.common.builder.RequestBuilder;
import com.tradespeople.json.request.TagRequest;
import com.tradespeople.model.Tag;

@Component
public class TagRequestBuilder extends RequestBuilder<TagRequest, Tag>{

	@Override
	public TagRequest build() {
		return null;
	}

	@Override
	public Tag build(TagRequest obj) {
		Tag modelTag=new Tag();
		modelTag.setCreateddate(obj.getCreatedDate());
		modelTag.setId(obj.getId());
		modelTag.setName(obj.getName());
		modelTag.setUpdateddate(obj.getUpdatedDate());
		return modelTag;
	}

	@Override
	public TagRequest build(Tag model) {
		return null;
	}

}
