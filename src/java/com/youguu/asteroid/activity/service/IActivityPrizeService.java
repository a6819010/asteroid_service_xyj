package com.youguu.asteroid.activity.service;

import java.util.Map;

import com.youguu.asteroid.activity.pojo.ActivityPrize;
import com.youguu.core.util.PageHolder;

/**
 * 
* @Title: IActivityPrizeService.java
* @Package com.youguu.asteroid.activity.service
* @Description: 奖品Service接口
* @author 徐云杰
* @date 2015年3月9日 下午1:32:22
* @version V1.0
 */
public interface IActivityPrizeService {
	
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
