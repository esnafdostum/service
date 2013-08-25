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
import com.tradespeople.service.IShopCategoryService;

@Controller("/shopcategory")
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
			shopCategoryService.create(request);
			return BaseResponse.successful();
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail();
		}
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public BaseResponse update(@RequestBody ShopCategoryRequest request){
		try {
			shopCategoryService.update(request);
			return BaseResponse.successful();
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail();
		}
	}
	
	@RequestMapping("/shopsby/{categoryId}")
	public ShopCollectionResponse shopsBy(@RequestBody PaginableRequest request,@PathVariable("categoryId") Long categoryId){
		
		try {
			List<Shop> shops=shopCategoryService.listShopsByCategory(request,categoryId);
			ShopCollectionResponse response=new ShopCollectionResponse();
			for (Shop shop : shops) {
				response.add(shopBuilder.buildResponse(shop));
			}
			return response;
		} catch (TradesPeopleServiceException e) {
			return new ShopCollectionResponse().failResponse();
		}
	}
	
	@RequestMapping("/catrgoryby/{shopId}")
	public ShopCategoryCollectionResponse categoriesBy(@RequestBody PaginableRequest request,@PathVariable("shopId") Long shopId){
		
		try {
			List<Shopcategory> categories=shopCategoryService.listCategoriesByShop(request,shopId);
			ShopCategoryCollectionResponse response=new ShopCategoryCollectionResponse();
			for (Shopcategory shopCategory : categories) {
				response.add(shopCategoryBuilder.buildResponse(shopCategory));
			}
			return response;
		} catch (TradesPeopleServiceException e) {
			return new ShopCategoryCollectionResponse().failResponse();
		}
	}
	
	public void setShopCategoryService(IShopCategoryService shopCategoryService) {
		this.shopCategoryService = shopCategoryService;
	}

	public ShopBuilder getShopBuilder() {
		return shopBuilder;
	}

	public void setShopBuilder(ShopBuilder shopBuilder) {
		this.shopBuilder = shopBuilder;
	}

	public void setShopCategoryBuilder(ShopCategoryBuilder shopCategoryBuilder) {
		this.shopCategoryBuilder = shopCategoryBuilder;
	}
	
}
