package com.tradespeople.webservice;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tradespeople.common.api.BaseController;
import com.tradespeople.common.exception.TradesPeopleServiceException;
import com.tradespeople.json.request.MockModelRequest;
import com.tradespeople.json.response.MockModelResponse;
import com.tradespeople.model.MockModel;
import com.tradespeople.model.builder.MockModelBuilder;
import com.tradespeople.service.IMockModelService;
import com.tradespeople.utils.ApiConstants;


@Controller
@RequestMapping("/mockEndPoint")
public class MockModelEndpoint extends BaseController implements IMockModelEndPoint {

	@Autowired
	private transient IMockModelService mockModelService;
	
	@RequestMapping("/listMockModels")
	@ResponseBody
	public List<MockModel> listMockModels(){
		try {
			return mockModelService.getMockModels();
		} catch (TradesPeopleServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(@Valid @RequestBody MockModelRequest request) {
		
    }
	
	@RequestMapping("/detailMockModel/{mockModelId}")
	@ResponseBody
	public MockModelResponse detailMockModel(@PathVariable Long mockModelId){
		try {
			for (MockModel model : mockModelService.getMockModels()) {
				if (model.getId().equals(mockModelId)) {
					return new MockModelBuilder().buildResponse(model);
				}
			}
		} catch (TradesPeopleServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
