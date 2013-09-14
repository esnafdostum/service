package com.tradespeople.common.api;

public  class PaginableRequest extends BaseRequest {

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
		return paginationRequestPart.getSortType().toString();
	}
	
	public boolean isCached(){
		return paginationRequestPart.isCached();
	}
	
	public void setPage(int page){
		paginationRequestPart.setPage(page);
	}
	
	public void setCount(PaginationRequestPart.PaginationCount paginationCount){
		paginationRequestPart.setPaginationCount(paginationCount);
	}
	
	public void setTotal(int total){
		paginationRequestPart.setTotal(total);
	}
	
	public void setSortBy(String sortBy){
		paginationRequestPart.setSortBy(sortBy);
	}
	
	public void setSortType(PaginationRequestPart.SortType sortType){
		paginationRequestPart.setSortType(sortType);
	}
	
	public void setCached(boolean isCached){
		paginationRequestPart.setCached(isCached);
	}
	
}
