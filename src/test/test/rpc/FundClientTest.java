package test.rpc;

import java.util.List;

import org.junit.Test;

import com.youguu.asteroid.fund.pojo.FundConvert;
import com.youguu.asteroid.fund.pojo.FundDiv;
import com.youguu.asteroid.rpc.client.AsteroidRPCClientFactory;
import com.youguu.asteroid.rpc.client.fund.IFundRPCService;

public class FundClientTest {
	private IFundRPCService fundR = AsteroidRPCClientFactory.getFunRPCService();
	
	@Test
	public void queryFundC(){
		List<FundConvert> list = fundR.queryFundConvert(null, null, null, null, null, 0, 0, 0, 0);
		for(FundConvert fc : list){
			System.out.println(fc.getAfundCode()+"==>"+fc.getBfundCode());
		}
	}
	
	@Test
	public void  insertC(){
		FundConvert fund = new FundConvert();
		fund.setAfundCode("1");
		fund.setBfundCode("2");
		fund.setConvertType(0);
		fund.setAconvertRate(0.002f);
		fund.setBconvertRate(0.003f);
		fund.setAbRatio(0.001f);
		fund.setStatus(0);
		fundR.insertFundConvert(fund);
	}
	
	@Test
	public void updateC(){
		FundConvert fund = new FundConvert();
		fund.setAfundCode("150171");
		fund.setBfundCode("150172");
		fund.setConvertType(0);
		fund.setAconvertRate(0.002f);
		fund.setBconvertRate(0.003f);
		fund.setStatus(1);
		fund.setId(15);
		fundR.updateFundConvert(fund);
	}
	@Test
	public void deleteC(){
		fundR.deleteFundConvert(8);
	}
	
	@Test
	public void queryFundD(){
		List<FundDiv> list = fundR.queryFundDiv(null, null, null, null, null,0,0,0,0);
		for(FundDiv fc : list){
			System.out.println(fc.getFundCode()+":ID:"+fc.getId());
		}
	} 
	
	@Test
	public void insertD(){
		FundDiv fund = new FundDiv();
		fund.setFundCode("1");
		fund.setDivType(0);
		fund.setCashBT(0.003f);
		fund.setCashAT(0.006f);
		fund.setStatus(0);
		fundR.insertFundDiv(fund);
	}
	@Test
	public void updateD(){
		FundDiv fund = new FundDiv();
		fund.setFundCode("545");
		fund.setDivType(1);
		fund.setCashBT(0.003f);
		fund.setCashAT(0.006f);
		fund.setStatus(1);
		fund.setId(5);
		
		this.fundR.updateFundDiv(fund);
	}
	
	@Test
	public void deleteD(){
		this.fundR.deleteFundDiv(5);
	}
	
	@Test
	public void findCById(){
		FundConvert fc = this.fundR.findCById(15);
		System.out.println(fc.getAfundCode());
	}
	
	@Test
	public void findDById(){
		FundDiv fd = this.fundR.findDById(3);
		System.out.println(fd.getFundCode());
	}
}
