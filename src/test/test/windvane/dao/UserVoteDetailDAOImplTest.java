package test.windvane.dao;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youguu.asteroid.base.ContextLoader;
import com.youguu.asteroid.windvane.dao.IUserVoteDetailDAO;
import com.youguu.asteroid.windvane.dao.impl.UserVoteDetailDAOImpl;
import com.youguu.asteroid.windvane.pojo.UserVoteDetail;

public class UserVoteDetailDAOImplTest {
	
	protected static ApplicationContext ctx = new AnnotationConfigApplicationContext(ContextLoader.class);
	IUserVoteDetailDAO userVoteDetailDAO = ctx.getBean("userVoteDetailDAO",UserVoteDetailDAOImpl.class);

	@Test
	public void testInsertUserVoteDetail() {
		userVoteDetailDAO.insert(new UserVoteDetail(1,new Date(),"",1));
	}

	@Test
	public void testUpdateUserVoteDetail() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteUserVoteDetail() {
		fail("Not yet implemented");
	}

	@Test
	public void testSelectUserVoteDetail() {
		System.out.println(userVoteDetailDAO.selectUserVoteDetail("20141201", 1));
	}

	@Test
	public void testFindAllUserVoteDetail() {
		//System.out.println(userVoteDetailDAO.findAllUserVoteDetail().size());
	}

}
