package test.fund.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youguu.asteroid.base.ContextLoader;
import com.youguu.asteroid.fund.pojo.FundDiv;
import com.youguu.asteroid.fund.service.FundDivService;

public class FundServiceImplTest2 {
	FundDivService fcs;
	
	@Before
	public void init(){
		@SuppressWarnings("resource")
		ApplicationContext cxt = new AnnotationConfigApplicationContext(ContextLoader.class);
		fcs = cxt.getBean(FundDivService.class);
	}
	@Test
	public void findFund(){
		List<FundDiv> list = fcs.queryFund( null, "", "", null, null,0,0,0,0);
		for(FundDiv fc : list){
			System.out.println(fc.getFundCode()+":ID:"+fc.getId());
		}
	}
	
	@Test
	public void insert(){
		FundDiv fund = new FundDiv();
		fund.setFundCode("1");
		fund.setDivType(0);
		fund.setCashBT(0.003f);
		fund.setCashAT(0.006f);
		fund.setStatus(0);
		fcs.insertFund(fund);
		
	}
	@Test
	public void update(){
		FundDiv fund = new FundDiv();
		fund.setFundCode("545");
		fund.setDivType(1);
		fund.setCashBT(0.003f);
		fund.setCashAT(0.006f);
		fund.setStatus(1);
		fund.setId(4);
		
		this.fcs.updateFund(fund);
	}
	
	@Test
	public void delete(){
		this.fcs.deleteFund(4);
	}
	@Test
	public void findById(){
		FundDiv fd = this.fcs.findById(3);
		System.out.println(fd.getFundCode());
	}
}
