package com.youguu.asteroid.fund.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.youguu.asteroid.fund.dao.FundDivDAO;
import com.youguu.asteroid.fund.dao.FundSqlDAO;
import com.youguu.asteroid.fund.pojo.FundDiv;

@Repository
public class FundDivDAOImpl extends FundSqlDAO<FundDiv> implements FundDivDAO {

	@Override
	public List<FundDiv> queryFund(String fundCode,
			String regDateStart, String regDateEnd, String convertDateStart,
			String convertDateEnd, int divType, int status, int pageStart,
			int pageSize) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fundCode", fundCode);
		params.put("regDateStart", regDateStart);
		params.put("regDateEnd", regDateEnd);
		params.put("convertDateStart", convertDateStart);
		params.put("convertDateEnd", convertDateEnd);
		params.put("divType", divType);
		params.put("status", status);
		params.put("pageStart", pageStart);
		params.put("pageSize", pageSize);
		List<FundDiv> list = this.findBy("findFund", params);
		if(null != list && list.size()>0){
			return list;
		}
		return null;
	}

	@Override
	public int insertFund(FundDiv fund) {
		int result = 0;
		try {
			result = this.insertBy("insert", fund);
		} catch (Exception e) {
			logger.info("插入基金失败："+e);
		}
		return result;
	}

	@Override
	public int updateFund(FundDiv fund) {
		int result = 0;
		try {
			result = this.updateBy("update", fund);
		} catch (Exception e) {
			logger.info("更新基金失败:"+e);
		}
		return result;
	}

	@Override
	public int deleteFund(int id) {
		int result = 0;
		try {
			result = this.deleteBy("delete", id);
		} catch (Exception e) {
			logger.info("删除基金失败:"+e);
		}
		return result;
	}

	@Override
	public FundDiv findById(int id) {
		FundDiv fd = null;
		try {
			fd = this.findUniqueBy("findById", id);
		} catch (Exception e) {
			logger.info("查询基金失败:"+e);
		}
		return fd;
	}

}
