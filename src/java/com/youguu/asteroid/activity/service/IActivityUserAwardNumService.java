package com.youguu.asteroid.activity.service;

import java.util.Map;

import com.youguu.asteroid.activity.pojo.ActivityUserAwardNum;
import com.youguu.core.util.PageHolder;

/**
 * 
* @Title: IActivityUserAwardNumService.java
* @Package com.youguu.asteroid.activity.service
* @Description:用户抽奖明细Service接口
* @author 徐云杰
* @date 2015年3月9日 下午1:35:32
* @version V1.0
 */
public interface IActivityUserAwardNumService {
	
	/**
	 * 
	* @Title: addActivityUserAwardNum
	* @Description: 新增
	* @param activityUserAwardNum
	* @return    
	* int    返回类型
	* @throws
	 */
	public int addActivityUserAwardNum(ActivityUserAwardNum activityUserAwardNum);
	
	/**
	 * 
	* @Title: getUserAwardNum
	* @Description: 根据userId获取抽奖总次数
	* @param userId
	* @return    
	* ActivityUserAwardNum    返回类型
	* @throws
	 */
	public ActivityUserAwardNum getUserAwardNum(int userId);
	
	/**
	 * 
	* @Title: updateNum
	* @Description: 修改抽奖总次数
	* @param userId
	* @return    
	* int    返回类型
	* @throws
	 */
	public int updateNum(int userId);
	
	/**
	 * 
	* @Title: updateAddNum
	* @Description: 增加抽奖总次数
	* @param map
	* @return    
	* int    返回类型
	* @throws
	 */
	public int updateAddNum(Map<String,Object> map);
	
	/**
	 * 
	* @Title: findAllUserAwardNum
	* @Description: 查询
	* @param parameter
	* @param pageIndex
	* @param pageSize
	* @return    
	* PageHolder<ActivityUserAwardNum>    返回类型
	* @throws
	 */
	public PageHolder<ActivityUserAwardNum> findAllUserAwardNum(Map<String, Object> parameter, int pageIndex, int pageSize);

}
