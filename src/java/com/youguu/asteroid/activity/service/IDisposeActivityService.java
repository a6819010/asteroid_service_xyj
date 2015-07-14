package com.youguu.asteroid.activity.service;

import java.util.List;
import java.util.Map;

import com.youguu.asteroid.activity.pojo.ActivityPrize;
import com.youguu.asteroid.activity.pojo.ActivityUser;
import com.youguu.asteroid.activity.pojo.ActivityUserAwardNum;
import com.youguu.asteroid.activity.pojo.ActivityUserAwardRecord;
import com.youguu.asteroid.activity.pojo.VoPrizeInfo;
import com.youguu.core.util.PageHolder;

/**
 * 
* @Title: IDisposeActivityService.java
* @Package com.youguu.asteroid.activity.service
* @Description: 客户端,后台业务处理统一调用Service入口
* @author 徐云杰
* @date 2015年3月10日 上午10:22:39
* @version V1.0
 */
public interface IDisposeActivityService {
	
	/**
	 * 
	* @Title: findUserAwardInfo
	* @Description: 加载活动抽奖首页数据
	* @param userId
	* @param ak
	* @return    
	* Map<String,Object>    返回类型
	* @throws
	 */
	public Map<String,Object> findUserAwardInfo(int userId);
	
	/**
	 * 
	* @Title: findUserAwardRecord
	* @Description: 查询用户中奖记录
	* @param userId
	* @return    
	* Map<String,Object>    返回类型
	* @throws
	 */
	public Map<String,Object> findUserAwardRecord(int userId);
	
	/**
	 * 
	* @Title: clickLottery
	* @Description: 点击抽奖
	* @param userId
	* @return    
	* Map<String,Object>    返回类型
	* @throws
	 */
	public Map<String,Object> clickLottery(int userId)throws Exception;
	
	/**
	 * 
	* @Title: getAward
	* @Description: 获取奖励
	* @param poolId
	* @param userId
	* @param prizeId
	* @param phone
	* @return    
	* Map<String,Object>    返回类型
	* @throws
	 */
	public Map<String,Object> getAward(int poolId,String phone,int userId)throws Exception;
	
	/**
	 * 
	* @Title: createPrizePool
	* @Description: 生成奖品池
	* @param list
	* @param batchNum
	* @return    
	* int    返回类型
	* @throws
	 */
	public int createPrizePool(List<VoPrizeInfo> list,int batchNum);
	
	/**
	 * 
	* @Title: createBigPrize
	* @Description: 生成大奖
	* @param vpi
	* @return    
	* int    返回类型
	* @throws
	 */
	public int createBigPrize(VoPrizeInfo vpi)throws Exception;
	
	/**
	 * 
	* @Title: comparisonData
	* @Description: 比对数据
	* @return    
	* int    返回类型
	* @throws
	 */
	public int comparisonData()throws Exception;
	
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
	
	/**
	 * 
	* @Title: batchInsert
	* @Description: 批量插入
	* @param list
	* @return    
	* int    返回类型
	* @throws
	 */
	public int batchInsertActivityUser(List<ActivityUser> list);
	
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
	* @Title: findAllActivityUserAwardRecord
	* @Description: 分页查询领取记录
	* @param parameter
	* @param pageIndex
	* @param pageSize
	* @return    
	* PageHolder<ActivityUserAwardRecord>    返回类型
	* @throws
	 */
	public PageHolder<ActivityUserAwardRecord> findAllActivityUserAwardRecord(Map<String, Object> parameter, int pageIndex, int pageSize);
	
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
	* @Title: updateUserAwardRecordStatus
	* @Description: 修改用户奖品记录信息
	* @param map
	* @return    
	* int    返回类型
	* @throws
	 */
	public int updateUserAwardRecordStatus(int pooId,int status);
}
