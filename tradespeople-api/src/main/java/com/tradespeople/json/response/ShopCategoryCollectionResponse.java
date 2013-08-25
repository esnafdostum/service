package com.tradespeople.json.response;

import java.util.ArrayList;
import java.util.List;

import com.tradespeople.common.api.BaseResponse;

public class ShopCategoryCollectionResponse extends BaseResponse {

	private List<ShopCategoryResponse> responses;

	public ShopCategoryCollectionResponse() {
		setResponses(new ArrayList<ShopCategoryResponse>());
	}

	public void add(ShopCategoryResponse shopCategoryResponse) {
		responses.add(shopCategoryResponse);
	}

	public ShopCategoryCollectionResponse failResponse(String errorMessage) {
		ShopCategoryCollectionResponse response = new ShopCategoryCollectionResponse();
		BaseResponse fail = BaseResponse.fail(errorMessage);
		response.setResponseStatus(fail.getResponseStatus());
		response.setErrorCode(fail.getErrorCode());
		response.setErrorMessage(fail.getErrorMessage());
		return response;
	}

	public List<ShopCategoryResponse> getResponses() {
		return responses;
	}

	public void setResponses(List<ShopCategoryResponse> responses) {
		this.responses = responses;
	}

}
