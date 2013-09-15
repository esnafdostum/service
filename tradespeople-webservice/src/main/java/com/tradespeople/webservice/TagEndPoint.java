package com.tradespeople.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tradespeople.common.api.BaseController;
import com.tradespeople.common.api.BaseResponse;
import com.tradespeople.common.api.PaginableRequest;
import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.json.request.TagRequest;
import com.tradespeople.json.response.TagCollectionResponse;
import com.tradespeople.model.Tag;
import com.tradespeople.model.builder.TagBuilder;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;
import com.tradespeople.service.ITagService;

@Controller
@RequestMapping("/tag")
public class TagEndPoint extends BaseController implements ITagEndPoint {

	@Autowired 
	private ITagService tagService;
	
	@Autowired
	private TagBuilder tagBuilder;
	
	@RequestMapping("/create")
	@ResponseBody
	public BaseResponse save(@RequestBody TagRequest request){
		try {
			tagService.create((tagBuilder.buildFor(request)));
			return BaseResponse.successful();
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail(e.getMessage());
		}
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public BaseResponse update(@RequestBody TagRequest request){
		try {
			tagService.update(tagBuilder.buildFor(request));
			return BaseResponse.successful();
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail(e.getMessage());
		}
	}
	
	@RequestMapping("/allwithPagination")
	@ResponseBody
	public TagCollectionResponse tags(@RequestBody PaginableRequest paginableRequest){
		TagCollectionResponse response=new TagCollectionResponse();
		try {
			
			List<Tag> tags= tagService.listTags(PaginationSearchCriteria.buildFor(paginableRequest));
			for (Tag tag : tags) {
				response.add(new TagBuilder().buildResponse(tag));
			}
			return response;
		} catch (TradesPeopleServiceException e) {
			return response.failResponse(e.getMessage()); 
		}
	}

	public void setTagService(ITagService tagService) {
		this.tagService = tagService;
	}

	public void setTagBuilder(TagBuilder tagBuilder) {
		this.tagBuilder = tagBuilder;
	} 
	
}
