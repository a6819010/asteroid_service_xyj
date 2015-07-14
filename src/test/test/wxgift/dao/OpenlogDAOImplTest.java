package test.wxgift.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youguu.asteroid.base.ContextLoader;
import com.youguu.asteroid.wxgift.dao.OpenlogDAO;

public class OpenlogDAOImplTest {
	OpenlogDAO dao;
	@Before
	public void init(){
		ApplicationContext cxt = new AnnotationConfigApplicationContext(ContextLoader.class);
		dao = cxt.getBean(OpenlogDAO.class);
	}
	
	@Test
	public void getOpenlog(){
		System.out.println(dao.getOpenlog("2", "2"));
	}
	
	@Test
	public void saveOpenlog(){
		dao.saveOpenlog("1", "2", 1);
	}
}
