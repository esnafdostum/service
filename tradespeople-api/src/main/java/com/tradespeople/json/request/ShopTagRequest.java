package com.tradespeople.json.request;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.tradespeople.common.api.BaseRequest;

public class ShopTagRequest extends BaseRequest {

	private Long id;
	@NotNull
	private Long shopId;
	@NotEmpty
	private List<TagRequest> tags;
	private Date createdDate;
	private Date updatedDate;
	
	public Long getShopId() {
		return shopId;
	}
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public List<TagRequest> getTags() {
		return tags;
	}
	public void setTags(List<TagRequest> tags) {
		this.tags = tags;
	}

}
