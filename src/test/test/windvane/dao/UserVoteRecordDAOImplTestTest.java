package test.windvane.dao;

import static org.junit.Assert.*;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youguu.asteroid.base.ContextLoader;
import com.youguu.asteroid.windvane.dao.IUserVoteRecordDAO;
import com.youguu.asteroid.windvane.dao.impl.UserVoteRecordDAOImpl;
import com.youguu.asteroid.windvane.pojo.UserVoteRecord;

public class UserVoteRecordDAOImplTestTest {
	
	protected static ApplicationContext ctx = new AnnotationConfigApplicationContext(ContextLoader.class);
	IUserVoteRecordDAO userVoteRecordDAO = ctx.getBean("userVoteRecordDAO",UserVoteRecordDAOImpl.class);

	@Test
	public void testTestInsertUserVoteRecord() {
		userVoteRecordDAO.insert(new UserVoteRecord(1,1,1,1,1));
	}

	@Test
	public void testTestUpdateUserVoteRecord() {
		fail("Not yet implemented");
	}

	@Test
	public void testTestDeleteInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testTestBatchUpdateListOfUserVoteRecord() {
		fail("Not yet implemented");
	}

	@Test
	public void testTestSelectUserVoteRecord() {
		fail("Not yet implemented");
	}

	@Test
	public void testTestFindAllUserVoteRecord() {
		userVoteRecordDAO.findAllUserVoteRecord(null, 1, 10);
	}

}
