package com.youguu.asteroid.activity.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.youguu.asteroid.activity.dao.ActivitySqlDAO;
import com.youguu.asteroid.activity.dao.IActivityUserAwardNumDAO;
import com.youguu.asteroid.activity.pojo.ActivityUserAwardNum;
import com.youguu.core.util.PageHolder;

/**
 * 
* @Title: ActivityUserAwardNumDAOImpl.java
* @Package com.youguu.asteroid.activity.dao.impl
* @Description:用户抽奖总次数DAO实现类
* @author 徐云杰
* @date 2015年3月9日 下午1:27:36
* @version V1.0
 */
@Repository("activityUserAwardNumDAO")
public class ActivityUserAwardNumDAOImpl extends ActivitySqlDAO<ActivityUserAwardNum> implements IActivityUserAwardNumDAO {

	@Override
	public int addActivityUserAwardNum(ActivityUserAwardNum activityUserAwardNum) {
		return super.insert(activityUserAwardNum);
	}

	@Override
	public ActivityUserAwardNum getUserAwardNum(int userId) {
		return super.findUniqueBy("getUserAwardNum", userId);
	}

	@Override
	public int updateNum(int userId) {
		return super.updateBy("updateNum", userId);
	}

	@Override
	public int updateAddNum(Map<String, Object> map) {
		return super.updateBy("updateAddNum", map);
	}

	@Override
	public PageHolder<ActivityUserAwardNum> findAllUserAwardNum(Map<String, Object> parameter, int pageIndex, int pageSize) {
		return super.pagedQuery("findAllUserAwardNum", parameter, pageIndex, pageSize);
	}


}
