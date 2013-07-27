package com.tradespeople.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.dao.IMockModelHibernateDao;
import com.tradespeople.dao.MockMoelDao;
import com.tradespeople.model.MockModel;

@Service
public class MockModelService implements IMockModelService {

	@Autowired
	private transient IMockModelHibernateDao mockModelHibernateDao;
	
	public List<MockModel> getMockModels() throws TradesPeopleServiceException{
		try {
			return mockModelHibernateDao.getMockModels();
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	public void setMockModelHibernateDao(IMockModelHibernateDao mockModelHibernateDao) {
		this.mockModelHibernateDao = mockModelHibernateDao;
	}
	
}
