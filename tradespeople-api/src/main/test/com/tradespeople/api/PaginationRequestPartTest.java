package com.tradespeople.api;

import junit.framework.Assert;

import org.junit.Test;

import com.tradespeople.common.api.PaginationRequestPart;

public class PaginationRequestPartTest {

	@Test
	public void shouldReturnNumerialValueForPaginationCount(){
		Assert.assertEquals("50", PaginationRequestPart.PaginationCount.FIFTY.getCount());
	}
	
}
