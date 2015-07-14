package com.youguu.asteroid.tool.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.youguu.asteroid.tool.dao.SocialInsuranceDAO;
import com.youguu.asteroid.tool.pojo.SocialInsurance;
import com.youguu.asteroid.tool.service.SocialInsuranceService;
import com.youguu.core.util.PageHolder;
@Service("socialInsuranceService")
public class SocialInsuranceServiceImpl implements SocialInsuranceService {

	@Resource
	private SocialInsuranceDAO socialInsuranceDAO;

	@Override
	public int save(SocialInsurance r) {
		
		return socialInsuranceDAO.insert(r);
	}

	@Override
	public int update(SocialInsurance r) {
		
		return socialInsuranceDAO.update(r);
	}

	@Override
	public int delete(int id) {
		
		return socialInsuranceDAO.delete(id);
	}

	@Override
	public SocialInsurance get(int id) {
		
		return socialInsuranceDAO.get(id);
	}

	@Override
	public PageHolder<SocialInsurance> querySocialInsuranceList(
			HashMap<String, Object> hm, int pageIndex, int pageSize) {
		
		return socialInsuranceDAO.pagedQuery("findByParams", hm, pageIndex, pageSize);
	}

	@Override
	public List<SocialInsurance> findAll() {
		return socialInsuranceDAO.getAll();
	}
	
	
}
