package com.youguu.asteroid.activity.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.youguu.asteroid.activity.dao.ActivitySqlDAO;
import com.youguu.asteroid.activity.dao.IActivityUserAwardRecordDAO;
import com.youguu.asteroid.activity.pojo.ActivityUserAwardRecord;
import com.youguu.core.util.PageHolder;

/**
 * 
* @Title: ActivityUserAwardRecordDAOImpl.java
* @Package com.youguu.asteroid.activity.dao.impl
* @Description: 用户获奖记录DAO实现类
* @author 徐云杰
* @date 2015年3月9日 下午1:27:53
* @version V1.0
 */
@Repository("activityUserAwardRecordDAO")
public class ActivityUserAwardRecordDAOImpl extends ActivitySqlDAO<ActivityUserAwardRecord> implements IActivityUserAwardRecordDAO {

	@Override
	public int addActivityUserAwardRecord(ActivityUserAwardRecord activityUserAwardRecord) {
		return super.insert(activityUserAwardRecord);
	}

	@Override
	public int updateStatus(Map<String, Integer> map) {
		return super.updateBy("updateStatus", map);
	}

	@Override
	public List<ActivityUserAwardRecord> findNoCash(int userId) {
		return super.findBy("findNoCash", userId);
	}

	@Override
	public PageHolder<ActivityUserAwardRecord> findAllActivityUserAwardRecord(Map<String, Object> parameter, int pageIndex, int pageSize) {
		return super.pagedQuery("findAllActivityUserAwardRecord", parameter, pageIndex, pageSize);
	}

	@Override
	public ActivityUserAwardRecord getRecord(int poolId) {
		return super.findUniqueBy("getRecord", poolId);
	}

}
