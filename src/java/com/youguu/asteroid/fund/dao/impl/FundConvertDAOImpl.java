package com.youguu.asteroid.fund.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.springframework.stereotype.Repository;

import com.youguu.asteroid.fund.dao.FundConvertDAO;
import com.youguu.asteroid.fund.dao.FundSqlDAO;
import com.youguu.asteroid.fund.pojo.FundConvert;

@Repository
public class FundConvertDAOImpl extends FundSqlDAO<FundConvert> implements FundConvertDAO {

	
	@Override
	public List<FundConvert> queryFund( String fundCode,
			String regDateStart, String regDateEnd, String convertDateStart,
			String convertDateEnd, int convertType,int status,int pageStart,int pageSize) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fundCode", fundCode);
		params.put("regDateStart", regDateStart);
		params.put("regDateEnd", regDateEnd);
		params.put("convertDateStart", convertDateStart);
		params.put("convertDateEnd", convertDateEnd);
		params.put("convertType", convertType);
		params.put("status", status);
		params.put("pageStart", pageStart);
		params.put("pageSize", pageSize);
		List<FundConvert> list = this.findBy("findFund", params);
		if(null != list && list.size()>0){
			return list;
		}
		return null;
	}

	@Override
	public int insertFund(FundConvert fund) {
		int result = 0;
		try {
			result = this.insertBy("insert", fund);
		} catch (Exception e) {
			logger.info("插入基金失败："+e);
		}
		return result;
	}

	@Override
	public int updateFund(FundConvert fund) {
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
	public FundConvert findById(int id) {
		FundConvert fc = null;
		try {
			fc = this.findUniqueBy("findById", id);
		} catch (Exception e) {
			logger.info("查询失败:"+ e);
		}
		return fc;
	}

}
