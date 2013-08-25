package com.tradespeople.common.api;

public class PaginationRequestPart {

	public enum PaginationCount {
		ONE("1"), TEN("10"), TWENTY("20"), FIFTY("50"), HUNDRED("100"), ALL("0");
		public String count;
		PaginationCount() {
		}
		PaginationCount(String count) {
			this.count = count;
		}
	}

	private int page;
	private PaginationCount count;
	private int total;

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

	public PaginationCount getCount() {
		return count;
	}

	public void setCount(PaginationCount count) {
		this.count = count;
	}

}
