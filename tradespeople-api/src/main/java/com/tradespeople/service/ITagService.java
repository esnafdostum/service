package com.tradespeople.service;

import java.util.List;

import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.model.Tag;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;

public interface ITagService {

	public void create(Tag model)  throws TradesPeopleServiceException ;

	public List<Tag> listTags(PaginationSearchCriteria searchCriteria) throws TradesPeopleServiceException ;

	public void update(Tag model) throws TradesPeopleServiceException ;

}
