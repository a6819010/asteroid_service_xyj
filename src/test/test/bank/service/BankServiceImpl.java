package test.bank.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Produces;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youguu.asteroid.bank.pojo.Bank;
import com.youguu.asteroid.bank.pojo.BankGroup;
import com.youguu.asteroid.bank.pojo.BankGroupType;
import com.youguu.asteroid.bank.service.IBankGroupService;
import com.youguu.asteroid.bank.service.IBankService;
import com.youguu.asteroid.base.ContextLoader;

public class BankServiceImpl {
	
	IBankGroupService bankGroupService;
	IBankService bankS;
	
	@Before
	public void init(){
		@SuppressWarnings("resource")
		ApplicationContext cxt = new AnnotationConfigApplicationContext(ContextLoader.class);
		bankGroupService = cxt.getBean(IBankGroupService.class);
		bankS = cxt.getBean(IBankService.class);
	}
	

	/**
	 * 添加银行分组信息
	 * @param map 需要添加的银行分组list
	 * @return
	 */
	@Test
	public void addBankGroup(){
		List<BankGroup> list = new ArrayList<BankGroup>();
		BankGroup bankGroup = new BankGroup();
		bankGroup.setBankId(1);
		bankGroup.setGroupType(0);
		BankGroup bankGroup2 = new BankGroup();
		bankGroup2.setBankId(10);
		bankGroup2.setGroupType(10);
		list.add(bankGroup);
		list.add(bankGroup2);
		System.out.println(bankGroupService.addBankGroup(list));
	}
	
	/**
	 * 通过ID删除银行分组信息
	 * @param id
	 * @return
	 */
	@Test
	public void removeBankGroupById(){
		bankGroupService.removeBankGroupById(6);
	}
	
	/**
	 * 通过id修改银行分组信息
	 * @return
	 */
	@Test
	public void modifyBankGroupById(){
		BankGroup bankGroup = new BankGroup();
		bankGroup.setId(10);
		bankGroup.setBankId(120);
		bankGroup.setGroupType(1);
		bankGroupService.modifyBankGroupById(10,bankGroup);
	}
	
	/**
	 * 通过type查询银行分组信息
	 * @return
	 */
	@Test
	public void getBankGroupByType(){
		List<Bank> list = bankGroupService.getBankGroupByType(BankGroupType.YOUGUU_PAY.getType());
		for(int i = 0 ; i < list.size() ; i ++){
			System.out.println(list.get(i).getBankName());
		}
	}
	
	/**
	 * 获取所有银行分组信息
	 * @return
	 */
	@Test
	public void getBankGroupList(){
		List<BankGroup> list = bankGroupService.getBankGroupList(-1,"");
		for(int i = 0 ; i < list.size() ; i ++){
			System.out.println(list.get(i).getBankId());
		}
	}
	
	/**
	 * 通过银行ID删除 bankGroup信息
	 * @param bankId
	 * @return
	 */
	@Test
	public void removeBankGroupByBankId(){
		
		bankGroupService.removeBankGroupById(1);
		
	}
	
	
	
	
	/**
	 * 增加银行信息
	 * @param bank
	 * @return int 1:添加成功 ,0添加失败
	 */
	@Produces("text/html;charset=UTF-8")
	@Test
	public void addBank(){
		
			Bank bank = new Bank();
			bank.setBankName("中國民生銀行");
			bank.setBankLogo("");
			bank.setBankNameAbbr("SFSF");
			bankS.addBank(bank);
	
		
		
	}
	
	/**
	 * 通过银行ID删除银行信息
	 * @param id
	 * @return int
	 */
	@Test
	public void removeBankById(){
		bankS.removeBankById(1);
		
	}
	
	/**
	 * 通过银行id修改银行信息
	 * @param bank
	 * @return int
	 */
	@Test
	public void modifyBankById(){
		Bank bank = new Bank();
		bank.setBankName("中国工商银行");
		bank.setBankNameAbbr("ICBC");
		bank.setBankLogo("SDDDD");
		bankS.modifyBankById(2, bank);
	}
	
	/**
	 * 通过银行ID查找银行信息
	 * @param id
	 * @return
	 */
	@Test
	public void getBankById(){
		System.out.println(bankS.getBankById(2).getBankName());
	}
	
	/**
	 * 获取银行信息列表
	 * @return
	 */
	@Test
	public void getBankList(){
		List<Bank> list = bankS.getBankList();
		for(int i =0;i< list.size();i++){
			System.out.println(list.get(i).getId()+":"+list.get(i).getBankName());
		}
	}
	@Test
	public void getBankGroupById(){
		System.out.println(bankGroupService.getBankGroupById(1).getBankId());
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
		List<Bank> list = bankS.getBankListById(ids);
		for(Bank bank : list){
			System.out.println(bank.getId()+":"+bank.getBankName());
		}
	}
	@Test
	public void getBankByTypeBankCode(){
		bankS.findBankByTypeBankCode(BankGroupType.YB_CODE.getType(),"3221");
	}
	
	@Test
	public void findBankByParams(){
		bankS.findBankByParams(0, "工商银行", "");
	}
	
}
