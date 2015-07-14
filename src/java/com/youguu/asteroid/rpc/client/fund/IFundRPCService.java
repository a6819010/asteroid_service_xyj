package com.youguu.asteroid.rpc.client.fund;

import java.util.List;

import com.youguu.asteroid.fund.pojo.FundConvert;
import com.youguu.asteroid.fund.pojo.FundDiv;

/**
* @Title: IFundRPCService.java
* @Package com.youguu.asteroid.rpc.client.fund
* @Description:
* @author zhaozhichao
* @date 2015年5月25日 下午8:14:13
* @version V1.0
 */
public interface IFundRPCService {
	/**
	* @Title: queryFundConvert
	* @Description: 通过条件查询基金信息
	* @param fundCode
	* @param fundAbbr
	* @param regDateStart
	* @param regDateEnd
	* @param convertDateStart
	* @param convertDateEnd
	* @param convertType
	* @param status
	* @param pageStart
	* @param pageSize
	* @return    
	* List<FundConvert>    返回类型
	 */
	List<FundConvert> queryFundConvert(String fundCode,String regDateStart,String regDateEnd,String convertDateStart,String convertDateEnd,int convertType,int status,int pageStart,int pageSize);
	
	
	/**
	* @Title: insertFundConvert
	* @Description: 添加基金信息
	* @param fund
	* @return    
	* int    返回类型
	 */
	int insertFundConvert(FundConvert fund);

	/**
	* @Title: updateFundConvert
	* @Description: 修改基金信息
	* @param fund
	* @return    
	* int    返回类型
	 */
	int updateFundConvert(FundConvert fund);

	/**
	* @Title: deleteFundConvert
	* @Description: 删除基金信息
	* @param id
	* @return    
	* int    返回类型
	 */
	int deleteFundConvert(int id);

	/**
	* @Title: queryFundDiv
	* @Description: 通过条件查询基金信息
	* @param fundCode
	* @param fundAbbr
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
	List<FundDiv> queryFundDiv(String fundCode,String regDateStart,String regDateEnd,String convertDateStart,String convertDateEnd,int divType,int status,int pageStart,int pageSize);

	/**
	* @Title: insertFundDiv
	* @Description:添加基金信息
	* @param fund
	* @return    
	* int    返回类型
	 */
	int insertFundDiv(FundDiv fund);

	/**
	* @Title: updateFundDiv
	* @Description: 修改基金信息
	* @param fund
	* @return    
	* int    返回类型
	 */
	int updateFundDiv(FundDiv fund);

	/**
	* @Title: deleteFundDiv
	* @Description: 删除基金信息
	* @param id
	* @return    
	* int    返回类型
	 */
	int deleteFundDiv(int id);
	
	/**
	* @Title: findCById
	* @Description: 通过ID查询
	* @param id
	* @return    
	* FundConvert    返回类型
	 */
	FundConvert findCById(int id);
	
	/**
	* @Title: findDById
	* @Description: 通过ID查询
	* @param id
	* @return    
	* FundDiv    返回类型
	 */
	FundDiv findDById(int id);
}
