package com.youguu.asteroid.tool.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.youguu.asteroid.tool.dao.LendingRateDAO;
import com.youguu.asteroid.tool.pojo.LendingRate;
import com.youguu.asteroid.tool.service.LendingRateService;
import com.youguu.core.util.PageHolder;

@Service("lendingRateService")
public class LendingRateServiceImpl implements LendingRateService {

	@Resource
	private LendingRateDAO lendingRateDAO;

	@Override
	public int save(LendingRate r) {
		return lendingRateDAO.insert(r);
	}

	@Override
	public int update(LendingRate r) {
		return lendingRateDAO.update(r);
	}

	@Override
	public int delete(int id) {
		return lendingRateDAO.delete(id);
	}

	@Override
	public LendingRate get(int id) {
		return lendingRateDAO.get(id);
	}

	@Override
	public PageHolder<LendingRate> queryLendingRateList(
			HashMap<String, Object> hm, int pageIndex, int pageSize) {
		return lendingRateDAO.pagedQuery("findByParams", hm, pageIndex, pageSize);
	}

	@Override
	public List<LendingRate> findAll() {
		return lendingRateDAO.getAll();
	}
	
	
}
