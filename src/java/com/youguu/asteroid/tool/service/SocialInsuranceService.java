package com.youguu.asteroid.tool.service;

import java.util.HashMap;
import java.util.List;

import com.youguu.asteroid.tool.pojo.SocialInsurance;
import com.youguu.core.util.PageHolder;

public interface SocialInsuranceService {

	int save(SocialInsurance r);

	int update(SocialInsurance r);

	int delete(int id);

	SocialInsurance get(int id);

	public PageHolder<SocialInsurance> querySocialInsuranceList(
			HashMap<String, Object> hm, int pageIndex, int pageSize);
	
	List<SocialInsurance> findAll();
}
