package com.youguu.asteroid.tool.service;

import java.util.HashMap;
import java.util.List;

import com.youguu.asteroid.tool.pojo.LendingRate;
import com.youguu.core.util.PageHolder;

public interface LendingRateService {

	int save(LendingRate r);

	int update(LendingRate r);

	int delete(int id);

	LendingRate get(int id);

	public PageHolder<LendingRate> queryLendingRateList(
			HashMap<String, Object> hm, int pageIndex, int pageSize);
	
	List<LendingRate> findAll();
}
