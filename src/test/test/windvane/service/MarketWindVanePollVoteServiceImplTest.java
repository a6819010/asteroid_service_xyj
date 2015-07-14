package test.windvane.service;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youguu.asteroid.base.ContextLoader;
import com.youguu.asteroid.windvane.pojo.MarketWindVanePollVote;
import com.youguu.asteroid.windvane.service.IMarketWindVanePollVoteService;
import com.youguu.asteroid.windvane.service.impl.MarketWindVanePollVoteServiceImpl;

public class MarketWindVanePollVoteServiceImplTest {

	private IMarketWindVanePollVoteService service;
	private ApplicationContext ctx;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	@Before
	public void init(){
		ctx = new AnnotationConfigApplicationContext(ContextLoader.class);
		service = ctx.getBean(MarketWindVanePollVoteServiceImpl.class);
	}
	
	@Test
	public void testAddMarketWindVanePollVote() {
		service.addMarketWindVanePollVote(new MarketWindVanePollVote("2014-12-04",1,1,1,1));
	}
	
	@Test
	public void testUpdateMarketWindVanePollVote() throws Exception {
		service.updateMarketWindVanePollVote(new MarketWindVanePollVote(sdf.format(new Date()),3,2,2,2));
	}

	@Test
	public void testDeleteInt() {
		service.deleteMarketWindVanePollVote("2014-12-01");
	}
	
	@Test
	public void testSelectMarketWindVanePollVote() {
		System.out.println(service.getMarketWindVanePollVote("2014-12-01"));
	}
	
	@Test
	public void testFindAllMarketWindVanePollVote() {
		System.out.println(service.findAllMarketWindVanePollVote(null, 1, 10).getList().size());
	}

}
