package com.youguu.asteroid.tool.service;

import java.util.HashMap;
import java.util.List;

import com.youguu.asteroid.tool.pojo.TaxBase;
import com.youguu.core.util.PageHolder;

public interface TaxBaseService {

	int save(TaxBase r);

	int update(TaxBase r);

	int delete(int id);

	TaxBase get(int id);

	public PageHolder<TaxBase> queryTaxBaseList(
			HashMap<String, Object> hm, int pageIndex, int pageSize);
	
	List<TaxBase> findAll();
}
