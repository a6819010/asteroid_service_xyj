package test.wxgift.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSONObject;
import com.youguu.asteroid.base.ContextLoader;
import com.youguu.asteroid.wxgift.service.IWxgiftService;

public class WxgiftServiceImplTest {
	IWxgiftService wxgiftService;
	@Before
	public void init(){
		ApplicationContext cxt = new AnnotationConfigApplicationContext(ContextLoader.class);
		wxgiftService = cxt.getBean(IWxgiftService.class);
	}
	
	@Test
	public void  queryStatus(){
		System.out.println(wxgiftService.queryStatus("1", "2"));
	}
	
	
	@Test
	public void open(){
		System.out.println(wxgiftService.open("1", "2"));
	}
}
