package com.tradespeople.json.request;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.tradespeople.common.api.BaseRequest;

public class UserRequest extends BaseRequest {

	private Long id;
	@NotNull
	@NotBlank
	private String username;
	@NotNull
	@NotBlank
	private String password;
	private String token;
	private Byte status;
	@NotNull
	@NotBlank
	private String name;
	@NotNull
	@NotBlank
	private String surname;
	@NotEmpty
	private List<RoleRequest> roles=new ArrayList<RoleRequest>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public List<RoleRequest> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleRequest> roles) {
		this.roles = roles;
	}
	
}
