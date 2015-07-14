package com.youguu.asteroid.fund.dao;

import java.util.List;


import com.youguu.asteroid.fund.pojo.FundDiv;
/**
* @Title: FundDivDAO.java
* @Package com.youguu.asteroid.fund.dao
* @Description: 普通基金除权除息
* @author zhaozhichao
* @date 2015年5月25日 下午6:25:04
* @version V1.0
 */
public interface FundDivDAO {
	/**
	 * 
	* @Title: queryFund
	* @Description: 通过条件查询普通基金除权除息信息
	* @param fundCode
	* @param regDateStart
	* @param regDateEnd
	* @param convertDateStart
	* @param convertDateEnd
	* @param divType
	* @param status
	* @param pageStart
	* @param pageSize
	* @return    
	* List<FundDiv>    返回类型
	 */
	List<FundDiv> queryFund(String fundCode,String regDateStart,String regDateEnd,String convertDateStart,String convertDateEnd,int divType,int status,int pageStart,int pageSize); 
	
	/**
	* @Title: insertFund
	* @Description: 添加基金信息
	* @param fund
	* @return    
	* int    返回类型
	 */
	int insertFund(FundDiv fund);
	
	/**
	* @Title: updateFund
	* @Description: 修改基金信息
	* @param fund
	* @return    
	* int    返回类型
	 */
	int updateFund(FundDiv fund);
	
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
	* @Description: 查询基金
	* @param id
	* @return    
	* FundDiv    返回类型
	 */
	FundDiv findById(int id);
}
