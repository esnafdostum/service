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
import com.tradespeople.json.response.ShopCollectionResponse;
import com.tradespeople.json.response.TagCollectionResponse;
import com.tradespeople.model.Shop;
import com.tradespeople.model.Tag;
import com.tradespeople.model.builder.ShopBuilder;
import com.tradespeople.model.builder.TagBuilder;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;
import com.tradespeople.service.IShopTagService;

@Controller
@RequestMapping("/shoptag") 
public class ShopTagEndPoint extends BaseController implements IShopTagEndPoint {
	
	@Autowired
	private IShopTagService shopTagService;
	
	@Autowired
	private TagBuilder tagBuilder;
	
	@Autowired
	private ShopBuilder shopBuilder;
	
	
	@RequestMapping("/tagsbyshop/{shopId}")
	public TagCollectionResponse tagsByShop(@RequestBody PaginableRequest request,@PathVariable("shopId") Long shopId){
		
		try {
			List<Tag> tags=shopTagService.listShopTags(PaginationSearchCriteria.buildFor(request),shopId);
			TagCollectionResponse response=new TagCollectionResponse();
			for (Tag tag : tags) {
				response.add(tagBuilder.buildResponse(tag));
			}
			return response;
		} catch (TradesPeopleServiceException e) {
			return new TagCollectionResponse().failResponse(e.getMessage());
		}
	}
	
	@RequestMapping("/shopsbytag/{tagId}")
	public ShopCollectionResponse shopsByTag(@RequestBody PaginableRequest request,@PathVariable("tagId") Long tagid){
		
		try {
			List<Shop> shops=shopTagService.listShopsByTag(PaginationSearchCriteria.buildFor(request),tagid);
			ShopCollectionResponse response=new ShopCollectionResponse();
			for (Shop shop : shops) {
				response.add(shopBuilder.buildResponse(shop));
			}
			return response;
		} catch (TradesPeopleServiceException e) {
			return new ShopCollectionResponse().failResponse(e.getMessage());
		}
	}
	
	@RequestMapping("/addtagstoshop")
	public BaseResponse addTagsToShop(@RequestBody ShopTagRequest request){
		
		try {
			shopTagService.addTagsToShop(request);
			return BaseResponse.successful();
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail(e.getMessage());
		}
		
	}
	
	@RequestMapping("/deletetagsfromshop")
	public BaseResponse deleteTagsFromShop(@RequestBody ShopTagRequest request){
		
		try {
			shopTagService.deleteTagsFromShop(request);
			return BaseResponse.successful();
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail(e.getMessage());
		}
		
	}

	public void setShopTagService(IShopTagService shopTagService) {
		this.shopTagService = shopTagService;
	}

	public void setTagBuilder(TagBuilder tagBuilder) {
		this.tagBuilder = tagBuilder;
	}

	public void setShopBuilder(ShopBuilder shopBuilder) {
		this.shopBuilder = shopBuilder;
	}

}
