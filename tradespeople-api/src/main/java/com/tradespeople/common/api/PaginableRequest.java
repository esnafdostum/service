package com.tradespeople.common.api;

import com.tradespeople.common.api.PaginationRequestPart.PaginationCount;

public abstract class PaginableRequest extends BaseRequest {

	private PaginationRequestPart paginationRequestPart;
	
	public PaginableRequest(){
		paginationRequestPart=new PaginationRequestPart();
	}
	
	public int getPage(){
		return paginationRequestPart.getPage();
	}
	
	public PaginationCount getCount(){
		return paginationRequestPart.getCount();
	}
	
	public int getTotal(){
		return paginationRequestPart.getTotal();
	}
	
}
