package com.tradespeople.json.response;

import java.util.List;

import com.tradespeople.common.api.BaseResponse;

public class ShopTagResponse extends BaseResponse {
	
	private Long shopId;
	private TagCollectionResponse tags;
	
	public List<TagResponse> shopTags(){
		if (tags!=null) {
			return tags.getResponses();
		}
		return null;
	}
	
	public void addTag(TagResponse tag){
		if (tags!=null) {
			tags.add(tag);
		}
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public TagCollectionResponse getTags() {
		return tags;
	}

	public void setTags(TagCollectionResponse tags) {
		this.tags = tags;
	}
	
}
