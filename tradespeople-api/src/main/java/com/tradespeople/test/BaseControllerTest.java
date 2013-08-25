package com.tradespeople.test;

import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ="classpath:*Context-test.xml")
@WebAppConfiguration
public class BaseControllerTest {

	private final String  RESPONSE_MEDIA_TYPE_TEXT="application/json;charset=UTF-8";	
	protected final MediaType RESPONSE_MEDIA_TYPE=MediaType.parseMediaType(RESPONSE_MEDIA_TYPE_TEXT); 
	
	@Autowired
	public WebApplicationContext ctx;
	
	public MockMvc mockMvc;
	
	protected void initMock(Object obj){
		MockitoAnnotations.initMocks(obj);
	}
	
	protected void standAloneSetup(Object endpoint){
		this.mockMvc = MockMvcBuilders.standaloneSetup(endpoint).build();
	}

	public WebApplicationContext getCtx() {
		return ctx;
	}

	public void setCtx(WebApplicationContext ctx) {
		this.ctx = ctx;
	}

}
