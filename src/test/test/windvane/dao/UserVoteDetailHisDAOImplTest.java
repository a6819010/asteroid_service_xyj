package test.windvane.dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youguu.asteroid.base.ContextLoader;
import com.youguu.asteroid.windvane.dao.IUserVoteDetailHisDAO;
import com.youguu.asteroid.windvane.dao.impl.UserVoteDetailHisDAOImpl;
import com.youguu.asteroid.windvane.pojo.UserVoteDetailHis;

public class UserVoteDetailHisDAOImplTest {

	protected static ApplicationContext ctx = new AnnotationConfigApplicationContext(ContextLoader.class);
	IUserVoteDetailHisDAO userVoteDetailHisDAO = ctx.getBean("userVoteDetailHisDAO",UserVoteDetailHisDAOImpl.class);
	
	@Test
	public void testInsertUserVoteDetailHis() {
		userVoteDetailHisDAO.insert(new UserVoteDetailHis(1,new Date(),"",1));
	}

	@Test
	public void testUpdateUserVoteDetailHis() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteUserVoteDetailHis() {
		fail("Not yet implemented");
	}

	@Test
	public void testBatchInsertListOfUserVoteDetailHis() {
		List<UserVoteDetailHis> list = new ArrayList<UserVoteDetailHis>();
		UserVoteDetailHis u1 = new UserVoteDetailHis(2,new Date(),"",1);
		UserVoteDetailHis u2 = new UserVoteDetailHis(3,new Date(),"",2);
		list.add(u1);
		list.add(u2);
		userVoteDetailHisDAO.batchInsert(list);
	}

	@Test
	public void testSelectUserVoteDetailHis() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAllUserVoteDetailHis() {
		System.out.println(userVoteDetailHisDAO.findAllUserVoteDetailHis(null, 1, 10).getList().size());
	}

}
