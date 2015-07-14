package com.youguu.asteroid.windvane.service;

import java.util.List;
import java.util.Map;

import com.youguu.asteroid.windvane.pojo.MarketWindVanePollVote;
import com.youguu.core.util.PageHolder;

/**
* @Title: IMarketWindVanePollVoteService.java 
* @Package com.youguu.asteroid.windvane.service 
* @Description: 市场风向标投票统计Service接口
* @author 徐云杰
* @date 2014年12月1日 上午11:40:20 
* @version V1.0
 */
public interface IMarketWindVanePollVoteService {
	
	/**
	 * @Title: 新增
	 * @Description: 
	 * @param marketWindVanePollVote
	 * @return int
	 * @throws
	 */
	public int addMarketWindVanePollVote(MarketWindVanePollVote marketWindVanePollVote);
	
	/**
	 * 
	 * @Title: 修改
	 * @Description: 
	 * @param marketWindVanePollVote
	 * @return int
	 * @throws
	 */
	public int updateMarketWindVanePollVote(MarketWindVanePollVote marketWindVanePollVote);
	
	/**
	 * 
	 * @Title: 修改投票结果
	 * @Description: 
	 * @param date,result
	 * @return int
	 * @throws
	 */
	public int updateResult(String date,int result);
	
	/**
	 * @Title: 删除
	 * @Description: 
	 * @param String date
	 * @return int
	 * @throws
	 */
	public int deleteMarketWindVanePollVote(String date);
	
	/**
	 * @Title: 查询
	 * @Description: 查询指定日期的统投
	 * @param String date
	 * @return MarketWindVanePollVote
	 * @throws
	 */
	public MarketWindVanePollVote getMarketWindVanePollVote(String date);
	
	/**
	 * @Title: 分页查询
	 * @Description: 
	 * @param Map<String, Object> parameter, int pageIndex, int pageSize
	 * @return PageHolder<MarketWindVanePollVote>
	 * @throws
	 */
	public PageHolder<MarketWindVanePollVote> findAllMarketWindVanePollVote(Map<String, Object> parameter, int pageIndex, int pageSize);
	
	/**
		* @Title: 获取当前天数的最近风向标统投涨跌比值
		* @Description: nowdate 格式：yyyyMMdd
		* @param String nowdate,int daynum
		* @return List<String>
		* @throws
	 */
	public List<Double> getNDaysWindVane(int daynum);
	
	/**
	 * 
	* @Title: getNDaysWindVaneTime
	* @Description: 获取当前天数的最近风向标统投的时间
	* @param daynum
	* @return    
	* List<String>    返回类型
	* @throws
	 */
	public List<String> getNDaysWindVaneTime(int daynum);
}
