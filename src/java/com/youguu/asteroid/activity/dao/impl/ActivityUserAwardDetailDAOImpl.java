package com.youguu.asteroid.activity.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.youguu.asteroid.activity.dao.ActivitySqlDAO;
import com.youguu.asteroid.activity.dao.IActivityUserAwardDetailDAO;
import com.youguu.asteroid.activity.pojo.ActivityUserAwardDetail;

/**
 * 
* @Title: ActivityUserAwardDetailDAOImpl.java
* @Package com.youguu.asteroid.activity.dao.impl
* @Description: 用户抽奖明细DAO实现类
* @author 徐云杰
* @date 2015年3月9日 下午1:27:00
* @version V1.0
 */
@Repository("activityUserAwardDetailDAO")
public class ActivityUserAwardDetailDAOImpl extends ActivitySqlDAO<ActivityUserAwardDetail> implements IActivityUserAwardDetailDAO {

	@Override
	public int batchInsert(List<ActivityUserAwardDetail> list) {
		return super.batchInsert(list,"insertList");
	}

	@Override
	public int updateStatus(int id) {
		return super.updateBy("updateStatus", id);
	}

	@Override
	public ActivityUserAwardDetail findDetail(int userId) {
		return super.findUniqueBy("findDetail", userId);
	}

}
