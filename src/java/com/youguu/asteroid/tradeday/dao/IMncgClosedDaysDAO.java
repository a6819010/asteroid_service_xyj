package com.youguu.asteroid.tradeday.dao;

import java.util.Set;

/**
* @Title: ITradeDayDAO.java 
* @Package com.youguu.asteroid.tradeday.dao 
* @Description: 交易日接口DAO
* @author 徐云杰
* @date 2014年11月27日 下午3:41:03 
* @version V1.0
 */
public interface IMncgClosedDaysDAO {
	/**
	 * 获取交易日的数据
	 * @return List<String>
	 */
	public Set<String> getTradeDayList();
	
	/**
	 * 获取最大交易日
	 * @return String
	 */
	public String getMaxTradeDay();
}
