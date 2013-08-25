package com.tradespeople.model;

import java.util.Date;

import com.tradespeople.common.api.BaseModel;

/**
 * Shoptag generated by hbm2java
 */
public class Shoptag extends BaseModel implements java.io.Serializable {

	private int id;
	private Shop shop;
	private Tag tag;
	private Date createddate;
	private Date updateddate;

	public Shoptag() {
	}

	public Shoptag(int id, Shop shop, Tag tag) {
		this.id = id;
		this.shop = shop;
		this.tag = tag;
	}

	public Shoptag(int id, Shop shop, Tag tag, Date createddate,
			Date updateddate) {
		this.id = id;
		this.shop = shop;
		this.tag = tag;
		this.createddate = createddate;
		this.updateddate = updateddate;
	}

	public Shop getShop() {
		return this.shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Tag getTag() {
		return this.tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public Date getUpdateddate() {
		return this.updateddate;
	}

	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}

}
