package test.activity.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youguu.asteroid.activity.service.IActivityPrizeService;
import com.youguu.asteroid.activity.service.impl.ActivityPrizeServiceImpl;
import com.youguu.asteroid.base.ContextLoader;

public class ActivityPrizeServiceImplTest {
	
	private IActivityPrizeService service;
	private ApplicationContext ctx;
	
	@Before
	public void init(){
		ctx = new AnnotationConfigApplicationContext(ContextLoader.class);
		service = ctx.getBean(ActivityPrizeServiceImpl.class);
	}

	@Test
	public void testAddActivityPrize() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAllActivityPrize() {
		service.findAllActivityPrize(null, 1, 50);
	}

	@Test
	public void testFindActivityPrizeById() {
		fail("Not yet implemented");
	}

}
