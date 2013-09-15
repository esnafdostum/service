package com.tradespeople.json.response;

import java.util.ArrayList;
import java.util.List;

import com.tradespeople.common.api.BaseResponse;

public class ShopCollectionResponse extends BaseResponse {

	private List<ShopResponse> responses;

	public ShopCollectionResponse() {
		setResponses(new ArrayList<ShopResponse>());
	}

	public void add(ShopResponse shopResponse) {
		getResponses().add(shopResponse);
	}
	public List<ShopResponse> getResponses() {
		return responses;
	}

	public void setResponses(List<ShopResponse> responses) {
		this.responses = responses;
	}

}
