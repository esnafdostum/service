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

	private int page;
	private PaginationCount paginationCount;
	private int total;
	private String sortBy;
	private String sortType;
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
