package com.youguu.asteroid.tool.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.youguu.asteroid.tool.dao.ForeignCurrencyDAO;
import com.youguu.asteroid.tool.pojo.ForeignCurrency;
import com.youguu.asteroid.tool.service.ForeignCurrencyService;
import com.youguu.core.util.PageHolder;
@Service("foreignCurrencyService")
public class ForeignCurrencyServiceImpl implements ForeignCurrencyService {

	@Resource
	private ForeignCurrencyDAO foreignCurrencyDAO;

	@Override
	public int save(ForeignCurrency r) {
		
		return foreignCurrencyDAO.insert(r);
	}

	@Override
	public int update(ForeignCurrency r) {
		
		return foreignCurrencyDAO.update(r);
	}

	@Override
	public int delete(int id) {
		
		return foreignCurrencyDAO.delete(id);
	}

	@Override
	public ForeignCurrency get(int id) {
		
		return foreignCurrencyDAO.get(id);
	}

	@Override
	public PageHolder<ForeignCurrency> queryForeignCurrencyList(
			HashMap<String, Object> hm, int pageIndex, int pageSize) {
		
		return foreignCurrencyDAO.pagedQuery("findByParams", hm, pageIndex, pageSize);
	}

	@Override
	public List<ForeignCurrency> findAll() {
		return foreignCurrencyDAO.getAll();
	}

	@Override
	public int init(String currencyCode) {
		try {
			if(null==currencyCode || "".equals(currencyCode)){
				currencyCode = "CNY,USD,EUR,GBP,HKD,JPY,CAD,AUD,SGD,NZD,KRW,MOP,PHP,THB,CHF,RUB,NOK,SEK,DKK";
//				currencyCode = "CNY,USD,EUR";
			}
			
			String[] input = currencyCode.split(",");
			
			String[] reverse = new String[input.length];
			
			for(int m = input.length-1 ; m >= 0 ; m --){
				reverse[input.length-(m+1)] = input[m];
			}
			
			for (int i = 0; i < input.length; i++) {
				String tempStr = input[i].toString();
				for (int j = 0; j < reverse.length; j++) {
					if (tempStr.equals(reverse[j].toString())) {
						continue;
					}
					System.out.println(tempStr +","+ reverse[j]);
					ForeignCurrency fc = new ForeignCurrency();
					fc.setBeforeMoneyCode(tempStr);
					fc.setBeforeMoneyName(ForeignEnum.getName(tempStr));
					fc.setAfterMoneyCode(reverse[j]);
					fc.setAfterMoneyName(ForeignEnum.getName(reverse[j]));
					save(fc);
				}
			}
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
