package com.tradespeople.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tradespeople.common.api.BaseController;
import com.tradespeople.common.api.BaseResponse;
import com.tradespeople.common.api.PaginableRequest;
import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.json.request.ShopTagRequest;
import com.tradespeople.json.response.TagCollectionResponse;
import com.tradespeople.model.Tag;
import com.tradespeople.model.builder.TagResponseBuilder;
import com.tradespeople.service.IShopTagService;

@Controller
@RequestMapping("/shoptags") 
public class ShopTagEndPoint extends BaseController implements IShopTagEndPoint {
	
	@Autowired
	private IShopTagService shopTagService;
	
	@RequestMapping("/tagsbyshop/{shopId}")
	public TagCollectionResponse tagsByShop(@RequestBody PaginableRequest request,@PathVariable("shopId") Long shopId){
		
		try {
			List<Tag> tags=shopTagService.listShopTags(request,shopId);
			TagCollectionResponse response=new TagCollectionResponse();
			for (Tag tag : tags) {
				response.add(new TagResponseBuilder().build(tag));
			}
			return response;
			
		} catch (TradesPeopleServiceException e) {
			return new TagCollectionResponse().failResponse();
		}
	}
	
	@RequestMapping("/addtagstoshop")
	public BaseResponse addTagsToShop(@RequestBody ShopTagRequest request){
		
		try {
			shopTagService.addTagsToShop(request);
			return BaseResponse.successful();
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail();
		}
		
	}

	public void setShopTagService(IShopTagService shopTagService) {
		this.shopTagService = shopTagService;
	}

}
