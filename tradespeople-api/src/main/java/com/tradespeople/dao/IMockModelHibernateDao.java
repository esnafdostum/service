package com.tradespeople.dao;

import java.util.List;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.MockModel;

public interface IMockModelHibernateDao {

	public List<MockModel> getMockModels() throws TradesPeopleDaoException;
}
