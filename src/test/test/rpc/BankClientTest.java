package test.rpc;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.youguu.asteroid.bank.pojo.Bank;
import com.youguu.asteroid.bank.pojo.BankGroup;
import com.youguu.asteroid.bank.pojo.BankGroupType;
import com.youguu.asteroid.rpc.client.AsteroidRPCClientFactory;

public class BankClientTest{
	
	@Test
	public void addBank() {
		Bank bank = new Bank();
		bank.setBankLogo("LLL");
		bank.setBankName("中国招商银行");
		bank.setBankNameAbbr("LOVE");
		AsteroidRPCClientFactory.getBankRPCService().addBank(bank);
	}

	@Test
	public void removeBankById() {
		AsteroidRPCClientFactory.getBankRPCService().removeBankById(4);
		
	}

	@Test
	public void modifyBankById() {
		int id = 5;
		Bank bank = new Bank();
		bank.setBankLogo("L");
		bank.setBankName("中国邮政储蓄");
		bank.setBankNameAbbr("DFGH");
		AsteroidRPCClientFactory.getBankRPCService().modifyBankById(id, bank);
	}

	@Test
	public void getBankById() {
		
		Bank bank = AsteroidRPCClientFactory.getBankRPCService().getBankById(33);
		
	}

	@Test
	public void getBankList() {
		List<Bank> list = AsteroidRPCClientFactory.getBankRPCService().getBankList();
		for(int i = 0 ; i < list.size();i++){
		}
	}

	@Test
	public void addBankGroup() {
		List<BankGroup> list = new ArrayList<BankGroup>();
		BankGroup bankG = new BankGroup();
		bankG.setGroupType(1);
		bankG.setBankId(50);
		bankG.setBankCode("121");
		list.add(bankG);
		System.out.println(AsteroidRPCClientFactory.getBankRPCService().addBankGroup(list));
	}

	@Test
	public void removeBankGroupById() {
		AsteroidRPCClientFactory.getBankRPCService().removeBankGroupById(8);
	}

	@Test
	public void modifyBankGroupById() {
		BankGroup bankG = new BankGroup();
		bankG.setGroupType(9);
		bankG.setBankId(3);
		System.out.println(AsteroidRPCClientFactory.getBankRPCService().modifyBankGroupById(1, bankG));
		
	}

	@Test
	public void getBankGroupByType() {
		List<Bank> list = AsteroidRPCClientFactory.getBankRPCService().getBankGroupByType(1);
		for(int i = 0 ; i < list.size();i++){
			System.out.println(list.get(i).getBankName());
		}
	}

	@Test
	public void getBankGroupList() {
		List<BankGroup> list = AsteroidRPCClientFactory.getBankRPCService().getBankGroupList(1,"");
		for(int i = 0 ; i < list.size();i++){
			System.out.println(list.get(i).getBankId());
		}
	}
	
	@Test
	public void getBankGroupById(){
		System.out.println(AsteroidRPCClientFactory.getBankRPCService().getBankGroupById(1).getBankId());
	}
	@Test
	public void getBankListById(){
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		ids.add(30);
		ids.add(31);
		ids.add(32);
		ids.add(33);
		ids.add(50);
		List<Bank> list = AsteroidRPCClientFactory.getBankRPCService().getBankListById(ids);
		for(Bank bank : list){
			System.out.println(bank.getId()+":"+bank.getBankName());
		}
	}
	@Test
	public void findBankByGroup(){
		AsteroidRPCClientFactory.getBankRPCService().findBankByTypeBankCode(1, "1");
		System.out.println("aa");
	}
	
	@Test
	public void findBankByParams(){
		AsteroidRPCClientFactory.getBankRPCService().findBankByParams(0, "工商银行", "");
	}
	
}
