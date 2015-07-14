package com.youguu.asteroid.tool.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.youguu.asteroid.tool.dao.TaxLevelDAO;
import com.youguu.asteroid.tool.pojo.TaxLevel;
import com.youguu.asteroid.tool.service.TaxLevelService;
import com.youguu.core.util.PageHolder;
@Service("taxLevelService")
public class TaxLevelServiceImpl implements TaxLevelService {

	@Resource
	private TaxLevelDAO taxLevelDAO;

	@Override
	public int save(TaxLevel r) {
		
		return taxLevelDAO.insert(r);
	}

	@Override
	public int update(TaxLevel r) {
		
		return taxLevelDAO.update(r);
	}

	@Override
	public int delete(int id) {
		
		return taxLevelDAO.delete(id);
	}

	@Override
	public TaxLevel get(int id) {
		
		return taxLevelDAO.get(id);
	}

	@Override
	public PageHolder<TaxLevel> queryTaxLevelList(HashMap<String, Object> hm,
			int pageIndex, int pageSize) {
		
		return taxLevelDAO.pagedQuery("findByParams", hm, pageIndex, pageSize);
	}

	@Override
	public List<TaxLevel> findAll() {
		return taxLevelDAO.getAll();
	}
	
	
}
