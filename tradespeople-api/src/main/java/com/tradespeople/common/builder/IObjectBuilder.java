package com.tradespeople.common.builder;

import com.tradespeople.common.api.BaseModel;

public interface IObjectBuilder<X,M extends BaseModel> {

	public  X build();
	
	public  M build(X obj);
	public  X build(M model);
	
}
