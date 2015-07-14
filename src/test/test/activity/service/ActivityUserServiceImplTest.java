package test.activity.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youguu.asteroid.activity.pojo.ActivityUser;
import com.youguu.asteroid.activity.service.IActivityUserService;
import com.youguu.asteroid.activity.service.impl.ActivityUserServiceImpl;
import com.youguu.asteroid.base.ContextLoader;

public class ActivityUserServiceImplTest {
	
	private IActivityUserService service;
	private ApplicationContext ctx;
	
	@Before
	public void init(){
		ctx = new AnnotationConfigApplicationContext(ContextLoader.class);
		service = ctx.getBean(ActivityUserServiceImpl.class);
	}

	@Test
	public void testFindAllActivityUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testBatchInsert() {
		List<ActivityUser> list = new ArrayList<ActivityUser>();
		ActivityUser au1 = new ActivityUser(1,"1",1,null);
		ActivityUser au2 = new ActivityUser(2,"2",1,null);
		list.add(au1);
		list.add(au2);
		service.batchInsert(list);
	}

	@Test
	public void testFindListActivityUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateStatus() {
		fail("Not yet implemented");
	}

}
