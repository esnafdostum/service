package com.tradespeople.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tradespeople.common.api.BaseController;
import com.tradespeople.common.api.BaseResponse;
import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.json.request.ShopRequest;
import com.tradespeople.json.response.ShopCollectionResponse;
import com.tradespeople.json.response.ShopResponse;
import com.tradespeople.model.Shop;
import com.tradespeople.model.builder.ShopBuilder;
import com.tradespeople.service.IShopService;

@Controller
@RequestMapping("/shop")
public class ShopEndPoint extends BaseController implements IShopEndPoint {

	@Autowired
	private IShopService shopService;

	@Autowired
	private ShopBuilder shopBuilder;

	@RequestMapping("/create")
	@ResponseBody
	public BaseResponse save(@RequestBody ShopRequest request) {
		try {
			Shop shop = shopBuilder.buildFor(request);
			shopService.save(shop);
			return BaseResponse.successful();
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail(e.getMessage());
		}
	}

	@RequestMapping("/update")
	@ResponseBody
	public BaseResponse update(@RequestBody ShopRequest request) {
		try {
			Shop shop = shopBuilder.buildFor(request);
			shopService.update(shop);
			return BaseResponse.successful();
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail(e.getMessage());
		}
	}

	@RequestMapping("/all")
	@ResponseBody
	public ShopCollectionResponse getAllShops() {
		try {
			return shopBuilder.buildResponse(shopService.getAllShops());
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail(e.getMessage(),ShopCollectionResponse.class);
		}
	}

	@RequestMapping("/allByStatus")
	@ResponseBody
	public ShopCollectionResponse getAllShopsByStatus(@PathVariable Byte status) {
		try {
			return shopBuilder.buildResponse(shopService
					.getAllShopsByStatus(status));
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail(e.getMessage(),ShopCollectionResponse.class);
		}
	}

	@RequestMapping("/getById")
	@ResponseBody
	public ShopResponse getShopById(@PathVariable Long id) {
		try {
			return shopBuilder.buildResponse(shopService.getShopById(id));
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail(e.getMessage(),ShopResponse.class);
		}
	}

	@RequestMapping("/getByName")
	@ResponseBody
	public ShopCollectionResponse getShopsByName(@PathVariable String name) {
		try {
			return shopBuilder.buildResponse(shopService.getShopsByName(name));
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail(e.getMessage(),ShopCollectionResponse.class);
		}
	}

	@RequestMapping("/getByCity")
	@ResponseBody
	public ShopCollectionResponse getShopsByCity(@PathVariable String city) {
		try {
			return shopBuilder.buildResponse(shopService.getShopsByCity(city));
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail(e.getMessage(),ShopCollectionResponse.class);
		}
	}

	public IShopService getShopService() {
		return shopService;
	}

	public void setShopService(IShopService shopService) {
		this.shopService = shopService;
	}

	public ShopBuilder getShopBuilder() {
		return shopBuilder;
	}

	public void setShopBuilder(ShopBuilder shopBuilder) {
		this.shopBuilder = shopBuilder;
	}
}
