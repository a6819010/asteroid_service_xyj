package com.youguu.asteroid.tool.service;

import java.util.HashMap;
import java.util.List;

import com.youguu.asteroid.tool.pojo.BenchmarkRate;
import com.youguu.core.util.PageHolder;

public interface BenchmarkRateService {

	int save(BenchmarkRate r);

	int update(BenchmarkRate r);

	int delete(int id);

	BenchmarkRate get(int id);

	public PageHolder<BenchmarkRate> queryBenchmarkRateList(
			HashMap<String, Object> hm, int pageIndex, int pageSize);
	
	List<BenchmarkRate> findAll();
}
