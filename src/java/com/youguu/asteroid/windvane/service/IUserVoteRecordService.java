package com.youguu.asteroid.windvane.service;

import java.util.Map;

import com.youguu.asteroid.windvane.pojo.UserVoteRecord;
import com.youguu.core.util.PageHolder;

/**
* @Title: IUserVoteRecordService.java 
* @Package com.youguu.asteroid.windvane.service 
* @Description: 用户投票记录Service接口
* @author 徐云杰
* @date 2014年12月1日 上午11:42:32 
* @version V1.0
 */
public interface IUserVoteRecordService {

	/**
	 * @Title: 新增
	 * @Description: 
	 * @param userVoteRecord
	 * @return int
	 * @throws
	 */
	public int addUserVoteRecord(UserVoteRecord userVoteRecord);

	/**
	 * 
	 * @Title: 修改
	 * @Description: 
	 * @param userVoteRecord
	 * @return int
	 * @throws
	 */
	public int updateUserVoteRecord(UserVoteRecord userVoteRecord);
	
	/**
	 * @Title: 删除
	 * @Description: 
	 * @param userVoteRecord
	 * @return int
	 * @throws
	 */
	public int deleteUserVoteRecord(int uid);
	
	/**
	 * @Title: 查询
	 * @Description: 根据uid查询
	 * @param int uid
	 * @return UserVoteRecord
	 * @throws
	 */
	public UserVoteRecord getUserVoteRecord(int uid);

	/**
	 * @Title: 分页查询
	 * @Description: 
	 * @param Map<String, Object> parameter, int pageIndex, int pageSize
	 * @return PageHolder<UserVoteRecord>
	 * @throws
	 */
	public PageHolder<UserVoteRecord> findAllUserVoteRecord(Map<String, Object> parameter, int pageIndex, int pageSize);
	
	

}
