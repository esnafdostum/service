package com.tradespeople.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.dao.ITagHibernateDao;
import com.tradespeople.model.Tag;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;
import com.tradespeople.utils.ApiUtils;

@Service
public class TagService implements ITagService{
	
	
	@Autowired
	private ITagHibernateDao dao;

	@Transactional
	public void create(Tag model) throws TradesPeopleServiceException {
		try {
			dao.create(model);
		} catch (TradesPeopleDaoException e) {
			new TradesPeopleServiceException(e);
		}
	}
	
	@Transactional
	public void update(Tag model) throws TradesPeopleServiceException {
		try {
			if (!model.hasPersisted()) {
				ApiUtils.throwPersistedException();
			}
			dao.update(model);
		} catch (TradesPeopleDaoException e) {
			new TradesPeopleServiceException(e);
		}
	}
	
	@Transactional(readOnly=true)
	public List<Tag> listTags(PaginationSearchCriteria searchCriteria) throws TradesPeopleServiceException {
		try {
			return dao.listTags(searchCriteria);
		} catch (TradesPeopleDaoException e) {
			new TradesPeopleServiceException(e);
		}
		return new ArrayList<Tag>();
	}


	@Override
	@Transactional
	public List<Tag> getAllTagsByStatus(Byte status)
			throws TradesPeopleServiceException {
		try {
			return dao.getAllTagsByStatus(status);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	@Override
	@Transactional
	public List<Tag> getTagsByName(String name)
			throws TradesPeopleServiceException {
		try {
			return dao.getTagsByName(name);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	@Override
	@Transactional
	public Tag getTagById(Long id) throws TradesPeopleServiceException {
		try {
			return dao.getTagById(id);
		} catch (TradesPeopleDaoException e) {
			throw new TradesPeopleServiceException(e);
		}
	}

	public void setDao(ITagHibernateDao dao) {
		this.dao = dao;
	}

}
