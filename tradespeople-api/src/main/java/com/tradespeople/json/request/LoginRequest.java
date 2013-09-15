package com.tradespeople.json.request;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.tradespeople.common.api.BaseRequest;

public class LoginRequest extends BaseRequest {
	
	@NotEmpty
	@NotBlank
	public String username;
	
	@NotEmpty
	@NotBlank
	public byte[] bytesPassword;

}
