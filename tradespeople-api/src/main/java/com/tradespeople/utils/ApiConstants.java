package com.tradespeople.utils;

public class ApiConstants {

	public static enum ResponseErrorCode{
		NoError("0"),NotSupportedParameter("1");
		ResponseErrorCode(String errorCode){
		}
	}
	
	public static enum ResponseStatus{
		SuccessFull("0"),Fail("1");
		ResponseStatus(String errorCode){
		}
	}
	
}
