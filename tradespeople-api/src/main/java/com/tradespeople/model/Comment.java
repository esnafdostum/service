package com.tradespeople.model;
// default package
// Generated Sep 7, 2013 9:10:51 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.tradespeople.common.api.BaseModel;

/**
 * Comment generated by hbm2java
 */
@Entity
@Table(name = "comment")
public class Comment extends BaseModel implements java.io.Serializable {

	private Shop shop;
	private User user;
	private String commenttext;
	private Byte status;

	public Comment() {
	}

	public Comment(long id, Shop shop, User user) {
		this.id = id;
		this.shop = shop;
		this.user = user;
	}

	public Comment(long id, Shop shop, User user, String commenttext,
			Date createddate, Byte status) {
		this.id = id;
		this.shop = shop;
		this.user = user;
		this.commenttext = commenttext;
		this.createddate = createddate;
		this.status = status;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SHOPID", nullable = false)
	public Shop getShop() {
		return this.shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USERID", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "COMMENTTEXT", length = 65535)
	public String getCommenttext() {
		return this.commenttext;
	}

	public void setCommenttext(String commenttext) {
		this.commenttext = commenttext;
	}

	@Column(name = "STATUS")
	public Byte getStatus() {
		return this.status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

}
