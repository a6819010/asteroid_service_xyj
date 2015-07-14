package com.youguu.asteroid.tool.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.youguu.asteroid.tool.dao.RateDiscountDAO;
import com.youguu.asteroid.tool.pojo.RateDiscount;
import com.youguu.asteroid.tool.service.RateDiscountService;
import com.youguu.core.util.PageHolder;

@Service("rateDiscountService")
public class RateDiscountServiceImpl implements RateDiscountService {

	@Resource
	private RateDiscountDAO rateDiscountDAO;

	@Override
	public int addRateDiscount(RateDiscount t) {
		return rateDiscountDAO.insert(t);
	}

	@Override
	public boolean deleteRateDiscount(int id) {
		return rateDiscountDAO.delete(id)>0?true:false;
	}

	@Override
	public RateDiscount getRateDiscount(int id) {
		return rateDiscountDAO.get(id);
	}

	@Override
	public boolean modifyRateDiscount(RateDiscount t) {
		return rateDiscountDAO.update(t)>0?true:false;
	}

	@Override
	public PageHolder<RateDiscount> queryRateDiscountList(
			HashMap<String, Object> hm, int pageIndex, int pageSize) {
		return rateDiscountDAO.pagedQuery("findByParams", hm, pageIndex, pageSize);
	}

	@Override
	public List<RateDiscount> findAll() {
		return rateDiscountDAO.getAll();
	}
	
	
}
