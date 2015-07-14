package test.func.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youguu.asteroid.base.ContextLoader;
import com.youguu.asteroid.func.service.IFuncService;

public class IFuncServiceTest {
	
	IFuncService funcService;
	
	@Before
	public void init(){
		@SuppressWarnings("resource")
		ApplicationContext cxt = new AnnotationConfigApplicationContext(ContextLoader.class);
		funcService = cxt.getBean(IFuncService.class);
	}
	@Test
	public void queryFunc(){
		System.out.println(funcService.queryFunc("0610010010101"));
	}
}
