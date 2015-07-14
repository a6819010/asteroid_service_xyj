package com.youguu.asteroid.rpc.server.sec;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.youguu.asteroid.rpc.client.AsteroidRPCClientFactory;
import com.youguu.asteroid.rpc.client.sec.SecRPCService;
import com.youguu.asteroid.sec.pojo.SecAccountAndTrade;

public class SecThriftRpcServiceImplTest {

	private SecRPCService service;
	@Before
	public void init(){
		service=AsteroidRPCClientFactory.getSecRPCService();
	}
	@Test
	public void testGetSecAccountAndTradeList() {
		List<SecAccountAndTrade> list =service.getSecAccountAndTradeList(1, 1);
		System.out.println(list.size());
	}

	@Test
	public void testAddSecAccountRecord() {
		fail("Not yet implemented");
	}

}
