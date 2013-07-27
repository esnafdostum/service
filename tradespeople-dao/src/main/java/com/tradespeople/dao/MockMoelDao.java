package com.tradespeople.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tradespeople.common.api.GenericDao;
import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.MockModel;

@Repository
public class MockMoelDao /*extends GenericDao<MockModel, Long>*/ implements IMockModelHibernateDao {

	public MockMoelDao() {
		//super(MockModel.class);
	}

	public List<MockModel> getMockModels() throws TradesPeopleDaoException{
	
		MockModel model1=new MockModel();
		model1.setName("model1");
		model1.setId(1L);
		MockModel model2=new MockModel();
		model2.setName("model2");
		model2.setId(2L);
		List<MockModel> lst=new ArrayList<MockModel>();
		lst.add(model1);
		lst.add(model2);
		
		return lst;
		
	}

}
