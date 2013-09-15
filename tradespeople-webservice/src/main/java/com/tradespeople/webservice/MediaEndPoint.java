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
import com.tradespeople.json.request.MediaRequest;
import com.tradespeople.json.response.MediaCollectionResponse;
import com.tradespeople.json.response.MediaResponse;
import com.tradespeople.model.builder.MediaBuilder;
import com.tradespeople.service.IMediaService;

@Controller
@RequestMapping("/media")
public class MediaEndPoint extends BaseController implements IMediaEndPoint {

	@Autowired
	private IMediaService mediaService;

	@Autowired
	private MediaBuilder mediaBuilder;

	
	@RequestMapping("/create")
	@ResponseBody
	public BaseResponse create(@RequestBody MediaRequest media) {
		try {
			mediaService.create(mediaBuilder.buildFor(media));
			return BaseResponse.successful();
		} catch (Exception e) {
			return BaseResponse.fail(e.getMessage());
		}
	}

	@RequestMapping("/update")
	@ResponseBody
	public BaseResponse update(@RequestBody MediaRequest media) {
		try {
			mediaService.update(mediaBuilder.buildFor(media));
			return BaseResponse.successful();
		} catch (Exception e) {
			return BaseResponse.fail(e.getMessage());
		}
	}

	@RequestMapping("/getById/{id}")
	@ResponseBody
	public MediaResponse getMediaBy(@PathVariable("id") Long id) {
		try {
			return mediaBuilder.buildResponse(mediaService.getMediaBy(id));
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail(e.getMessage(),MediaResponse.class);
		}
	}

	@Override
	@RequestMapping("/all")
	@ResponseBody
	public MediaCollectionResponse getAllMedia() {
		try {
			return mediaBuilder.buildFor(mediaService.getAllMedia());
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail(e.getMessage(),MediaCollectionResponse.class);
		}
	}

	@Override
	@RequestMapping("/getAllByStatus/{status}")
	@ResponseBody
	public MediaCollectionResponse getAllMediaByStatus(@PathVariable("status") Byte status) {
		try {
			return mediaBuilder.buildFor(mediaService.getAllMediaByStatus(status));
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail(e.getMessage(),MediaCollectionResponse.class);
		}
	}

	@Override
	@RequestMapping("/getAllByType/{type}")
	@ResponseBody
	public MediaCollectionResponse getAllMediaByType(@PathVariable("type") String type) {
		try {
			return mediaBuilder.buildFor(mediaService.getAllMediaByType(type));
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail(e.getMessage(),MediaCollectionResponse.class);
		}
	}

	@Override
	@RequestMapping("/getAllByTypeAndStatus/{type}/{status}")
	@ResponseBody
	public MediaCollectionResponse getAllMediaByType(@PathVariable("type") String type,@PathVariable("status") String status) {
		try {
			return mediaBuilder.buildFor(mediaService.getAllMediaByType(type,status));
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail(e.getMessage(),MediaCollectionResponse.class);
		}
	}

	public IMediaService getMediaService() {
		return mediaService;
	}

	public void setMediaService(IMediaService mediaService) {
		this.mediaService = mediaService;
	}

	public MediaBuilder getMediaBuilder() {
		return mediaBuilder;
	}

	public void setMediaBuilder(MediaBuilder mediaBuilder) {
		this.mediaBuilder = mediaBuilder;
	}

}
