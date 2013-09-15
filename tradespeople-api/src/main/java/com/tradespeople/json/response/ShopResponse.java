package com.tradespeople.json.response;

import java.math.BigDecimal;

import com.tradespeople.common.api.BaseResponse;

public class ShopResponse extends BaseResponse {

	public Long id;
	public String username;
	public String categoryname;
	public String name;
	public String address;
	public String district;
	public String city;
	public BigDecimal latitude;
	public BigDecimal longitude;
	public Byte status;
	public String about;
}
