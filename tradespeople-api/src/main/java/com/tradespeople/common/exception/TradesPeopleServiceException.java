package com.tradespeople.common.exception;

public class TradesPeopleServiceException extends  Exception {

	private static final long serialVersionUID = 7724549301983510076L;

	public TradesPeopleServiceException(Throwable th){
		super(th);
	}
	
	public TradesPeopleServiceException(String exMsj){
		super(exMsj);
	}
	
	public TradesPeopleServiceException(String exMsj,Throwable th){
		super(exMsj,th);
	}

}
