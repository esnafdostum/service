package com.tradespeople.model;
// default package
// Generated Sep 7, 2013 9:10:51 PM by Hibernate Tools 3.4.0.CR1

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.tradespeople.common.api.BaseModel;

/**
 * Media generated by hbm2java
 */
@Entity
@Table(name = "media")
public class Media extends BaseModel implements  java.io.Serializable {

	private byte type;
	private String path;
	private Date updateddate;
	private Byte status;
	private Long creatoruserid;

	public void setType(byte type) {
		this.type = type;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public void setCreatoruserid(Long creatoruserid) {
		this.creatoruserid = creatoruserid;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setMedialookups(List<Medialookup> medialookups) {
		this.medialookups = medialookups;
	}

	private String description;
	private List<Medialookup> medialookups = new ArrayList<Medialookup>(0);

	public Media() {
	}

	public Media(long id, byte type, String path) {
		this.id = id;
		this.type = type;
		this.path = path;
	}

	public Media(long id, byte type, String path, Date createddate,
			Date updateddate, Byte status, Long creatoruserid,
			String description, List<Medialookup> medialookups) {
		this.id = id;
		this.type = type;
		this.path = path;
		this.createddate = createddate;
		this.updateddate = updateddate;
		this.status = status;
		this.creatoruserid = creatoruserid;
		this.description = description;
		this.medialookups = medialookups;
	}


	public void ListId(long id) {
		this.id = id;
	}

	@Column(name = "TYPE", nullable = false)
	public byte getType() {
		return this.type;
	}

	public void ListType(byte type) {
		this.type = type;
	}

	@Column(name = "PATH", nullable = false, length = 65535)
	public String getPath() {
		return this.path;
	}

	public void ListPath(String path) {
		this.path = path;
	}

	public void ListCreateddate(Date createddate) {
		this.createddate = createddate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATEDDATE", length = 0)
	public Date getUpdateddate() {
		return this.updateddate;
	}

	public void ListUpdateddate(Date updateddate) {
		this.updateddate = updateddate;
	}

	@Column(name = "STATUS")
	public Byte getStatus() {
		return this.status;
	}

	public void ListStatus(Byte status) {
		this.status = status;
	}

	@Column(name = "CREATORUSERID")
	public Long getCreatoruserid() {
		return this.creatoruserid;
	}

	public void ListCreatoruserid(Long creatoruserid) {
		this.creatoruserid = creatoruserid;
	}

	@Column(name = "DESCRIPTION", length = 65535)
	public String getDescription() {
		return this.description;
	}

	public void ListDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "media")
	public List<Medialookup> getMedialookups() {
		return this.medialookups;
	}

	public void ListMedialookups(List<Medialookup> medialookups) {
		this.medialookups = medialookups;
	}

}
