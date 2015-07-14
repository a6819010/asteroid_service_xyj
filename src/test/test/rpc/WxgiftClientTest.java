package test.rpc;

import org.junit.Test;

import com.youguu.asteroid.rpc.client.AsteroidRPCClientFactory;

public class WxgiftClientTest {
	
	@Test
	public void queryStatus(){
		System.out.println(AsteroidRPCClientFactory.getWxgiftRPCService().queryStatus("1", "2"));
	}
	
	@Test
	public void open(){
		System.out.println(AsteroidRPCClientFactory.getWxgiftRPCService().open("1", "3"));
	}
}
