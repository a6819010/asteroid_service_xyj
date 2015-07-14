package com.youguu.asteroid.tool.service;

import java.util.HashMap;
import java.util.List;

import com.youguu.asteroid.tool.pojo.TaxLevel;
import com.youguu.core.util.PageHolder;

public interface TaxLevelService {
	int save(TaxLevel r);

	int update(TaxLevel r);

	int delete(int id);

	TaxLevel get(int id);

	public PageHolder<TaxLevel> queryTaxLevelList(
			HashMap<String, Object> hm, int pageIndex, int pageSize);
	
	List<TaxLevel> findAll();
}
