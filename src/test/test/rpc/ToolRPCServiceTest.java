package test.rpc;

import java.util.List;

import org.junit.Test;

import com.youguu.asteroid.rpc.client.AsteroidRPCClientFactory;
import com.youguu.asteroid.rpc.client.tool.IToolRPCService;
import com.youguu.asteroid.tool.pojo.DepositRate;
import com.youguu.asteroid.tool.pojo.ForeignCurrency;
import com.youguu.core.util.PageHolder;

public class ToolRPCServiceTest {

	private IToolRPCService service = AsteroidRPCClientFactory.getToolRPCService();

	@Test
	public void testInsert(){
		ForeignCurrency r = new ForeignCurrency();
		r.setAfterMoneyCode("1");
		r.setAfterMoneyName("2");
		r.setBeforeMoneyCode("3");
		r.setBeforeMoneyName("4");
		r.setConvertRate(1.1);
		service.saveForeignCurrency(r);
		

		r.setAfterMoneyCode("1-2");
		r.setAfterMoneyName("2-2");
		r.setBeforeMoneyCode("3-2");
		r.setBeforeMoneyName("4-2");
		r.setConvertRate(2.2);
		service.saveForeignCurrency(r);
	}
	@Test
	public void testUpdate(){
		ForeignCurrency r = service.getForeignCurrency(3863);
		r.setBeforeMoneyName("update..");
		service.updateForeignCurrency(r);
	}
	@Test
	public void testQuery(){
		PageHolder<ForeignCurrency> rs = service.queryForeignCurrencyList(null, 1, 20);
		for (ForeignCurrency foreignCurrency : rs) {
			System.out.println(foreignCurrency.getId());
		}
	}
	@Test
	public void testFindAll(){
		List<DepositRate> rs = service.findAllDepositRate();
		for (DepositRate depositRate : rs) {
			System.out.println(depositRate.getUpdateTime());
		}
	}
	@Test
	public void testDelete(){
		service.deleteForeignCurrency(3863);
	}
}
