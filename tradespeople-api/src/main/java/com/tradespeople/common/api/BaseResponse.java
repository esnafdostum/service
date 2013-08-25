package com.tradespeople.common.api;

import com.tradespeople.utils.ApiConstants;

public class BaseResponse {
	
	private ApiConstants.Enums.ResponseErrorCode errorCode;
	private String errorMessage;
	private ApiConstants.Enums.ResponseStatus status;
	
	public BaseResponse(){
		this.errorCode=ApiConstants.Enums.ResponseErrorCode.NoError;
		this.setStatus(ApiConstants.Enums.ResponseStatus.SuccessFull);
		this.errorMessage="";
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public ApiConstants.Enums.ResponseErrorCode getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(ApiConstants.Enums.ResponseErrorCode errorCode) {
		this.errorCode = errorCode;
	}
	
	public static BaseResponse successful() {
		BaseResponse  base=new BaseResponse();
		return base;
	}
	public static BaseResponse fail() {
		BaseResponse failBase=new BaseResponse();
		failBase.setStatus(ApiConstants.Enums.ResponseStatus.Fail);
		return failBase;
	}
	public ApiConstants.Enums.ResponseStatus getStatus() {
		return status;
	}
	public void setStatus(ApiConstants.Enums.ResponseStatus status) {
		this.status = status;
	}

}
