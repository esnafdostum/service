package com.tradespeople.common.api;

public class PaginationRequestPart {

	public static enum PaginationCount {
		ONE("1"), TEN("10"), TWENTY("20"), FIFTY("50"), HUNDRED("100"), ALL("0");
		private String count;
		PaginationCount() {
		}
		PaginationCount(String count) {
			this.count = count;
		}
		public Integer getCount() {
			return Integer.valueOf(count);
		}
	}
	
	public static enum SortType {
		ASC,DESC
	}

	private int page;
	private PaginationCount paginationCount=PaginationCount.ALL;
	private int total;
	private String sortBy;
	private SortType sortType=SortType.ASC;
	private boolean cached;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public PaginationCount getPaginationCount() {
		return paginationCount;
	}

	public void setCount(PaginationCount count) {
		this.paginationCount = count;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

	public SortType getSortType() {
		return sortType;
	}

	public void setSortType(SortType sortType) {
		this.sortType = sortType;
	}

	public boolean isCached() {
		return cached;
	}

	public void setCached(boolean cached) {
		this.cached = cached;
	}

	public void setPaginationCount(PaginationCount paginationCount) {
		this.paginationCount = paginationCount;
	}

}
