package com.tradespeople.service;

import java.util.List;

import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.model.MockModel;

public interface IMockModelService {

	public List<MockModel> getMockModels() throws TradesPeopleServiceException;
}
