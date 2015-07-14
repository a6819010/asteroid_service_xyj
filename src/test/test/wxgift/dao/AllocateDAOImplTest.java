package test.wxgift.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youguu.asteroid.base.ContextLoader;
import com.youguu.asteroid.wxgift.dao.AllocateDAO;

public class AllocateDAOImplTest {
	
	AllocateDAO dao;
	@Before
	public void init(){
		ApplicationContext cxt = new AnnotationConfigApplicationContext(ContextLoader.class);
		dao = cxt.getBean(AllocateDAO.class);
	}
	
	@Test
	public void testGetNextAllocate() {
		System.out.println(dao.getNextAllocate());
	}

	@Test
	public void testUpdateAllocateStatus() {
		System.out.println(dao.sucAllocateStatus(2,"1234345"));
	}

}
