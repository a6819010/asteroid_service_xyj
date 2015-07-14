package com.youguu.asteroid.activity.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.youguu.asteroid.activity.dao.IActivityTaskDAO;
import com.youguu.asteroid.activity.pojo.ActivityTask;
import com.youguu.asteroid.activity.service.IActivityTaskService;

/**
 * 
* @Title: ActivityTaskServiceImpl.java
* @Package com.youguu.asteroid.activity.service.impl
* @Description:  活动任务Service接口实现类
* @author 徐云杰
* @date 2015年3月9日 下午1:39:59
* @version V1.0
 */
@Service("activityTaskService")
public class ActivityTaskServiceImpl implements IActivityTaskService {
	
	@Resource
	private IActivityTaskDAO activityTaskDAO;

	@Override
	public ActivityTask findActivityTask(int id) {
		return activityTaskDAO.findActivityTask(id);
	}

}
