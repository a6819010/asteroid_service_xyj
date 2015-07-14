package test.rpc;


import java.text.ParseException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.youguu.asteroid.rpc.client.AsteroidRPCClientFactory;
import com.youguu.asteroid.rpc.client.tradeday.ITradeDayRPCService;

public class TradeDayRPCServiceImplTest {
	
private ITradeDayRPCService service;
	
	@Before
	public void init(){
		service = AsteroidRPCClientFactory.getTradeDayRPCService();
	}

	@Test
	public void testIsTradeDayString() {
		try {
			System.out.println(service.isTradeDay("2014-11-28"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testIsTradeDayDate() {
		System.out.println(service.isTradeDay(new Date()));
	}

	@Test
	public void testNextTradeDayStringInt() {
		try {
			System.out.println(service.nextTradeDay("2014-11-28", 5));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testNextTradeDayDateInt() {
		try {
			System.out.println(service.nextTradeDay(new Date(), 2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testgetTradeDayNum() {
		System.out.println(service.getTradeDayNum("2015-05-27 20:27:10", "2015-05-28 20:27:10"));
	}

}
