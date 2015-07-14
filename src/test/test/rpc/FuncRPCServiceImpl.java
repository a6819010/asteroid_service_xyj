package test.rpc;

import java.util.List;

import org.junit.Test;

import com.youguu.asteroid.rpc.client.AsteroidRPCClientFactory;
import com.youguu.asteroid.rpc.client.func.IFuncRPCService;

public class FuncRPCServiceImpl {
	private IFuncRPCService funcR = AsteroidRPCClientFactory.getFuncRPCService();
	
	@Test
	public void query(){
		List<String> list = funcR.queryFunc("0610010010101");
		for(String str : list){
			System.out.println(str);
		}
	}
}
