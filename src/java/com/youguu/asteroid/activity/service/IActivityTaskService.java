package com.youguu.asteroid.activity.service;

import com.youguu.asteroid.activity.pojo.ActivityTask;

/**
 * 
* @Title: IActivityTaskService.java
* @Package com.youguu.asteroid.activity.service
* @Description: 活动任务Service接口
* @author 徐云杰
* @date 2015年3月9日 下午1:33:42
* @version V1.0
 */
public interface IActivityTaskService {
	
	/**
	 * 
	* @Title: findActivityTask
	* @Description: 查询活动
	* @param int
	* @return    
	* ActivityTask    返回类型
	* @throws
	 */
	public ActivityTask findActivityTask(int id);

}
