package com.tradespeople.dao;

import java.util.List;

import com.tradespeople.common.exception.TradesPeopleDaoException;
import com.tradespeople.model.Tag;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;


public interface ITagHibernateDao{

	public void create(Tag tag) throws TradesPeopleDaoException;

	public void update(Tag tag) throws TradesPeopleDaoException;

	public List<Tag> listTags(PaginationSearchCriteria searchCriteria) throws TradesPeopleDaoException;

	public List<Tag> getAllTagsByStatus(Byte status) throws TradesPeopleDaoException;
	
	public List<Tag> getTagsByName(String name) throws TradesPeopleDaoException;

	Tag  getTagById(Long id) throws TradesPeopleDaoException;


}
