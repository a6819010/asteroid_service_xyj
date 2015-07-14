package com.youguu.asteroid.tradeday.service;

import java.text.ParseException;
import java.util.Date;
import java.util.Set;

/**
* @Title: ITradeDayService.java 
* @Package com.youguu.asteroid.tradeday.service 
* @Description: 交易日获取接口
* @author 徐云杰
* @date 2014年11月26日 下午4:04:09 
* @version V1.0
 */
public interface ITradeDayService {
	
	/**
	 * 获取交易日的数据
	 * @return List<String>
	 */
	public Set<String> getTradeDayList();
	
	/**
	 * 获取最大交易日
	 * @return List<String>
	 */
	public String getMaxTradeDay();
	
	/**
	 * 查询是否为交易日
	 * @return
	 */
	public boolean isTradeDay(String date);
	
	/**
	 * 查询是否为交易日
	 * @return
	 */
	public boolean isTradeDay(Date date);
	
	/**
	 * 
	 * @param date 格式 yyyy-MM-dd 或者 yyyyMMdd
	 * @param num
	 * @return
	 */
	public String nextTradeDay(String date,int num)throws ParseException;
	
	/**
	 * 
	 * @param date
	 * @param num
	 * @return
	 */
	public String nextTradeDay(Date date,int num)throws ParseException;
	
	/**
	 * @param date T日，格式： yyyy-MM-dd
	 * @param days 交易日天数
	 * @param isContainStartDate 是否包含T日 true-从T日开始计算截止日，false-从T+1日开始计算截止日
	 * @return yyyyMMdd
	 * @throws ParseException
	 */
	public String queryTradeDayEnd(Date date, int days, boolean isContainStartDate)
			throws ParseException;
	
	/**
	 * 计算日期间隔天数
	 * @param date T日，格式： yyyy-MM-dd
	 * @param days 交易日天数
	 * @param isContainStartDate 是否包含T日 true-从T日开始计算截止日，false-从T+1日开始计算截止日
	 * @return
	 * @throws ParseException
	 */
	public int queryTradeDayInterval(Date date, int days, boolean isContainStartDate) throws ParseException;
	
	/**
	 * 获取开始到结束的交易日天数
	* @Title: getTradeDayNum
	* @Description: 
	* @param beginDate
	* @param endDate
	* @return    
	* int    返回类型
	 */
	public int getTradeDayNum(String beginDate,String endDate);

}
