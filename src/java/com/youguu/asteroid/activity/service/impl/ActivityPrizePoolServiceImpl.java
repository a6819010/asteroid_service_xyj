package com.youguu.asteroid.activity.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.youguu.asteroid.activity.dao.IActivityPrizePoolDAO;
import com.youguu.asteroid.activity.pojo.ActivityPrizePool;
import com.youguu.asteroid.activity.service.IActivityPrizePoolService;
import com.youguu.core.util.PageHolder;

/**
 * 
* @Title: ActivityPrizePoolImpl.java
* @Package com.youguu.asteroid.activity.service.impl
* @Description:奖金池Service接口实现类
* @author 徐云杰
* @date 2015年3月9日 下午1:39:03
* @version V1.0
 */
@Service("activityPrizePoolService")
public class ActivityPrizePoolServiceImpl implements IActivityPrizePoolService {
	
	@Resource
	private IActivityPrizePoolDAO activityPrizePoolDAO;

	@Override
	public int batchInsert(List<ActivityPrizePool> list) {
		return activityPrizePoolDAO.batchInsert(list);
	}

	@Override
	public PageHolder<ActivityPrizePool> findAllPrizePool(Map<String, Object> parameter, int pageIndex, int pageSize) {
		return activityPrizePoolDAO.findAllPrizePool(parameter, pageIndex, pageSize);
	}

	@Override
	public int updateStatus(int id) {
		return activityPrizePoolDAO.updateStatus(id);
	}

	@Override
	public ActivityPrizePool getOnePrize(int taskId) {
		return activityPrizePoolDAO.getOnePrize(taskId);
	}

	@Override
	public List<ActivityPrizePool> findPrizePoolListByTaskId(int taskId) {
		return activityPrizePoolDAO.findPrizePoolListByTaskId(taskId);
	}

	@Override
	public int updateInfo(ActivityPrizePool activityPrizePool) {
		return activityPrizePoolDAO.updateInfo(activityPrizePool);
	}

	@Override
	public int updateReserveStatus(ActivityPrizePool activityPrizePool) {
		return activityPrizePoolDAO.updateReserveStatus(activityPrizePool);
	}

}
