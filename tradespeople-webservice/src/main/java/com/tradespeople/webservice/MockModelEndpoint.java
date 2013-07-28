package com.tradespeople.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tradespeople.json.response.MockModelResponse;
import com.tradespeople.model.MockModel;
import com.tradespeople.model.builder.MockModelBuilder;
import com.tradespeople.service.IMockModelService;
import com.tradespeople.utils.ApiConstants;


@Controller
@RequestMapping("/mockEndPoint")
public class MockModelEndpoint implements IMockModelEndPoint {

	@Autowired
	private transient IMockModelService mockModelService;
	
	@RequestMapping("/listMockModels")
	@ResponseBody
	public List<MockModel> listMockModels(){
		return mockModelService.getMockModels();
	}
	
	@RequestMapping("/detailMockModel/{mockModelId}")
	@ResponseBody
	public MockModelResponse detailMockModel(@PathVariable Long mockModelId){
		for (MockModel model : mockModelService.getMockModels()) {
			if (model.getId().equals(mockModelId)) {
				return new MockModelBuilder().buildResponse(model);
			}
		}
		MockModelResponse response =new MockModelResponse();
		response.setErrorCode(ApiConstants.ResponseErrorCode.NotSupportedParameter);
		response.setErrorMessage("NotSupportedParameter");
		return response;
	}

	public void setMockModelService(IMockModelService mockModelService) {
		this.mockModelService = mockModelService;
	}
	
}
