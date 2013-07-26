package com.tradespeople.dao;

import java.util.ArrayList;
import java.util.List;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.MockModel;

public class MockMoelDao implements IMockModelHibernateDao {

	public List<MockModel> getMockModels() throws TradesPeopleDaoException{
	
		MockModel model1=new MockModel();
		model1.setName("model1");
		MockModel model2=new MockModel();
		model2.setName("model2");
		List<MockModel> lst=new ArrayList<MockModel>();
		lst.add(model1);
		lst.add(model2);
		
		return lst;
		
	}

}
