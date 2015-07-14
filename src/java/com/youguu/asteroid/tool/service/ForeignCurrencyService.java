package com.youguu.asteroid.tool.service;

import java.util.HashMap;
import java.util.List;

import com.youguu.asteroid.tool.pojo.ForeignCurrency;
import com.youguu.core.util.PageHolder;

public interface ForeignCurrencyService {

	int save(ForeignCurrency r);

	int update(ForeignCurrency r);

	int delete(int id);

	ForeignCurrency get(int id);

	public PageHolder<ForeignCurrency> queryForeignCurrencyList(
			HashMap<String, Object> hm, int pageIndex, int pageSize);

	List<ForeignCurrency> findAll();
	
	int init(String currencyCode);
}
