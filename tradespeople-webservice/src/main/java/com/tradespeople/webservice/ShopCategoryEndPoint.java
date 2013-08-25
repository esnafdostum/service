package com.tradespeople.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tradespeople.common.api.BaseController;
import com.tradespeople.common.api.BaseResponse;
import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.json.request.ShopCategoryRequest;
import com.tradespeople.service.IShopCategoryService;

@Controller("shopcategory")
public class ShopCategoryEndPoint extends BaseController implements IShopCategoryEndPoint {

	@Autowired
	private IShopCategoryService shopCategoryService;
	
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
	

	public void setShopCategoryService(IShopCategoryService shopCategoryService) {
		this.shopCategoryService = shopCategoryService;
	}
	
}
