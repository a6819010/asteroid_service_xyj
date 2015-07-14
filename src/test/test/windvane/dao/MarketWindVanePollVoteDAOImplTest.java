package test.windvane.dao;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youguu.asteroid.base.ContextLoader;
import com.youguu.asteroid.windvane.dao.IMarketWindVanePollVoteDAO;
import com.youguu.asteroid.windvane.dao.impl.MarketWindVanePollVoteDAOImpl;
import com.youguu.asteroid.windvane.pojo.MarketWindVanePollVote;

public class MarketWindVanePollVoteDAOImplTest {
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	protected static ApplicationContext ctx = new AnnotationConfigApplicationContext(ContextLoader.class);
	IMarketWindVanePollVoteDAO marketWindVanePollVoteDAO = ctx.getBean("marketWindVanePollVoteDAO",MarketWindVanePollVoteDAOImpl.class);

	@Test
	public void testInsertMarketWindVanePollVote() throws Exception{
		marketWindVanePollVoteDAO.insert(new MarketWindVanePollVote(sdf.format(new Date()),1,1,1,1));
	}

	@Test
	public void testUpdateMarketWindVanePollVote() throws Exception {
		marketWindVanePollVoteDAO.update(new MarketWindVanePollVote("",3,2,2,2));
	}

	@Test
	public void testDeleteInt() {
		marketWindVanePollVoteDAO.delete("2014-12-01");
	}
	
	@Test
	public void testSelectMarketWindVanePollVote() {
		System.out.println(marketWindVanePollVoteDAO.selectMarketWindVanePollVote("2014-12-01").getDate());
	}
	
	@Test
	public void testFindAllMarketWindVanePollVote() {
		System.out.println(marketWindVanePollVoteDAO.findAllMarketWindVanePollVote(null, 1, 10).getList().size());
	}

}
