package com.tradespeople.common.exception;

public class TradesPeopleDaoException extends Exception {

	private static final long serialVersionUID = 784461041142286856L;
	
	public TradesPeopleDaoException(Throwable th){
		super(th);
	}
	
	public TradesPeopleDaoException(String exMsj){
		super(exMsj);
	}
	
	public TradesPeopleDaoException(String exMsj,Throwable th){
		super(exMsj,th);
	}

}
