package com.youguu.asteroid.windvane.service;

import java.util.List;
import java.util.Map;

/**
 * @Title: IWindVaneDisposeService.java 
 * @Package com.youguu.asteroid.windvane.service 
 * @Description: 供APP接口调用，提供风向标功能主要方法的接口
 * @author 徐云杰
 * @date 2014年12月2日 上午9:20:42 
 * @version V1.0
 */
public interface IWindVaneDisposeService {

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
	 * @return Map<String,List<Double>>
	 * @throws
	 */
	public Map<String,List<Double>> cowThanBear();

	/**
	 * @Title: 收盘清算
	 * @Description: 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int closeClear();

}
