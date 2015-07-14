package test.fund.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youguu.asteroid.base.ContextLoader;
import com.youguu.asteroid.fund.pojo.FundConvert;
import com.youguu.asteroid.fund.service.FundConvertService;

public class FundServiceImplTest {
	FundConvertService fcs;
	
	@Before
	public void init(){
		@SuppressWarnings("resource")
		ApplicationContext cxt = new AnnotationConfigApplicationContext(ContextLoader.class);
		fcs = cxt.getBean(FundConvertService.class);
	}
	@Test
	public void findFund(){
		List<FundConvert> list = fcs.queryFund(null, null, null, null, null,1,1,0,0);
		for(FundConvert fc : list){
			System.out.println(fc.getAfundCode()+":"+fc.getBfundCode()+":ID:"+fc.getId());
		}
	}
	
	@Test
	public void insert(){
		FundConvert fund = new FundConvert();
		fund.setAfundCode("1");
		fund.setBfundCode("2");
		fund.setConvertType(0);
		fund.setAconvertRate(0.002f);
		fund.setBconvertRate(0.003f);
		fund.setAbRatio(0.001f);
		fund.setStatus(0);
		
		fcs.insertFund(fund);
		
	}
	@Test
	public void update(){
		FundConvert fund = new FundConvert();
		fund.setAfundCode("2");
		fund.setBfundCode("3");
		fund.setConvertType(0);
		fund.setAconvertRate(0.002f);
		fund.setBconvertRate(0.003f);
		fund.setAbRatio(0.001f);
		fund.setStatus(1);
		fund.setId(1);
		
		this.fcs.updateFund(fund);
	}
	
	@Test
	public void delete(){
		this.fcs.deleteFund(7);
	}
	
	@Test
	public void findById(){
		FundConvert fc = this.fcs.findById(15);
		System.out.println(fc.getAfundCode());
	}
}
