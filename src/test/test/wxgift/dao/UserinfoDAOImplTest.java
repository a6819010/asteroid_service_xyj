package test.wxgift.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youguu.asteroid.base.ContextLoader;
import com.youguu.asteroid.wxgift.dao.UserInfoDAO;

public class UserinfoDAOImplTest {
	UserInfoDAO dao;
	@Before
	public void init(){
		ApplicationContext cxt = new AnnotationConfigApplicationContext(ContextLoader.class);
		dao = cxt.getBean(UserInfoDAO.class);
	}
	
	@Test
	public void saveUserInfo(){
		System.out.println(dao.saveUserInfo("12345667"));
	}
	
	@Test
	public void getUserInfo(){
		System.out.println(dao.getUserInfo("123456671"));
	}
	
	@Test
	public void incOpenNum(){
		System.out.println(dao.incOpenNum("12345667",1));
	}
	
	@Test
	public void updateAllocate(){
		System.out.println(dao.updateAllocate("12345667",1,"1232321"));
	}
	
	
	@Test
	public void updateUserPhone(){
		System.out.println(dao.updateUserPhone("oXwlNuDe8U1-ieZfQZ3jrkJgK5HE","13810436365"));
	}
	
}
