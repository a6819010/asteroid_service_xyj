package com.youguu.asteroid.sec.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



import com.youguu.asteroid.base.ContextLoader;
import com.youguu.asteroid.sec.pojo.SecAccountAndTrade;

public class SecAccountTradeServiceImplTest {
	
	private SecAccountTradeServiceImpl service;
	
	@Before
	public void init(){
		ApplicationContext appContext =new AnnotationConfigApplicationContext(ContextLoader.class);
		service=appContext.getBean("secAccountTradeService",SecAccountTradeServiceImpl.class);
	}

	@Test
	public void testAdd() {
		SecAccountAndTrade sec=new SecAccountAndTrade();
		sec.setName("德邦证券");
		sec.setSecNo(1);
		sec.setOrders(1);
		sec.setOsType(1);
		sec.setType(SecAccountAndTrade.SEC_TYPE_ACCOUNT);
		//sec.setJsonStr("aaaaaaa");
		sec.setJsonStr("{\"apk\": {\"name\": \"德邦证券开户应用\", \"package\": \"com.zztzt.tebonkh\",\"url\": \"http://download.youguu.com/download/DBSCKH-YOUGUU.apk\",\"version\": \"2\"},\"des\": [ { \"content\": \"德邦证券有限责任公司成立于2003年5月，是经中国证监会批准设立的全国性综合类证券公司。目前公司旗下拥有中州期货有限公司、德邦基金管理有限公司、德邦星睿投资管理有限公司、德邦星盛资本管理有限公司。公司在投资银行、固定收益、资产管理、证券经纪、财富管理、私募及PE基金评价等方面不断创新，为广大客户提供投资、融资等全面、专业的金融服务。\", \"title\": \"公司简介\"},{ \"content\": \"手机极速开户 佣金万分之三起财富玖功 特色投资顾问服务\",\"title\": \"特殊服务\"}],\"banner\": [ {\"img\": \"http://img.youguu.com/gamems/images/image/20141128/20141128103239.png\", \"url\": \"http://test.youguu.com/mobile/wap_lottery/html/?debug=true\" },{\"img\": \"http://img.youguu.com/gamems/images/image/20141231/20141231155731.jpg\", \"url\": \"http://www.baidu.com\" }],\"help\": {\"des\": \"http://www.baidu.com\", \"title\": \"德邦开户指引\" },\"logo\": \"http://www.youguu.com/resource/img/logo/dbzq.png\",\"name\": \"德邦证券\",\"phone\": {\"des\": \"400-8888128\", \"title\": \"德邦证券客服\"}, \"type\": {\"des\": \"我要开户/转户\",\"type\": \"1\" } }");
		int result=service.add(sec);
		System.out.println("插入结果："+result);
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetList() {
		List<SecAccountAndTrade> list=service.getList(1, 1);
		SecAccountAndTrade sec=list.get(0);
		System.out.println(list.size());
		System.out.println(sec.getJsonStr());
	}

	@Test
	public void testGet() {
		SecAccountAndTrade sec=service.get(1);
		System.out.println(sec.toString());
	}

}
