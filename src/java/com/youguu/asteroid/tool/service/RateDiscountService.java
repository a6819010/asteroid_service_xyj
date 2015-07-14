package com.youguu.asteroid.tool.service;

import java.util.HashMap;
import java.util.List;

import com.youguu.asteroid.tool.pojo.RateDiscount;
import com.youguu.core.util.PageHolder;

public interface RateDiscountService {

	public int addRateDiscount(RateDiscount t);

	public boolean deleteRateDiscount(int id);

	public RateDiscount getRateDiscount(int id);

	public boolean modifyRateDiscount(RateDiscount t);

	public PageHolder<RateDiscount> queryRateDiscountList(HashMap<String, Object> hm, int pageIndex, int pageSize);
	
	public List<RateDiscount> findAll();
}
