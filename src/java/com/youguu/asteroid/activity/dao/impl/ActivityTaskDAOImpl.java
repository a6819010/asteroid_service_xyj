package com.youguu.asteroid.activity.dao.impl;

import org.springframework.stereotype.Repository;

import com.youguu.asteroid.activity.dao.ActivitySqlDAO;
import com.youguu.asteroid.activity.dao.IActivityTaskDAO;
import com.youguu.asteroid.activity.pojo.ActivityTask;

/**
 * 
* @Title: ActivityTaskDAOImpl.java
* @Package com.youguu.asteroid.activity.dao.impl
* @Description:活动任务DAO实现类
* @author 徐云杰
* @date 2015年3月9日 下午1:26:44
* @version V1.0
 */
@Repository("activityTaskDAO")
public class ActivityTaskDAOImpl extends ActivitySqlDAO<ActivityTask> implements IActivityTaskDAO {
	
	@Override
	public ActivityTask findActivityTask(int id) {
		return super.findUniqueBy("findActivityTask", id);
	}

}
