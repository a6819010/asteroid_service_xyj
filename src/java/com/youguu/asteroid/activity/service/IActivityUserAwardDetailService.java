package com.youguu.asteroid.activity.service;

import java.util.List;

import com.youguu.asteroid.activity.pojo.ActivityUserAwardDetail;

/**
 * 
* @Title: IActivityUserAwardDetailService.java
* @Package com.youguu.asteroid.activity.service
* @Description: 用户抽奖明细Service接口
* @author 徐云杰
* @date 2015年3月9日 下午1:34:58
* @version V1.0
 */
public interface IActivityUserAwardDetailService {
	
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
	* @Description: 查询还未使用的抽奖
	* @param userId
	* @return    
	* List<ActivityUserAwardDetail>    返回类型
	* @throws
	 */
	public ActivityUserAwardDetail findDetail(int userId);

}
