package test.windvane.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youguu.asteroid.base.ContextLoader;
import com.youguu.asteroid.windvane.pojo.UserVoteRecord;
import com.youguu.asteroid.windvane.service.IUserVoteRecordService;
import com.youguu.asteroid.windvane.service.impl.UserVoteRecordServiceImpl;

public class UserVoteRecordServiceImplTest {
	
	private IUserVoteRecordService service;
	private ApplicationContext ctx;
	
	@Before
	public void init(){
		ctx = new AnnotationConfigApplicationContext(ContextLoader.class);
		service = ctx.getBean(UserVoteRecordServiceImpl.class);
	}

	@Test
	public void testAddUserVoteRecord() {
		service.addUserVoteRecord(new UserVoteRecord(2,2,2,2,2));
	}

	@Test
	public void testUpdateUserVoteRecord() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteUserVoteRecord() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUserVoteRecord() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAllUserVoteRecord() {
		service.findAllUserVoteRecord(null, 1, 10);
	}

}
