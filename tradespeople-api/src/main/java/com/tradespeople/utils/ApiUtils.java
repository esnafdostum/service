package com.tradespeople.utils;

import com.tradespeople.common.exception.TradesPeopleServiceException;

public class ApiUtils {
	
	private static String PERSISTED_ERROR_TEXT="Persisted Object Is Obligation";
	
	public static void throwPersistedException() throws TradesPeopleServiceException{
		 throw new TradesPeopleServiceException(PERSISTED_ERROR_TEXT);
	}

}
