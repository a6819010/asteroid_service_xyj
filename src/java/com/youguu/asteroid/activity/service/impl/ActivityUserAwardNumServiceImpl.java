package com.youguu.asteroid.activity.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.youguu.asteroid.activity.dao.IActivityUserAwardNumDAO;
import com.youguu.asteroid.activity.pojo.ActivityUserAwardNum;
import com.youguu.asteroid.activity.service.IActivityUserAwardNumService;
import com.youguu.core.util.PageHolder;

/**
 * 
* @Title: ActivityUserAwardNumServiceImpl.java
* @Package com.youguu.asteroid.activity.service.impl
* @Description:用户抽奖明细Service接口实现类
* @author 徐云杰
* @date 2015年3月9日 下午1:42:57
* @version V1.0
 */
@Service("activityUserAwardNumService")
public class ActivityUserAwardNumServiceImpl implements IActivityUserAwardNumService {
	
	@Resource
	private IActivityUserAwardNumDAO activityUserAwardNumDAO;

	@Override
	public int addActivityUserAwardNum(ActivityUserAwardNum activityUserAwardNum) {
		return activityUserAwardNumDAO.addActivityUserAwardNum(activityUserAwardNum);
	}

	@Override
	public ActivityUserAwardNum getUserAwardNum(int userId) {
		return activityUserAwardNumDAO.getUserAwardNum(userId);
	}

	@Override
	public int updateNum(int userId) {
		return activityUserAwardNumDAO.updateNum(userId);
	}

	@Override
	public int updateAddNum(Map<String, Object> map) {
		return activityUserAwardNumDAO.updateAddNum(map);
	}

	@Override
	public PageHolder<ActivityUserAwardNum> findAllUserAwardNum(Map<String, Object> parameter, int pageIndex, int pageSize) {
		return activityUserAwardNumDAO.findAllUserAwardNum(parameter, pageIndex, pageSize);
	}

}
