package com.youguu.asteroid.activity.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.youguu.asteroid.activity.dao.ActivitySqlDAO;
import com.youguu.asteroid.activity.dao.IActivityUserDAO;
import com.youguu.asteroid.activity.pojo.ActivityUser;
import com.youguu.core.util.PageHolder;

/**
 * 
* @Title: ActivityUserDAOImpl.java
* @Package com.youguu.asteroid.activity.dao.impl
* @Description: 活动用户DAO实现类
* @author 徐云杰
* @date 2015年3月9日 下午1:28:15
* @version V1.0
 */
@Repository("activityUserDAO")
public class ActivityUserDAOImpl extends ActivitySqlDAO<ActivityUser> implements IActivityUserDAO {

	@Override
	public PageHolder<ActivityUser> findAllActivityUser(Map<String, Object> parameter, int pageIndex, int pageSize) {
		return super.pagedQuery("findAllActivityUser", parameter, pageIndex, pageSize);
	}

	@Override
	public int batchInsert(List<ActivityUser> list) {
		return super.batchInsert(list, "insertList");
	}

	@Override
	public List<ActivityUser> findListActivityUser(Map<String, Object> map) {
		return super.findBy("findListActivityUser", map);
	}

	@Override
	public int updateStatus(Map<String, Object> map) {
		return super.updateBy("updateStatus", map);
	}

}
