package com.youguu.asteroid.fund.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.youguu.asteroid.fund.dao.FundConvertDAO;
import com.youguu.asteroid.fund.pojo.FundConvert;
import com.youguu.asteroid.fund.service.FundConvertService;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;

@Service("fundConvertService")
public class FundConvertServiceImpl implements FundConvertService{
	
	private static Log logger = LogFactory.getLog("FundConvcetService");
	
	@Resource
	private FundConvertDAO fund;
	
	@Override
	public List<FundConvert> queryFund(String fundCode,
			String regDateStart, String regDateEnd, String convertDateStart,
			String convertDateEnd, int convertType,int status,int pageStart,int pageSize) {
		List<FundConvert> list = fund.queryFund(fundCode, regDateStart, regDateEnd, convertDateStart, convertDateEnd, convertType, status, pageStart, pageSize);
		if(null != list && list.size()>0){
			return list;
		}
		return null;
	}

	@Override
	public int insertFund(FundConvert fund) {
		int result = 0;
		try {
			result = this.fund.insertFund(fund);
		} catch (Exception e) {
			logger.info("插入基金失败："+e);
		}
		return result;
	}

	@Override
	public int updateFund(FundConvert fund) {
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
			result = this.deleteFund(id);
		} catch (Exception e) {
			logger.info("删除基金失败:"+e);
		}
		return result;
	}

	@Override
	public FundConvert findById(int id) {
		FundConvert fc = null;
		try {
			fc = fund.findById(id);
		} catch (Exception e) {
			logger.info("查询失败:"+ e);
		}
		return fc;
	}

}
