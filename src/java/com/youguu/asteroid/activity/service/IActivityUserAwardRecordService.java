package com.youguu.asteroid.activity.service;

import java.util.List;
import java.util.Map;

import com.youguu.asteroid.activity.pojo.ActivityUserAwardRecord;
import com.youguu.core.util.PageHolder;

/**
 * 
* @Title: IActivityUserAwardRecordService.java
* @Package com.youguu.asteroid.activity.service
* @Description: 用户获奖记录Service接口
* @author 徐云杰
* @date 2015年3月9日 下午1:36:09
* @version V1.0
 */
public interface IActivityUserAwardRecordService {
	
	/**
	 * 
	* @Title: addActivityUserAwardRecord
	* @Description: 新增用户抽奖记录
	* @param activityUserAwardRecord
	* @return    
	* int    返回类型
	* @throws
	 */
	public int addActivityUserAwardRecord(ActivityUserAwardRecord activityUserAwardRecord);
	
	/**
	 * 
	* @Title: updateStatus
	* @Description: 修改记录状态
	* @param map
	* @return    
	* int    返回类型
	* @throws
	 */
	public int updateStatus(Map<String,Integer> map);
	
	/**
	 * 
	* @Title: update
	* @Description: 修改记录信息
	* @param activityUserAwardRecord
	* @return    
	* int    返回类型
	* @throws
	 */
	public int update(ActivityUserAwardRecord activityUserAwardRecord);
	
	/**
	 * 
	* @Title: findNoCash
	* @Description: 查询没有领取奖品的记录
	* @param userId
	* @return    
	* List<ActivityUserAwardRecord>    返回类型
	* @throws
	 */
	public List<ActivityUserAwardRecord> findNoCash(int userId);
	
	/**
	 * 
	* @Title: findAllActivityUserAwardRecord
	* @Description: 分页查询领取记录
	* @param parameter
	* @param pageIndex
	* @param pageSize
	* @return    
	* PageHolder<ActivityUserAwardRecord>    返回类型
	* @throws
	 */
	public PageHolder<ActivityUserAwardRecord> findAllActivityUserAwardRecord(Map<String, Object> parameter, int pageIndex, int pageSize);

	/**
	 * 
	* @Title: getRecord
	* @Description: 获取一条记录
	* @param poolId
	* @return    
	* ActivityUserAwardRecord    返回类型
	* @throws
	 */
	public ActivityUserAwardRecord getRecord(int poolId);
}
