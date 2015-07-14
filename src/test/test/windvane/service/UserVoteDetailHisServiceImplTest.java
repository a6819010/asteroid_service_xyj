package test.windvane.service;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youguu.asteroid.base.ContextLoader;
import com.youguu.asteroid.windvane.pojo.UserVoteDetailHis;
import com.youguu.asteroid.windvane.service.IUserVoteDetailHisService;
import com.youguu.asteroid.windvane.service.impl.UserVoteDetailHisServiceImpl;

public class UserVoteDetailHisServiceImplTest {
	
	private IUserVoteDetailHisService service;
	private ApplicationContext ctx;
	
	@Before
	public void init(){
		ctx = new AnnotationConfigApplicationContext(ContextLoader.class);
		service = ctx.getBean(UserVoteDetailHisServiceImpl.class);
	}

	@Test
	public void testAddUserVoteDetailHis() {
		service.addUserVoteDetailHis(new UserVoteDetailHis(5, new Date(),"", 1));
	}

	@Test
	public void testBatchInsert() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateUserVoteDetailHis() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteUserVoteDetailHis() {
		service.deleteUserVoteDetailHis("20140102", 1);
	}

	@Test
	public void testGetUserVoteDetailHis() {
		service.getUserVoteDetailHis("20140102", 1);
	}

	@Test
	public void testFindAllUserVoteDetailHis() {
		fail("Not yet implemented");
	}

}
