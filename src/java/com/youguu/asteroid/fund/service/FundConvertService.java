package com.youguu.asteroid.fund.service;

import java.util.List;


import com.youguu.asteroid.fund.pojo.FundConvert;

/**
 * @Title: FundCounvertService.java
 * @Package com.youguu.asteroid.fund.service
 * @Description: 分级基金除权除息
 * @author zhaozhichao
 * @date 2015年5月25日 下午4:23:05
 * @version V1.0
 */
public interface FundConvertService {

	/**
	* @Title: queryFund
	* @Description: 通过条件查询基金信息
	* @param fundCode
	* @param regDateStart
	* @param regDateEnd
	* @param convertDateStart
	* @param convertDateEnd
	* @param status
	* @return    
	* List<FundConvert>    返回类型
	 */
	List<FundConvert> queryFund(String fundCode,String regDateStart,String regDateEnd,String convertDateStart,String convertDateEnd,int convertType,int status,int pageStart,int pageSize); 
	
	/**
	* @Title: insertFund
	* @Description: 添加基金信息
	* @param fund
	* @return    
	* int    返回类型
	 */
	int insertFund(FundConvert fund);
	
	/**
	* @Title: updateFund
	* @Description: 修改基金信息
	* @param fund
	* @return    
	* int    返回类型
	 */
	int updateFund(FundConvert fund);
	
	/**
	* @Title: deleteFund
	* @Description: 删除基金信息
	* @param id
	* @return    
	* int    返回类型
	 */
	int deleteFund(int id);
	
	/**
	* @Title: findById
	* @Description: 获取基金信息
	* @param id
	* @return    
	* FundConvert    返回类型
	 */
	FundConvert findById(int id);
	
}
