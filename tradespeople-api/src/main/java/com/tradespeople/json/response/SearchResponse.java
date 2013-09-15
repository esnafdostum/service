package com.tradespeople.json.response;

import com.tradespeople.common.api.BaseResponse;
import com.tradespeople.utils.ApiConstants.Enums.SearchType;

public class SearchResponse extends BaseResponse {

	private ShopCollectionResponse shopCollectionResponse;
	private SearchType searchType;
	
	public SearchResponse(){
		shopCollectionResponse=new ShopCollectionResponse();
	}
	
	public void add(ShopResponse shopResponse){
		if (!shopCollectionResponse.getResponses().contains(shopResponse)) {
			shopCollectionResponse.add(shopResponse);
		}
	}

	public ShopCollectionResponse getShopCollectionResponse() {
		return shopCollectionResponse;
	}

	public SearchType getSearchType() {
		return searchType;
	}

	public void setSearchType(SearchType searchType) {
		this.searchType = searchType;
	}
}
