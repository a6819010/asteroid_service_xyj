package test.tools.service.impl;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youguu.asteroid.base.ContextLoader;
import com.youguu.asteroid.tool.service.ForeignCurrencyService;
import com.youguu.asteroid.tool.service.impl.ForeignCurrencyServiceImpl;

public class ToolForeignCurrencyServiceImplTest {
	ApplicationContext ac = new AnnotationConfigApplicationContext(
			ContextLoader.class);

	@Test
	public void testInit() {
		ForeignCurrencyService service= ac.getBean("foreignCurrencyService",ForeignCurrencyServiceImpl.class);
		System.out.println(service);
		service.init("CNY,USD,EUR,GBP,HKD,JPY,CAD,AUD,SGD,NZD,KRW,MOP,PHP,THB,CHF,RUB,NOK,SEK,DKK");
	}
}
