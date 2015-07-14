package test.activity.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youguu.asteroid.activity.service.IActivityUserService;
import com.youguu.asteroid.activity.service.IDisposeActivityService;
import com.youguu.asteroid.activity.service.impl.ActivityUserServiceImpl;
import com.youguu.asteroid.activity.service.impl.DisposeActivityServiceImpl;
import com.youguu.asteroid.base.ContextLoader;

public class DisposeActivityServiceImplTest {
	
	private IDisposeActivityService service;
	private ApplicationContext ctx;
	
	@Before
	public void init(){
		ctx = new AnnotationConfigApplicationContext(ContextLoader.class);
		service = ctx.getBean(DisposeActivityServiceImpl.class);
	}

	@Test
	public void testFindUserAwardInfo() {
		service.findUserAwardInfo(0);
	}

	@Test
	public void testFindUserAwardRecord() {
		fail("Not yet implemented");
	}

	@Test
	public void testClickLottery() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAward() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreatePrizePool() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateBigPrize() {
		fail("Not yet implemented");
	}

	@Test
	public void testComparisonData()throws Exception {
		service.comparisonData();
	}

	@Test
	public void testFindAllActivityUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAllActivityPrize() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAllUserAwardNum() {
		fail("Not yet implemented");
	}

	@Test
	public void testBatchInsertActivityUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddActivityPrize() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAllActivityUserAwardRecord() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelActivityPrize() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateUserAwardRecordStatus() {
		fail("Not yet implemented");
	}

}
