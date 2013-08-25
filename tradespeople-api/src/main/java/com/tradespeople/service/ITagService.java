package com.tradespeople.service;

import java.util.List;

import com.tradespeople.common.api.PaginableRequest;
import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.json.request.TagRequest;
import com.tradespeople.model.Tag;

public interface ITagService {

	public void create(TagRequest request)  throws TradesPeopleServiceException ;

	public List<Tag> listTags(PaginableRequest paginableRequest) throws TradesPeopleServiceException ;

	public void update(TagRequest request) throws TradesPeopleServiceException ;

}
