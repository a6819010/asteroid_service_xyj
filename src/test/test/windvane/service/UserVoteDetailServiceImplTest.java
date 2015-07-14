package test.windvane.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youguu.asteroid.base.ContextLoader;
import com.youguu.asteroid.windvane.pojo.UserVoteDetail;
import com.youguu.asteroid.windvane.service.IUserVoteDetailService;
import com.youguu.asteroid.windvane.service.impl.UserVoteDetailServiceImpl;

public class UserVoteDetailServiceImplTest {
	
	private IUserVoteDetailService service;
	private ApplicationContext ctx;
	
	@Before
	public void init(){
		ctx = new AnnotationConfigApplicationContext(ContextLoader.class);
		service = ctx.getBean(UserVoteDetailServiceImpl.class);
	}

	@Test
	public void testAddUserVoteDetail() {
		service.addUserVoteDetail(new UserVoteDetail(2,new Date(),"",1));
	}

	@Test
	public void testUpdateUserVoteDetail() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteUserVoteDetail() {
		service.deleteUserVoteDetail("20140102", 1);
	}

	@Test
	public void testSelectUserVoteDetail() {
		service.getUserVoteDetail("20140102", 1);
	}

	@Test
	public void testFindAllUserVoteDetail() {
		//System.out.println(service.findAllUserVoteDetail().size());
	}

}
