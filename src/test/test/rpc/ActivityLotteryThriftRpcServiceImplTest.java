package test.rpc;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.youguu.asteroid.rpc.client.AsteroidRPCClientFactory;
import com.youguu.asteroid.rpc.client.activity.IActivityLotteryRPCService;

public class ActivityLotteryThriftRpcServiceImplTest {
	
	private IActivityLotteryRPCService service;
	
	@Before
	public void init(){
		service = AsteroidRPCClientFactory.getActivityLotteryRPCService();
	}

	@Test
	public void testFindUserAwardInfo() {
		Map<String, Object> map = service.findUserAwardInfo(206655);
		System.out.println(map);
	}

	@Test
	public void testFindUserAwardRecord() {
		Map<String, Object> map = service.findUserAwardRecord(206655);
		System.out.println(map);
	}

	@Test
	public void testClickLottery() {
		Map<String, Object> map = service.clickLottery(206655);
		System.out.println(map);
	}

	@Test
	public void testGetAward() {
		Map<String, Object> map = service.getAward(1, "18600151568", 206655);
		System.out.println(map);
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
	public void testComparisonData() {
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

}
