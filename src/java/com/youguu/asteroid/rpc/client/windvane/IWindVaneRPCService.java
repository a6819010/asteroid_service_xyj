package com.youguu.asteroid.rpc.client.windvane;

import java.util.List;
import java.util.Map;

import com.youguu.asteroid.windvane.pojo.MarketWindVanePollVote;

/**
* @Title: IWindVaneRPCService.java 
* @Package com.youguu.asteroid.rpc.client.windvane 
* @Description: 风向标service接口,RPC 
* @author 徐云杰
* @date 2014年12月4日 下午4:02:58 
* @version V1.0
 */
public interface IWindVaneRPCService {
	
	/**
	 * @Title: 查询
	 * @Description: 查询指定日期的统投
	 * @param String date
	 * @return MarketWindVanePollVote
	 * @throws
	 */
	public MarketWindVanePollVote getMarketWindVanePollVote(String date);
	
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
	 * @Title: 收盘清算
	 * @Description: 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int closeClear();
	
	/**
	 * @Title: 查询市场风向标
	 * @Description: 
	 * @param uid
	 * @return Map<String,String>
	 * @throws
	 */
	public Map<String,String> findWindVane(int uid);

	/**
	 * @Title: 投票
	 * @Description: 返回 0：用户未登录 1：投票成功 2:投票失败
	 * @param uid,voteflag 点击的投票 1：投涨 2：投跌
	 * @return int
	 * @throws
	 */
	public int vote(int uid,int voteflag);

	/**
	 * @Title: 牛熊比
	 * @Description: 
	 * @param 
	 * @return Map<String,List<String>>
	 * @throws
	 */
	public Map<String,List<Double>> cowThanBear();
	
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
