package com.tradespeople.json.request;

import com.tradespeople.common.api.BaseRequest;
import com.tradespeople.utils.ApiConstants.Enums.SearchType;

public class SearchRequest extends BaseRequest{

	private String searchValue;
	private SearchType searchType;

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public SearchType getSearchType() {
		return searchType;
	}

	public void setSearchType(SearchType searchType) {
		this.searchType = searchType;
	}
}
