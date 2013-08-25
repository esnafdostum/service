package com.tradespeople.common.api;

import com.tradespeople.utils.ApiConstants;

public class BaseResponse {
	
	private ApiConstants.ResponseErrorCode errorCode;
	private String errorMessage;
	private ApiConstants.ResponseStatus status;
	
	public BaseResponse(){
		this.errorCode=ApiConstants.ResponseErrorCode.NoError;
		this.setStatus(ApiConstants.ResponseStatus.SuccessFull);
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
	
	public static BaseResponse successful() {
		BaseResponse  base=new BaseResponse();
		return base;
	}
	public static BaseResponse fail() {
		BaseResponse failBase=new BaseResponse();
		failBase.setStatus(ApiConstants.ResponseStatus.Fail);
		return failBase;
	}
	public ApiConstants.ResponseStatus getStatus() {
		return status;
	}
	public void setStatus(ApiConstants.ResponseStatus status) {
		this.status = status;
	}

}
