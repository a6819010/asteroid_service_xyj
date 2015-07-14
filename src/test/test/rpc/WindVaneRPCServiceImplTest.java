package test.rpc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.youguu.asteroid.rpc.client.AsteroidRPCClientFactory;
import com.youguu.asteroid.rpc.client.windvane.IWindVaneRPCService;
import com.youguu.asteroid.windvane.pojo.MarketWindVanePollVote;

public class WindVaneRPCServiceImplTest {
	
	private IWindVaneRPCService service;
	
	@Before
	public void init(){
		service = AsteroidRPCClientFactory.getWindVaneRPCService();
	}

	@Test
	public void testGetMarketWindVanePollVote() {
		System.out.println(service.getMarketWindVanePollVote("20141204"));
	}

	@Test
	public void testUpdateMarketWindVanePollVote() {
		System.out.println(service.updateMarketWindVanePollVote(new MarketWindVanePollVote("20141204",0,0,0,1)));
	}

	@Test
	public void testCloseClear() {
		service.closeClear();
	}

}
