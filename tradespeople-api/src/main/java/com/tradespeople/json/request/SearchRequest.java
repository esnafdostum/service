package com.tradespeople.json.request;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.tradespeople.common.api.BaseRequest;
import com.tradespeople.utils.ApiConstants.Enums.SearchType;

public class SearchRequest extends BaseRequest{

	@NotNull
	@NotBlank
	@NotEmpty
	private String searchValue;
	
	@NotNull
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
