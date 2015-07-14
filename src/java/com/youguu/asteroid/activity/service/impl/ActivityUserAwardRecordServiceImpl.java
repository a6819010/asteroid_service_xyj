package com.youguu.asteroid.activity.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.youguu.asteroid.activity.dao.IActivityUserAwardRecordDAO;
import com.youguu.asteroid.activity.pojo.ActivityUserAwardRecord;
import com.youguu.asteroid.activity.service.IActivityUserAwardRecordService;
import com.youguu.core.util.PageHolder;

/**
 * 
* @Title: ActivityUserAwardRecordServiceImpl.java
* @Package com.youguu.asteroid.activity.service.impl
* @Description: 用户获奖记录Service接口实现类
* @author 徐云杰
* @date 2015年3月9日 下午1:43:51
* @version V1.0
 */
@Service("activityUserAwardRecordService")
public class ActivityUserAwardRecordServiceImpl implements IActivityUserAwardRecordService {

	@Resource
	private IActivityUserAwardRecordDAO activityUserAwardRecordDAO;
	
	@Override
	public int addActivityUserAwardRecord(ActivityUserAwardRecord activityUserAwardRecord) {
		return activityUserAwardRecordDAO.addActivityUserAwardRecord(activityUserAwardRecord);
	}

	@Override
	public int updateStatus(Map<String, Integer> map) {
		return activityUserAwardRecordDAO.updateStatus(map);
	}

	@Override
	public int update(ActivityUserAwardRecord activityUserAwardRecord) {
		return activityUserAwardRecordDAO.update(activityUserAwardRecord);
	}

	@Override
	public List<ActivityUserAwardRecord> findNoCash(int userId) {
		return activityUserAwardRecordDAO.findNoCash(userId);
	}

	@Override
	public PageHolder<ActivityUserAwardRecord> findAllActivityUserAwardRecord(Map<String, Object> parameter, int pageIndex, int pageSize) {
		return activityUserAwardRecordDAO.findAllActivityUserAwardRecord(parameter, pageIndex, pageSize);
	}

	@Override
	public ActivityUserAwardRecord getRecord(int poolId) {
		return activityUserAwardRecordDAO.getRecord(poolId);
	}

}
