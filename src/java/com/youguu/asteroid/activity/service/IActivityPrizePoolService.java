package com.youguu.asteroid.activity.service;

import java.util.List;
import java.util.Map;

import com.youguu.asteroid.activity.pojo.ActivityPrizePool;
import com.youguu.core.util.PageHolder;

/**
 * 
* @Title: IActivityPrizePoolService.java
* @Package com.youguu.asteroid.activity.service
* @Description: 奖金池Service接口
* @author 徐云杰
* @date 2015年3月9日 下午1:33:02
* @version V1.0
 */
public interface IActivityPrizePoolService {
	
	/**
	 * 
	* @Title: batchInsert
	* @Description: 批量新增
	* @param list
	* @return    
	* int    返回类型
	* @throws
	 */
	public int batchInsert(List<ActivityPrizePool> list);
	
	/**
	 * 
	* @Title: findAllPrizePool
	* @Description: 查询
	* @param parameter
	* @param pageIndex
	* @param pageSize
	* @return    
	* PageHolder<findAllPrizePool>    返回类型
	* @throws
	 */
	public PageHolder<ActivityPrizePool> findAllPrizePool(Map<String, Object> parameter, int pageIndex, int pageSize);
	
	/**
	 * 
	* @Title: updateStatus
	* @Description: 修改奖品状态
	* @param id
	* @return    
	* int    返回类型
	* @throws
	 */
	public int updateStatus(int id);
	
	/**
	 * 
	* @Title: getOnePrize
	* @Description: 根据任务ID返回一件奖品
	* @param taskId
	* @return    
	* ActivityPrizePool    返回类型
	* @throws
	 */
	public ActivityPrizePool getOnePrize(int taskId);
	
	/**
	 * 
	* @Title: findPrizePoolListByTaskId
	* @Description:根据任务ID查询未被使用的所有奖品
	* @param taskId
	* @return    
	* List<ActivityPrizePool>    返回类型
	* @throws
	 */
	public List<ActivityPrizePool> findPrizePoolListByTaskId(int taskId);
	
	/**
	 * 
	* @Title: update
	* @Description: 修改奖品信息
	* @param activityPrizePool
	* @return    
	* int    返回类型
	* @throws
	 */
	public int updateInfo(ActivityPrizePool activityPrizePool);
	
	/**
	 * 
	* @Title: updateReserveStatus
	* @Description: 修改奖品状态
	* @param activityPrizePool
	* @return    
	* int    返回类型
	* @throws
	 */
	public int updateReserveStatus(ActivityPrizePool activityPrizePool);

}
