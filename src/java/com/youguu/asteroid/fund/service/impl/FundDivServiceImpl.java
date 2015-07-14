package com.youguu.asteroid.fund.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.youguu.asteroid.fund.dao.FundDivDAO;
import com.youguu.asteroid.fund.pojo.FundDiv;
import com.youguu.asteroid.fund.service.FundDivService;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;

@Service("fundDivService")
public class FundDivServiceImpl implements FundDivService {

	private static Log logger = LogFactory.getLog("FundDivService");
	
	@Resource
	private FundDivDAO fund;
	
	@Override
	public List<FundDiv> queryFund(String fundCode,
			String regDateStart, String regDateEnd, String convertDateStart,
			String convertDateEnd, int divType, int status, int pageStart,
			int pageSize) {
		List<FundDiv> list = fund.queryFund(fundCode, regDateStart, regDateEnd, convertDateStart, convertDateEnd, divType, status, pageStart, pageSize);
		if(null != list && list.size()>0){
			return list;
		}
		return null;
	}

	@Override
	public int insertFund(FundDiv fund) {
		int result = 0;
		try {
			result = this.fund.insertFund(fund);
		} catch (Exception e) {
			logger.info("插入基金失败："+e);
		}
		return result;
	}

	@Override
	public int updateFund(FundDiv fund) {
		int result = 0;
		try {
			result = this.fund.updateFund(fund);
		} catch (Exception e) {
			logger.info("更新基金失败:"+e);
		}
		return result;
	}

	@Override
	public int deleteFund(int id) {
		int result = 0;
		try {
			result = this.fund.deleteFund(id);
		} catch (Exception e) {
			logger.info("删除基金失败:"+e);
		}
		return result;
	}

	@Override
	public FundDiv findById(int id) {
		FundDiv fd = null;
		try {
			fd = fund.findById(id);
		} catch (Exception e) {
			logger.info("查询基金失败:"+e);
		}
		return fd;
	}

}
