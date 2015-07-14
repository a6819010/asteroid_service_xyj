package com.youguu.asteroid.activity.dao;

import java.util.List;
import java.util.Map;

import com.youguu.asteroid.activity.pojo.ActivityUser;
import com.youguu.core.util.PageHolder;

/**
 * 
* @Title: IActivityUser.java
* @Package com.youguu.asteroid.activity.dao
* @Description: 活动用户DAO
* @author 徐云杰
* @date 2015年3月9日 下午12:00:23
* @version V1.0
 */
public interface IActivityUserDAO {
	
	/**
	 * 
	* @Title: findAllActivityUser
	* @Description: 分页查询活动用户信息
	* @param parameter
	* @param pageIndex
	* @param pageSize
	* @return    
	* PageHolder<ActivityUser>    返回类型
	* @throws
	 */
	public PageHolder<ActivityUser> findAllActivityUser(Map<String, Object> parameter, int pageIndex, int pageSize);
	
	/**
	 * 
	* @Title: batchInsert
	* @Description: 批量插入
	* @param list
	* @return    
	* int    返回类型
	* @throws
	 */
	public int batchInsert(List<ActivityUser> list);
	
	/**
	 * 
	* @Title: findListActivityUser
	* @Description: 查询活动用户信息List
	* @param map
	* @return    
	* List<ActivityUser>    返回类型
	* @throws
	 */
	public List<ActivityUser> findListActivityUser(Map<String,Object> map);
	
	/**
	 * 
	* @Title: updateStatus
	* @Description: 修改状态
	* @param map
	* @return    
	* int    返回类型
	* @throws
	 */
	public int updateStatus(Map<String,Object> map);

}
