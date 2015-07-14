package com.youguu.asteroid.tool.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.youguu.asteroid.tool.dao.BenchmarkRateDAO;
import com.youguu.asteroid.tool.pojo.BenchmarkRate;
import com.youguu.asteroid.tool.service.BenchmarkRateService;
import com.youguu.core.util.PageHolder;

@Service("benchmarkRateService")
public class BenchmarkRateServiceImpl implements BenchmarkRateService {

	@Resource
	private BenchmarkRateDAO benchmarkRateDAO;

	@Override
	public int save(BenchmarkRate r) {
		
		return benchmarkRateDAO.insert(r);
	}

	@Override
	public int update(BenchmarkRate r) {
		
		return benchmarkRateDAO.update(r);
	}

	@Override
	public int delete(int id) {
		
		return benchmarkRateDAO.delete(id);
	}

	@Override
	public BenchmarkRate get(int id) {
		
		return benchmarkRateDAO.get(id);
	}

	@Override
	public PageHolder<BenchmarkRate> queryBenchmarkRateList(
			HashMap<String, Object> hm, int pageIndex, int pageSize) {
		
		return benchmarkRateDAO.pagedQuery("findByParams", hm, pageIndex, pageSize);
	}

	@Override
	public List<BenchmarkRate> findAll() {
		return benchmarkRateDAO.getAll();
	}
	
}
