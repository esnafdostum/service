package com.tradespeople.json.request;

import java.math.BigDecimal;
import java.util.Date;

import com.tradespeople.common.api.BaseRequest;

public class ShopRequest extends BaseRequest {
	public String name;
	public String address;
	public String district;
	public String city;
	public BigDecimal latitude;
	public BigDecimal longitude;
	public Byte status;
	public String about;
	public Long userid;
}
