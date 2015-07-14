package com.youguu.asteroid.activity.dao;

import java.util.List;

import com.youguu.asteroid.activity.pojo.ActivityUserAwardDetail;

/**
 * 
* @Title: IActivityUserAwardDetail.java
* @Package com.youguu.asteroid.activity.dao
* @Description: 用户抽奖明细DAO
* @author 徐云杰
* @date 2015年3月9日 下午12:00:59
* @version V1.0
 */
public interface IActivityUserAwardDetailDAO {
	
	/**
	 * 
	* @Title: batchInsert
	* @Description:批量插入
	* @param list
	* @return    
	* int    返回类型
	* @throws
	 */
	public int batchInsert(List<ActivityUserAwardDetail> list);
	
	/**
	 * 
	* @Title: updateStatus
	* @Description:修改状态
	* @param id
	* @return    
	* int    返回类型
	* @throws
	 */
	public int updateStatus(int id);
	
	/**
	 * 
	* @Title: findDetail
	* @Description:查询还未使用的抽奖
	* @return    
	* ActivityUserAwardDetail    返回类型
	* @throws
	 */
	public ActivityUserAwardDetail findDetail(int userId);

}
