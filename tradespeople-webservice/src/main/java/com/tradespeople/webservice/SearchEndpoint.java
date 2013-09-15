package com.tradespeople.webservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tradespeople.common.api.BaseController;
import com.tradespeople.json.request.SearchRequest;
import com.tradespeople.json.response.SearchResponse;

@Controller
@RequestMapping("/searchApi")
public class SearchEndpoint extends BaseController {

	@RequestMapping("/shop")
	@ResponseBody
	public SearchResponse search(@RequestBody SearchRequest searchRequest){
		return null;
	}
	
}
