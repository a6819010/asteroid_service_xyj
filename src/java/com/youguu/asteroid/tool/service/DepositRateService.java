package com.youguu.asteroid.tool.service;

import java.util.HashMap;
import java.util.List;

import com.youguu.asteroid.tool.pojo.DepositRate;
import com.youguu.core.util.PageHolder;

public interface DepositRateService {

	int save(DepositRate r);

	int update(DepositRate r);

	int delete(int id);

	DepositRate get(int id);

	public PageHolder<DepositRate> queryDepositRateList(
			HashMap<String, Object> hm, int pageIndex, int pageSize);
	
	List<DepositRate> findAll();
}
