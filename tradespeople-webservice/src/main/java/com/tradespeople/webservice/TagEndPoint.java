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
import com.tradespeople.service.ITagService;

@Controller
@RequestMapping("/tag")
public class TagEndPoint extends BaseController implements ITagEndPoint {

	@Autowired 
	private ITagService tagService;
	
	@RequestMapping("/create")
	@ResponseBody
	public BaseResponse save(@RequestBody TagRequest request){
		try {
			tagService.create(request);
			return BaseResponse.successful();
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail();
		}
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public BaseResponse update(@RequestBody TagRequest request){
		try {
			tagService.update(request);
			return BaseResponse.successful();
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail();
		}
	}
	
	@RequestMapping("/allTags")
	@ResponseBody
	public TagCollectionResponse allTags(@RequestBody PaginableRequest paginableRequest){
		TagCollectionResponse response=new TagCollectionResponse();
		try {
			
			List<Tag> tags= tagService.listTags(paginableRequest);
			for (Tag tag : tags) {
				response.add(new TagBuilder().buildResponse(tag));
			}
			return response;
		} catch (TradesPeopleServiceException e) {
			return response.failResponse(); 
		}
	}

	public void setTagService(ITagService tagService) {
		this.tagService = tagService;
	} 
	
}
