package com.youguu.asteroid.activity.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.youguu.asteroid.activity.dao.ActivitySqlDAO;
import com.youguu.asteroid.activity.dao.IActivityPrizePoolDAO;
import com.youguu.asteroid.activity.pojo.ActivityPrizePool;
import com.youguu.core.util.PageHolder;

/**
 * 
* @Title: ActivityPrizePoolDAOImpl.java
* @Package com.youguu.asteroid.activity.dao.impl
* @Description: 奖池DAO实现类
* @author 徐云杰
* @date 2015年3月9日 下午1:26:25
* @version V1.0
 */
@Repository("activityPrizePoolDAO")
public class ActivityPrizePoolDAOImpl extends ActivitySqlDAO<ActivityPrizePool> implements IActivityPrizePoolDAO {

	@Override
	public int batchInsert(List<ActivityPrizePool> list) {
		return super.batchInsert(list, "insertList");
	}

	@Override
	public PageHolder<ActivityPrizePool> findAllPrizePool(Map<String, Object> parameter, int pageIndex, int pageSize) {
		return super.pagedQuery("findAllPrizePool", parameter, pageIndex, pageSize);
	}

	@Override
	public int updateStatus(int id) {
		return super.updateBy("updateStatus", id);
	}

	@Override
	public ActivityPrizePool getOnePrize(int taskId) {
		return super.findUniqueBy("getOnePrize", taskId);
	}

	@Override
	public List<ActivityPrizePool> findPrizePoolListByTaskId(int taskId) {
		return super.findBy("findPrizePoolListByTaskId", taskId);
	}

	@Override
	public int updateReserveStatus(ActivityPrizePool activityPrizePool) {
		return super.updateBy("updateReserveStatus", activityPrizePool);
	}

	@Override
	public int updateInfo(ActivityPrizePool activityPrizePool) {
		return super.update(activityPrizePool);
	}

}
