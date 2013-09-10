package com.tradespeople.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tradespeople.common.api.BaseController;
import com.tradespeople.common.api.BaseResponse;
import com.tradespeople.common.api.PaginableRequest;
import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.json.request.ShopCategoryRequest;
import com.tradespeople.json.response.ShopCategoryCollectionResponse;
import com.tradespeople.json.response.ShopCollectionResponse;
import com.tradespeople.model.Shop;
import com.tradespeople.model.Shopcategory;
import com.tradespeople.model.builder.ShopBuilder;
import com.tradespeople.model.builder.ShopCategoryBuilder;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;
import com.tradespeople.service.IShopCategoryService;

@Controller
@RequestMapping("/shopcategory")
public class ShopCategoryEndPoint extends BaseController implements IShopCategoryEndPoint {

	@Autowired
	private IShopCategoryService shopCategoryService;
	
	@Autowired
	private ShopBuilder shopBuilder;
	
	@Autowired
	private ShopCategoryBuilder shopCategoryBuilder;
	
	@RequestMapping("/create")
	@ResponseBody
	public BaseResponse save(@RequestBody ShopCategoryRequest request){
		try {
			shopCategoryService.create(shopCategoryBuilder.buildFor(request));
			return BaseResponse.successful();
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail(e.getMessage());
		}
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public BaseResponse update(@RequestBody ShopCategoryRequest request){
		try {
			shopCategoryService.update(shopCategoryBuilder.buildFor(request));
			return BaseResponse.successful();
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail(e.getMessage());
		}
	}
	
	@RequestMapping("/shopsby/{categoryId}")
	public ShopCollectionResponse shopsBy(@RequestBody PaginableRequest request,@PathVariable("categoryId") Long categoryId){
		
		try {
			List<Shop> shops=shopCategoryService.listShopsByCategory(PaginationSearchCriteria.buildFor(request),categoryId);
			ShopCollectionResponse response=new ShopCollectionResponse();
			for (Shop shop : shops) {
				response.add(shopBuilder.buildResponse(shop));
			}
			return response;
		} catch (TradesPeopleServiceException e) {
			return new ShopCollectionResponse().failResponse(e.getMessage());
		}
	}
	
	@RequestMapping("/catrgoryby/{shopId}")
	public ShopCategoryCollectionResponse categoriesBy(@RequestBody PaginableRequest request,@PathVariable("shopId") Long shopId){
		
		try {
			List<Shopcategory> categories=shopCategoryService.listCategoriesByShop(PaginationSearchCriteria.buildFor(request),shopId);
			ShopCategoryCollectionResponse response=new ShopCategoryCollectionResponse();
			for (Shopcategory shopCategory : categories) {
				response.add(shopCategoryBuilder.buildResponse(shopCategory));
			}
			return response;
		} catch (TradesPeopleServiceException e) {
			return new ShopCategoryCollectionResponse().failResponse(e.getMessage());
		}
	}
	
	public void setShopCategoryService(IShopCategoryService shopCategoryService) {
		this.shopCategoryService = shopCategoryService;
	}
	
	public void setShopBuilder(ShopBuilder shopBuilder) {
		this.shopBuilder = shopBuilder;
	}

	public void setShopCategoryBuilder(ShopCategoryBuilder shopCategoryBuilder) {
		this.shopCategoryBuilder = shopCategoryBuilder;
	}
	
}
