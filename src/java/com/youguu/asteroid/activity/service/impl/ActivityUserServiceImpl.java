package com.youguu.asteroid.activity.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.youguu.asteroid.activity.dao.IActivityUserDAO;
import com.youguu.asteroid.activity.pojo.ActivityUser;
import com.youguu.asteroid.activity.service.IActivityUserService;
import com.youguu.core.util.PageHolder;

/**
 * 
* @Title: ActivityUserServiceImpl.java
* @Package com.youguu.asteroid.activity.service.impl
* @Description: 活动用户Service接口实现类
* @author 徐云杰
* @date 2015年3月9日 下午1:40:58
* @version V1.0
 */
@Service("activityUserService")
public class ActivityUserServiceImpl implements IActivityUserService {
	
	@Resource
	private IActivityUserDAO activityUserDAO;

	@Override
	public PageHolder<ActivityUser> findAllActivityUser(Map<String, Object> parameter, int pageIndex, int pageSize) {
		return activityUserDAO.findAllActivityUser(parameter, pageIndex, pageSize);
	}

	@Override
	public int batchInsert(List<ActivityUser> list) {
		return activityUserDAO.batchInsert(list);
	}

	@Override
	public List<ActivityUser> findListActivityUser(Map<String, Object> map) {
		return activityUserDAO.findListActivityUser(map);
	}

	@Override
	public int updateStatus(Map<String, Object> map) {
		return activityUserDAO.updateStatus(map);
	}

}
