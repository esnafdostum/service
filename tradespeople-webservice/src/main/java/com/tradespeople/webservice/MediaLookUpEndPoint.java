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
import com.tradespeople.json.request.MediaLookUpRequest;
import com.tradespeople.json.response.MediaLookUpCollectionResponse;
import com.tradespeople.json.response.MediaLookUpResponse;
import com.tradespeople.model.Shop;
import com.tradespeople.model.User;
import com.tradespeople.model.builder.MediaLookupBuilder;
import com.tradespeople.service.IMediaLookUpService;

@Controller("/medialookup")
public class MediaLookUpEndPoint extends BaseController implements
		IMediaLookUpEndPoint {

	@Autowired
	private IMediaLookUpService mediaLookUpService;

	@Autowired
	private MediaLookupBuilder mediaLookupBuilder;

	@Override
	@RequestMapping("/createMediaLookUp")
	@ResponseBody
	public BaseResponse create(@RequestBody MediaLookUpRequest medialookup) {
		try {
			mediaLookUpService.create(mediaLookupBuilder.buildFor(medialookup));
			return BaseResponse.successful();
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail(e.getMessage());
		}
	}

	@Override
	@RequestMapping("/updateMediaLookUp")
	@ResponseBody
	public BaseResponse update(@RequestBody MediaLookUpRequest medialookup) {
		try {
			mediaLookUpService.update(mediaLookupBuilder.buildFor(medialookup));
			return BaseResponse.successful();
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail(e.getMessage());
		}
	}

	@Override
	@RequestMapping("/getMediaLookUpById")
	@ResponseBody
	public MediaLookUpResponse getMediaLookupBy(@PathVariable Long id) {
		try {
			return mediaLookupBuilder.buildResponse(mediaLookUpService
					.getMediaLookupBy(id));
		} catch (TradesPeopleServiceException e) {
			return MediaLookUpResponse.fail(e.getMessage(), MediaLookUpResponse.class);
		}
	}

	@Override
	@RequestMapping("/getAllMediaLookUp")
	@ResponseBody
	public MediaLookUpCollectionResponse getAllMediaLookUp() {
		try {
			return mediaLookupBuilder.buildFor(mediaLookUpService
					.getAllMediaLookUp());
		} catch (TradesPeopleServiceException e) {
			return MediaLookUpCollectionResponse.fail(e.getMessage(),MediaLookUpCollectionResponse.class);
		} 
	}

	@Override
	@RequestMapping("/getAllMediaLookUpByStatus")
	@ResponseBody
	public MediaLookUpCollectionResponse getAllMediaLookUpByStatus(@PathVariable Byte status) {
		try {
			return mediaLookupBuilder.buildFor(mediaLookUpService
					.getAllMediaLookUpByStatus(status));
		} catch (TradesPeopleServiceException e) {
			return MediaLookUpCollectionResponse.fail(e.getMessage(),MediaLookUpCollectionResponse.class);
		}
	}

	@Override
	@RequestMapping("/getAllMediaLookUpByUser")
	@ResponseBody
	public MediaLookUpCollectionResponse getAllMediaLookupByUser() {
		try {
			return mediaLookupBuilder.buildFor(mediaLookUpService
					.getAllMediaLookupByUser());
		} catch (TradesPeopleServiceException e) {
			return MediaLookUpCollectionResponse.fail(e.getMessage(),MediaLookUpCollectionResponse.class);
		}
	}

	@Override
	@RequestMapping("/getAllMediaLookUpByShop")
	@ResponseBody
	public MediaLookUpCollectionResponse getAllMediaLookUpByShop() {
		try {
			return mediaLookupBuilder.buildFor(mediaLookUpService
					.getAllMediaLookUpByShop());
		} catch (TradesPeopleServiceException e) {
			return MediaLookUpCollectionResponse.fail(e.getMessage(),MediaLookUpCollectionResponse.class);
		}
	}

	@Override
	@RequestMapping("/getMediaLookUpByUser")
	@ResponseBody
	public MediaLookUpCollectionResponse getMediaLookUpByUser(@PathVariable Long userid) {
		User user = new User();
		user.setId(userid);
		try {
			return mediaLookupBuilder.buildFor(mediaLookUpService
					.getMediaByLookUpUser(user));
		} catch (TradesPeopleServiceException e) {
			return MediaLookUpCollectionResponse.fail(e.getMessage(),MediaLookUpCollectionResponse.class);
		}
	}

	@Override
	@RequestMapping("/getMediaLookUpByShop")
	@ResponseBody
	public MediaLookUpCollectionResponse getMediaLookUpByShop(@PathVariable Long shopid) {
		Shop shop = new Shop();
		shop.setId(shopid);
		try {
			return mediaLookupBuilder.buildFor(mediaLookUpService
					.getMediaLookUpByShop(shop));
		} catch (TradesPeopleServiceException e) {
			return MediaLookUpCollectionResponse.fail(e.getMessage(),MediaLookUpCollectionResponse.class);
		}
	}

	public IMediaLookUpService getMediaLookUpService() {
		return mediaLookUpService;
	}

	public void setMediaLookUpService(IMediaLookUpService mediaLookUpService) {
		this.mediaLookUpService = mediaLookUpService;
	}

	public MediaLookupBuilder getMediaLookupBuilder() {
		return mediaLookupBuilder;
	}

	public void setMediaLookupBuilder(MediaLookupBuilder mediaLookupBuilder) {
		this.mediaLookupBuilder = mediaLookupBuilder;
	}

}
