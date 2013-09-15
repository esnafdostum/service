package com.tradespeople.searchcriteria;

import com.tradespeople.json.request.SearchRequest;
import com.tradespeople.utils.ApiConstants.Enums.SearchType;

public class SearchApiCriteria {

	private String searchValue;
	private SearchType searchType;
	
	public static SearchApiCriteria buildFor(SearchRequest searchRequest){
		SearchApiCriteria apiCriteria=new SearchApiCriteria();
		apiCriteria.setSearchType(searchRequest.getSearchType());
		apiCriteria.setSearchValue(searchRequest.getSearchValue());
		return apiCriteria;
	}

	public boolean isShopSearchType(){
		return SearchType.SHOP.equals(this.searchType);
	}
	
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
