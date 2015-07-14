package com.youguu.asteroid.activity.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.youguu.asteroid.activity.dao.ActivitySqlDAO;
import com.youguu.asteroid.activity.dao.IActivityPrizeDAO;
import com.youguu.asteroid.activity.pojo.ActivityPrize;
import com.youguu.core.util.PageHolder;

/**
 * 
* @Title: ActivityPrizeDAOImpl.java
* @Package com.youguu.asteroid.activity.dao.impl
* @Description:奖品DAO实现类
* @author 徐云杰
* @date 2015年3月9日 下午1:25:49
* @version V1.0
 */
@Repository("activityPrizeDAO")
public class ActivityPrizeDAOImpl extends ActivitySqlDAO<ActivityPrize> implements IActivityPrizeDAO {

	@Override
	public int addActivityPrize(ActivityPrize ap) {
		return super.insert(ap);
	}

	@Override
	public PageHolder<ActivityPrize> findAllActivityPrize(Map<String, Object> parameter, int pageIndex, int pageSize) {
		return super.pagedQuery("findAllActivityPrize", parameter, pageIndex, pageSize);
	}

	@Override
	public ActivityPrize findActivityPrizeById(int id) {
		return super.findUniqueBy("findActivityPrizeById", id);
	}

	@Override
	public int delActivityPrize(int id) {
		return super.delete(id);
	}

}
