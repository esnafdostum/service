package com.tradespeople.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.tradespeople.common.api.BaseModel;
import com.tradespeople.utils.ApiConstants.Enums.LogOperation;
import com.tradespeople.utils.ApiConstants.Enums.LogSeverity;
import com.tradespeople.utils.ApiConstants.Enums.UserType;

@Entity
@Table(name = "log")
public class Log extends BaseModel implements java.io.Serializable  {

	private Date updatedDate;
	private String description;
	private LogSeverity logSeverity;
	private LogOperation logOperation;
	private UserType userType;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATEDDATE")
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	@Column(name="DESCRIPTION") 
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Column(name="LOGSEVERITY") 
	@Enumerated(EnumType.STRING) 
	public LogSeverity getLogSeverity() {
		return logSeverity;
	}
	public void setLogSeverity(LogSeverity logSeverity) {
		this.logSeverity = logSeverity;
	}
	
	@Column(name="LOGOPERATION") 
	@Enumerated(EnumType.STRING)
	public LogOperation getLogOperation() {
		return logOperation;
	}
	public void setLogOperation(LogOperation logOperation) {
		this.logOperation = logOperation;
	}
	
	@Column(name="USERTYPE") 
	@Enumerated(EnumType.STRING) 
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
}
