package com.youguu.asteroid.activity.dao;

import java.util.List;
import java.util.Map;

import com.youguu.asteroid.activity.pojo.ActivityUserAwardRecord;
import com.youguu.core.util.PageHolder;

/**
 * 
* @Title: IActivityUserAwardRecordDAO.java
* @Package com.youguu.asteroid.activity.dao
* @Description: 用户获奖记录用户获奖记录DAO
* @author 徐云杰
* @date 2015年3月9日 下午12:01:54
* @version V1.0
 */
public interface IActivityUserAwardRecordDAO {
	
	public int addActivityUserAwardRecord(ActivityUserAwardRecord activityUserAwardRecord);
	
	public int updateStatus(Map<String,Integer> map);
	
	public int update(ActivityUserAwardRecord activityUserAwardRecord);
	
	public List<ActivityUserAwardRecord> findNoCash(int userId);
	
	public PageHolder<ActivityUserAwardRecord> findAllActivityUserAwardRecord(Map<String, Object> parameter, int pageIndex, int pageSize);
	
	public ActivityUserAwardRecord getRecord(int poolId);

}
