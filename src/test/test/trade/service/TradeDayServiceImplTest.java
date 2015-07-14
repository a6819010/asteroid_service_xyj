package test.trade.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youguu.asteroid.base.ContextLoader;
import com.youguu.asteroid.tradeday.cache.CloseDayCache;
import com.youguu.asteroid.tradeday.service.ITradeDayService;
import com.youguu.asteroid.tradeday.service.impl.TradeDayServiceImpl;

public class TradeDayServiceImplTest {
	private ITradeDayService service;
	private ApplicationContext ctx;
	
	@Before
	public void init(){
		ctx = new AnnotationConfigApplicationContext(ContextLoader.class);
		service = ctx.getBean(TradeDayServiceImpl.class);
	}

	@Test
	public void testGetTradeDayList() {
		System.out.println(service.getTradeDayList().size());
	}

	@Test
	public void testGetMaxTradeDay() {
		System.out.println(service.getMaxTradeDay());
	}

	@Test
	public void testIsTradeDayString() {
		try {
			CloseDayCache.getCache().load();
			CloseDayCache.getCache().resetCacheDate();
			System.out.println(service.isTradeDay("2014-11-28"));
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testIsTradeDayDate() {
		CloseDayCache.getCache().load();
		CloseDayCache.getCache().resetCacheDate();
		System.out.println(service.isTradeDay(new Date()));
	}

	@Test
	public void testNextTradeDayStringInt() {
		try {
			CloseDayCache.getCache().load();
			CloseDayCache.getCache().resetCacheDate();
			System.out.println(service.nextTradeDay("2015-02-27", 2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testNextTradeDayDateInt() {
		try {
			CloseDayCache.getCache().load();
			CloseDayCache.getCache().resetCacheDate();
			System.out.println(service.nextTradeDay(new Date(), 2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQueryTradeDayEnd(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String tradeDay = "2015-05-15";
		String nonTradeDay = "2015-05-16";
		
		try {
			System.out.println("交易日闭合左区间：\t"+service.queryTradeDayEnd(sdf.parse(tradeDay), 5, true));
			System.out.println("交易日非闭合左区间：\t"+service.queryTradeDayEnd(sdf.parse(tradeDay), 5, false));
			
			System.out.println("非交易日闭合左区间：\t"+service.queryTradeDayEnd(sdf.parse(nonTradeDay), 5, true));
			System.out.println("非交易日非闭合左区间：\t"+service.queryTradeDayEnd(sdf.parse(nonTradeDay), 5, false));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testQueryTradeDayInterval(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String tradeDay = "2015-05-15";
		String nonTradeDay = "2015-05-16";
		
		try {
			System.out.println("交易日闭合左区间：\t"+service.queryTradeDayInterval(sdf.parse(tradeDay), 5, true));
			System.out.println("交易日非闭合左区间：\t"+service.queryTradeDayInterval(sdf.parse(tradeDay), 5, false));
			
			System.out.println("非交易日闭合左区间：\t"+service.queryTradeDayInterval(sdf.parse(nonTradeDay), 5, true));
			System.out.println("非交易日非闭合左区间：\t"+service.queryTradeDayInterval(sdf.parse(nonTradeDay), 5, false));
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
