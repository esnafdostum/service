package com.tradespeople.json.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.tradespeople.common.api.BaseRequest;

public class CommentRequest extends BaseRequest {
	
	
	private Long Id;
	
	@NotNull
	@NotBlank
	private Long shopId;
	
	@NotNull
	@NotBlank
	private Long userId;
	
	@NotNull
	@NotBlank
	@Length(max=1024)
	private String commenttext;
	
	@NotNull
	@NotBlank
	private Byte status;
	
	public String getCommenttext() {
		return commenttext;
	}
	public void setCommenttext(String commenttext) {
		this.commenttext = commenttext;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
}
