package com.tradespeople.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tradespeople.service.IMockModelService;

@Controller
@RequestMapping("/mockEndPoint")
public class MockModelEndpoint implements IMockModelEndPoint {

	@Autowired
	private transient IMockModelService mockModelService;

	public void setMockModelService(IMockModelService mockModelService) {
		this.mockModelService = mockModelService;
	}
	
}
