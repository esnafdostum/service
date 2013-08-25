package com.tradespeople.common.api;

public abstract class PaginableRequest extends BaseRequest {

	private PaginationRequestPart paginationRequestPart;
	
	public PaginableRequest(){
		paginationRequestPart=new PaginationRequestPart();
	}
	
	public int getPage(){
		return paginationRequestPart.getPage();
	}
	
	public int getMax(){
		return paginationRequestPart.getPage();
	}
	
	public int getTotal(){
		return paginationRequestPart.getPage();
	}
	
}
