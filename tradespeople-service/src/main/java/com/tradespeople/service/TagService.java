package com.tradespeople.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tradespeople.common.api.PaginableRequest;
import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.dao.ITagHibernateDao;
import com.tradespeople.json.request.TagRequest;
import com.tradespeople.model.Tag;
import com.tradespeople.model.builder.TagBuilder;
import com.tradespeople.utils.ApiUtils;

@Service
public class TagService implements ITagService{
	
	@Autowired
	private ITagHibernateDao dao;
	
	@Autowired
	private TagBuilder builder;

	@Transactional
	public void create(TagRequest request) throws TradesPeopleServiceException {
		try {
			Tag tag = builder.buildFor(request);
			dao.create(tag);
		} catch (TradesPeopleDaoException e) {
			new TradesPeopleServiceException(e);
		}
	}
	
	@Transactional
	public void update(TagRequest request) throws TradesPeopleServiceException {
		try {
			Tag tag = builder.buildFor(request);
			if (!tag.isPersisted()) {
				ApiUtils.throwPersistedException();
			}
			dao.update(tag);
		} catch (TradesPeopleDaoException e) {
			new TradesPeopleServiceException(e);
		}
	}
	
	@Override
	public List<Tag> listTags(PaginableRequest paginableRequest) throws TradesPeopleServiceException {
		return null;
	}

	
	public void setDao(ITagHibernateDao dao) {
		this.dao = dao;
	}

	public void setBuilder(TagBuilder builder) {
		this.builder = builder;
	}

}
