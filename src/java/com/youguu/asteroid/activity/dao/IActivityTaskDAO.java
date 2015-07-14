package com.youguu.asteroid.activity.dao;

import com.youguu.asteroid.activity.pojo.ActivityTask;

/**
 * 
* @Title: IActivityTaskDAO.java
* @Package com.youguu.asteroid.activity.dao
* @Description: 活动任务DAO
* @author 徐云杰
* @date 2015年3月9日 上午11:59:52
* @version V1.0
 */
public interface IActivityTaskDAO {
	
	/**
	 * 
	* @Title: findActivityTask
	* @Description: 查询活动
	* @param map
	* @return    
	* List<ActivityTask>    返回类型
	* @throws
	 */
	public ActivityTask findActivityTask(int id);
}
