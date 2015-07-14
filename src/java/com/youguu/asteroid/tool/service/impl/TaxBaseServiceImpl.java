package com.youguu.asteroid.tool.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.youguu.asteroid.tool.dao.TaxBaseDAO;
import com.youguu.asteroid.tool.pojo.TaxBase;
import com.youguu.asteroid.tool.service.TaxBaseService;
import com.youguu.core.util.PageHolder;

@Service("taxBaseService")
public class TaxBaseServiceImpl implements TaxBaseService {

	@Resource
	private TaxBaseDAO taxBaseDAO;
	
	@Override
	public int save(TaxBase r) {
		return taxBaseDAO.insert(r);
	}

	@Override
	public int update(TaxBase r) {
		return taxBaseDAO.update(r);
	}

	@Override
	public int delete(int id) {
		return taxBaseDAO.delete(id);
	}

	@Override
	public TaxBase get(int id) {
		return taxBaseDAO.get(id);
	}

	@Override
	public PageHolder<TaxBase> queryTaxBaseList(HashMap<String, Object> hm,
			int pageIndex, int pageSize) {
		return taxBaseDAO.pagedQuery("findByParams", hm, pageIndex, pageSize);
	}

	@Override
	public List<TaxBase> findAll() {
		return taxBaseDAO.getAll();
	}
}
