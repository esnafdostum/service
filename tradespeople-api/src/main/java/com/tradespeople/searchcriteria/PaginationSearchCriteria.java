package com.tradespeople.searchcriteria;

import org.apache.commons.lang.StringUtils;

import com.tradespeople.common.api.PaginableRequest;

public class PaginationSearchCriteria {

	private Integer page;
	private Integer count;
	private Integer total;
	private String sortBy;
	private String sortType;
	private boolean cached;
	
	public static PaginationSearchCriteria emptyPaginationSearchCriteria(){
		PaginationSearchCriteria searchCriteria=new PaginationSearchCriteria();
		return searchCriteria;
	}
	
	public PaginationSearchCriteria(){
	}
	
	public PaginationSearchCriteria(Integer page, Integer count, Integer total,String sortBy, String sortType, boolean cached) {
		super();
		this.page = page;
		this.count = count;
		this.total = total;
		this.sortBy = sortBy;
		this.sortType = sortType;
		this.cached = cached;
	}
	
	public static PaginationSearchCriteria buildFor(PaginableRequest request){
		return new PaginationSearchCriteria(request.getPage(),request.getCount(), request.getTotal(),request.getSortBy(),request.getSortType(),request.isCached());
	}
	
	public boolean hasPagination(){
		if (page!=null && count!=null && count!=0) {
			return true;
		}
		return false;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public boolean isSortDescending() {
		if (StringUtils.isNotBlank(sortType)) {
			return StringUtils.upperCase("desc").equals(sortType);
		}
		return false;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	public boolean isCached() {
		return cached;
	}

	public void setCached(boolean cached) {
		this.cached = cached;
	}
	
}
