package com.youguu.asteroid.tool.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.youguu.asteroid.tool.dao.DepositRateDAO;
import com.youguu.asteroid.tool.pojo.DepositRate;
import com.youguu.asteroid.tool.service.DepositRateService;
import com.youguu.core.util.PageHolder;
@Service("depositRateService")
public class DepositRateServiceImpl implements DepositRateService {

	@Resource
	private DepositRateDAO depositRateDAO;

	@Override
	public int save(DepositRate r) {
		
		return depositRateDAO.insert(r);
	}

	@Override
	public int update(DepositRate r) {
		
		return depositRateDAO.update(r);
	}

	@Override
	public int delete(int id) {
		
		return depositRateDAO.delete(id);
	}

	@Override
	public DepositRate get(int id) {
		
		return depositRateDAO.get(id);
	}

	@Override
	public PageHolder<DepositRate> queryDepositRateList(
			HashMap<String, Object> hm, int pageIndex, int pageSize) {
		
		return depositRateDAO.pagedQuery("findByParams", hm, pageIndex, pageSize);
	}

	@Override
	public List<DepositRate> findAll() {
		return depositRateDAO.getAll();
	}
	
	
}
