package test.rpc;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youguu.asteroid.ad.pojo.AdWall;
import com.youguu.asteroid.ad.service.IAdWallService;
import com.youguu.asteroid.ad.service.impl.AdWallServiceImpl;
import com.youguu.asteroid.base.ContextLoader;
import com.youguu.asteroid.rpc.client.AsteroidRPCClientFactory;
import com.youguu.asteroid.rpc.client.ad.IAdWallRPCService;

public class AdWallRPCServiceTest {

	
	private IAdWallRPCService service;
	@Before
	public void init(){
		service = AsteroidRPCClientFactory.getAdWallRPCService();
	}

	@Test
	public void testAddAdWall() {
		AdWall ad = new AdWall();
		ad.setTitle("haloas");
		ad.setForwardUrl("http://news.sina.com.cn/c/2014-06-09/183930324432.shtml");
		ad.setBeginDate(new Date());
		ad.setEndDate(new Date());
		ad.setAdImage("http://www.youguu.com/mncg/");
		ad.setPositionType("2402");
		ad.setContentType("2501");
		ad.setContent("");
		ad.setCreateTime(new Date());
		ad.setRank(2);
		service.addAdWall(ad);
	}

	@Test
	public void testDeleteAdWall() {
		service.deleteAdWall(24);
	}

	@Test
	public void testUpdateAdWall() {
		AdWall ad = service.getAdWall(24);
		ad.setContent("哈尔滨电信4G");
		service.updateAdWall(ad);
	}

	@Test
	public void testGetAdWall() {
		AdWall adWall = service.getAdWall(3);
		System.out.println(adWall);
	}

	@Test
	public void testQueryAdWallList() {
		fail("Not yet implemented");
	}

	@Test
	public void testFlushRedis() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryAdWallFromRedis() {
		List<AdWall> list = service.queryAdWallFromRedis("2402");
		for(AdWall ad : list){
			System.out.println(ad);
		}
	}

}
