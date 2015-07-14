package com.youguu.asteroid.activity.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.youguu.asteroid.activity.dao.IActivityUserAwardDetailDAO;
import com.youguu.asteroid.activity.pojo.ActivityUserAwardDetail;
import com.youguu.asteroid.activity.service.IActivityUserAwardDetailService;

/**
 * 
* @Title: ActivityUserAwardDetailServiceImpl.java
* @Package com.youguu.asteroid.activity.service.impl
* @Description:用户抽奖明细Service接口实现类
* @author 徐云杰
* @date 2015年3月9日 下午1:41:56
* @version V1.0
 */
@Service("activityUserAwardDetailService")
public class ActivityUserAwardDetailServiceImpl implements IActivityUserAwardDetailService{
	
	@Resource
	private IActivityUserAwardDetailDAO activityUserAwardDetailDAO;

	@Override
	public int batchInsert(List<ActivityUserAwardDetail> list) {
		return activityUserAwardDetailDAO.batchInsert(list);
	}

	@Override
	public int updateStatus(int id) {
		return activityUserAwardDetailDAO.updateStatus(id);
	}

	@Override
	public ActivityUserAwardDetail findDetail(int userId) {
		return activityUserAwardDetailDAO.findDetail(userId);
	}

}
