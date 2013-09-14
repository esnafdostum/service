package com.tradespeople.common.api;

public abstract class PaginableRequest extends BaseRequest {

	private PaginationRequestPart paginationRequestPart;
	
	public PaginableRequest(){
		paginationRequestPart=new PaginationRequestPart();
	}
	
	public int getPage(){
		return paginationRequestPart.getPage();
	}
	
	public Integer getCount(){
		return paginationRequestPart.getPaginationCount().getCount();
	}
	
	public int getTotal(){
		return paginationRequestPart.getTotal();
	}
	
	public String getSortBy(){
		return paginationRequestPart.getSortBy();
	}
	
	public String getSortType(){
		return paginationRequestPart.getSortType();
	}
	
	public boolean isCached(){
		return paginationRequestPart.isCached();
	}
	
}
