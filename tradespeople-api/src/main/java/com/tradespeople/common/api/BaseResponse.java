package com.tradespeople.common.api;

import com.tradespeople.utils.ApiConstants;

public class BaseResponse {
	
	private ApiConstants.Enums.ResponseErrorCode errorCode;
	private String errorMessage;
	private ApiConstants.Enums.ResponseStatus responseStatus;
	
	public BaseResponse(){
		this.errorCode=ApiConstants.Enums.ResponseErrorCode.NoError;
		this.setResponseStatus(ApiConstants.Enums.ResponseStatus.SuccessFull);
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

	public static BaseResponse fail(String errorMessage) {
		BaseResponse failBase=new BaseResponse();
		failBase.setResponseStatus(ApiConstants.Enums.ResponseStatus.Fail);
		failBase.setErrorMessage(errorMessage);
		return failBase;
	}

	public static <T extends BaseResponse> T fail(String errorMessage,Class<T> clazz) {
		T failBase = null;
		try {
			failBase = clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		failBase.setResponseStatus(ApiConstants.Enums.ResponseStatus.Fail);
		failBase.setErrorMessage(errorMessage);
		return failBase;
	}

	public ApiConstants.Enums.ResponseStatus getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(ApiConstants.Enums.ResponseStatus status) {
		this.responseStatus = status;
	}

}
