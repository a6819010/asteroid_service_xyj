package com.youguu.asteroid.windvane.dao;

import java.util.Map;

import com.youguu.asteroid.windvane.pojo.UserVoteRecord;
import com.youguu.core.util.PageHolder;

/**
 * 
* @Title: IUserVoteRecordDAO.java 
* @Package com.youguu.asteroid.windvane.dao 
* @Description: 用户投票记录DAO接口
* @author 徐云杰
* @date 2014年12月1日 上午11:31:24 
* @version V1.0
 */
public interface IUserVoteRecordDAO {

	/**
	 * @Title: 新增
	 * @Description: 
	 * @param userVoteRecord
	 * @return int
	 * @throws
	 */
	public int insert(UserVoteRecord userVoteRecord);

	/**
	 * 
	 * @Title: 修改
	 * @Description: 
	 * @param userVoteRecord
	 * @return int
	 * @throws
	 */
	public int update(UserVoteRecord userVoteRecord);
	
	/**
	 * @Title: 删除
	 * @Description: 
	 * @param userVoteRecord
	 * @return int
	 * @throws
	 */
	public int delete(int uid);
	
	/**
	 * @Title: 查询
	 * @Description: 根据uid查询
	 * @param int uid
	 * @return UserVoteRecord
	 * @throws
	 */
	public UserVoteRecord selectUserVoteRecord(int uid);

	/**
	 * @Title: 分页查询
	 * @Description: 
	 * @param Map<String, Object> parameter, int pageIndex, int pageSize
	 * @return PageHolder<UserVoteRecord>
	 * @throws
	 */
	public PageHolder<UserVoteRecord> findAllUserVoteRecord(Map<String, Object> parameter, int pageIndex, int pageSize);
	
	

}
