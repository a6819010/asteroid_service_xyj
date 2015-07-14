package com.youguu.asteroid.activity.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.youguu.asteroid.activity.dao.IActivityPrizeDAO;
import com.youguu.asteroid.activity.pojo.ActivityPrize;
import com.youguu.asteroid.activity.service.IActivityPrizeService;
import com.youguu.core.util.PageHolder;

/**
 * 
* @Title: ActivityPrizeServiceImpl.java
* @Package com.youguu.asteroid.activity.service.impl
* @Description: 奖品Service接口实现类
* @author 徐云杰
* @date 2015年3月9日 下午1:38:26
* @version V1.0
 */
@Service("activityPrizeService")
public class ActivityPrizeServiceImpl implements IActivityPrizeService {
	
	@Resource
	private IActivityPrizeDAO activityPrizeDAO;

	@Override
	public int addActivityPrize(ActivityPrize ap) {
		return activityPrizeDAO.addActivityPrize(ap);
	}

	@Override
	public PageHolder<ActivityPrize> findAllActivityPrize(Map<String, Object> parameter, int pageIndex, int pageSize) {
		return activityPrizeDAO.findAllActivityPrize(parameter, pageIndex, pageSize);
	}

	@Override
	public ActivityPrize findActivityPrizeById(int id) {
		return activityPrizeDAO.findActivityPrizeById(id);
	}

	@Override
	public int delActivityPrize(int id) {
		return activityPrizeDAO.delActivityPrize(id);
	}

}
