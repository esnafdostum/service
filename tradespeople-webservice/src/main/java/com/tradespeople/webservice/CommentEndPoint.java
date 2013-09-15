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
import com.tradespeople.json.request.CommentRequest;
import com.tradespeople.json.response.CommentCollectionResponse;
import com.tradespeople.model.Comment;
import com.tradespeople.model.builder.CommentBuilder;
import com.tradespeople.searchcriteria.PaginationSearchCriteria;
import com.tradespeople.service.ICommentService;

@Controller
@RequestMapping("/comment")
public class CommentEndPoint extends BaseController implements ICommentEndPoint {
	
	@Autowired
	private ICommentService commentService;
	
	@Autowired
	private CommentBuilder commentBuilder;
	
	@RequestMapping("/create")
	@ResponseBody
	public BaseResponse save(@RequestBody CommentRequest request){
		try {
			commentService.create(commentBuilder.buildFor(request));
			return BaseResponse.successful();
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail(e.getMessage());
		}
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public BaseResponse update(@RequestBody CommentRequest request){
		try {
			commentService.update(commentBuilder.buildFor(request));
			return BaseResponse.successful();
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail(e.getMessage());
		}
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public BaseResponse delete(@RequestBody CommentRequest request){
		try {
			commentService.delete(commentBuilder.buildFor(request));
			return BaseResponse.successful();
		} catch (TradesPeopleServiceException e) {
			return BaseResponse.fail(e.getMessage());
		}
	}
	
	@RequestMapping("/getByShopWithPagination/{shopId}")
	public CommentCollectionResponse commentsByShop(@RequestBody PaginableRequest request,@PathVariable("shopId") Long shopId){
		
		try {
			List<Comment> comments=commentService.listShopComments(PaginationSearchCriteria.buildFor(request),shopId);
			CommentCollectionResponse response=new CommentCollectionResponse();
			for (Comment comment : comments) {
				response.add(commentBuilder.buildResponse(comment));
			}
			return response;
		} catch (TradesPeopleServiceException e) {
			return  BaseResponse.fail(e.getMessage(), CommentCollectionResponse.class);
		}
	}
	
	@RequestMapping("/getByUserWithPagination/{userId}")
	public CommentCollectionResponse commentsByUser(@RequestBody PaginableRequest request,@PathVariable("userId") Long userId){
		
		try {
			List<Comment> comments=commentService.listUserComments(PaginationSearchCriteria.buildFor(request),userId);
			CommentCollectionResponse response=new CommentCollectionResponse();
			for (Comment comment : comments) {
				response.add(commentBuilder.buildResponse(comment));
			}
			return response;
		} catch (TradesPeopleServiceException e) {
			return  BaseResponse.fail(e.getMessage(), CommentCollectionResponse.class);
		}
	}
	
	@RequestMapping("/getByUserAndShopWithPagination/{userId}/{shopId}")
	public CommentCollectionResponse commentsByUserAndShop(@RequestBody PaginableRequest request,@PathVariable("userId") Long userId,@PathVariable("shopId") Long shopId){
		
		try {
			List<Comment> comments=commentService.listCommentsByShopAndUser(PaginationSearchCriteria.buildFor(request),userId,shopId);
			CommentCollectionResponse response=new CommentCollectionResponse();
			for (Comment comment : comments) {
				response.add(commentBuilder.buildResponse(comment));
			}
			return response;
		} catch (TradesPeopleServiceException e) {
			return  BaseResponse.fail(e.getMessage(), CommentCollectionResponse.class);
		}
	}

	public void setCommentService(ICommentService commentService) {
		this.commentService = commentService;
	}

	public void setCommentBuilder(CommentBuilder commentBuilder) {
		this.commentBuilder = commentBuilder;
	}
	
}
