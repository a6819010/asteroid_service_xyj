package com.youguu.asteroid.windvane.dao;

import java.util.List;
import java.util.Map;

import com.youguu.asteroid.windvane.pojo.MarketWindVanePollVote;
import com.youguu.core.util.PageHolder;

/**
 * 
 * @Title: IMarketWindVanePollVoteDAO.java 
 * @Package com.youguu.asteroid.windvane.dao 
 * @Description: 市场风向标投票统计DAO接口
 * @author 徐云杰
 * @date 2014年12月1日 上午11:36:17 
 * @version V1.0
 */
public interface IMarketWindVanePollVoteDAO {

	/**
	 * @Title: 新增
	 * @Description: 
	 * @param marketWindVanePollVote
	 * @return int
	 * @throws
	 */
	public int insert(MarketWindVanePollVote marketWindVanePollVote);

	/**
	 * 
	 * @Title: 修改
	 * @Description: 
	 * @param marketWindVanePollVote
	 * @return int
	 * @throws
	 */
	public int update(MarketWindVanePollVote marketWindVanePollVote);
	
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
	public int delete(String date);

	/**
	 * @Title: 查询
	 * @Description: 查询指定日期的统投
	 * @param String date
	 * @return MarketWindVanePollVote
	 * @throws
	 */
	public MarketWindVanePollVote selectMarketWindVanePollVote(String date);

	/**
	 * @Title: 分页查询
	 * @Description: 
	 * @param Map<String, Object> parameter, int pageIndex, int pageSize
	 * @return PageHolder<MarketWindVanePollVote>
	 * @throws
	 */
	public PageHolder<MarketWindVanePollVote> findAllMarketWindVanePollVote(Map<String, Object> parameter, int pageIndex, int pageSize);
	
	/**
	* @Title: 获取当前天数的最近风向标统投数据
	* @Description: nowdate 格式：yyyyMMdd
	* @param String nowdate,int daynum
	* @return List<MarketWindVanePollVote>
	* @throws
 */
	public List<MarketWindVanePollVote> getNDaysWindVane(int daynum);

}
