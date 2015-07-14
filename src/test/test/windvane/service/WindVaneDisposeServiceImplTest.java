package test.windvane.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youguu.asteroid.base.ContextLoader;
import com.youguu.asteroid.windvane.service.IWindVaneDisposeService;
import com.youguu.asteroid.windvane.service.impl.WindVaneDisposeServiceImpl;

public class WindVaneDisposeServiceImplTest {
	
	private IWindVaneDisposeService service;
	private ApplicationContext ctx;
	
	@Before
	public void init(){
		ctx = new AnnotationConfigApplicationContext(ContextLoader.class);
		service = ctx.getBean(WindVaneDisposeServiceImpl.class);
	}

	@Test
	public void testFindWindVane() {
		System.out.println(service.findWindVane(1).size());
	}

	@Test
	public void testVote() {
		System.out.println(service.vote(1, 1));
	}

	@Test
	public void testCowThanBear() {
		fail("Not yet implemented");
	}

	@Test
	public void testCloseClear() {
		service.closeClear();
	}

}
