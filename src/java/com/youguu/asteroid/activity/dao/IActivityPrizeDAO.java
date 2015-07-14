package com.youguu.asteroid.activity.dao;

import java.util.Map;

import com.youguu.asteroid.activity.pojo.ActivityPrize;
import com.youguu.core.util.PageHolder;

/**
 * 
* @Title: IActivityPrizeDAO.java
* @Package com.youguu.asteroid.activity.dao
* @Description: 奖品表DAO
* @author 徐云杰
* @date 2015年3月9日 上午11:58:02
* @version V1.0
 */
public interface IActivityPrizeDAO {
	
	/**
	 * 
	* @Title: addActivityPrize
	* @Description: 新增奖品
	* @param ap
	* @return    
	* int    返回类型
	* @throws
	 */
	public int addActivityPrize(ActivityPrize ap);
	
	/**
	 * 
	* @Title: delActivityPrize
	* @Description: 删除奖品
	* @param id
	* @return    
	* int    返回类型
	* @throws
	 */
	public int delActivityPrize(int id);
	
	/**
	 * 
	* @Title: findActivityPrizeById
	* @Description:根据ID查询奖品
	* @param id
	* @return    
	* ActivityPrize    返回类型
	* @throws
	 */
	public ActivityPrize findActivityPrizeById(int id);
	
	/**
	 * 
	* @Title: findAllActivityPrize
	* @Description: 分页查询奖品
	* @param parameter
	* @param pageIndex
	* @param pageSize
	* @return    
	* PageHolder<ActivityPrize>    返回类型
	* @throws
	 */
	public PageHolder<ActivityPrize> findAllActivityPrize(Map<String, Object> parameter, int pageIndex, int pageSize);
}
