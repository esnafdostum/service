package com.tradespeople.common.api;

import com.tradespeople.utils.ApiConstants;

public class BaseResponse {
	
	private ApiConstants.ResponseErrorCode errorCode;
	private String errorMessage;
	
	public BaseResponse(){
		this.errorCode=ApiConstants.ResponseErrorCode.NoError;
		this.errorMessage="";
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public ApiConstants.ResponseErrorCode getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(ApiConstants.ResponseErrorCode errorCode) {
		this.errorCode = errorCode;
	}

}
