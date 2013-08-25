package com.tradespeople.searchcriteria;

import com.tradespeople.common.api.PaginableRequest;

public class PaginationSearchCriteria {

	private int page;
	private int count;
	private int total;
	
	public PaginationSearchCriteria(){
	}
	
	public PaginationSearchCriteria(int page, int count, int total) {
		super();
		this.page = page;
		this.count = count;
		this.total = total;
	}
	public static PaginationSearchCriteria buildFor(PaginableRequest request){
		return new PaginationSearchCriteria(request.getPage(),request.getCount(), request.getTotal());
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
	
	
	
}
