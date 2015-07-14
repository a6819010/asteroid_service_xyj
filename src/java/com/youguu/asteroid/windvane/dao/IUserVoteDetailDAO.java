package com.youguu.asteroid.windvane.dao;

import java.util.List;
import java.util.Map;

import com.youguu.asteroid.windvane.pojo.UserVoteDetail;
import com.youguu.core.util.PageHolder;

/**
 * 
* @Title: IUserVoteDetailDAO.java 
* @Package com.youguu.asteroid.windvane.dao 
* @Description: 用户投票明细DAO接口
* @author 徐云杰
* @date 2014年12月1日 上午11:37:06 
* @version V1.0
 */
public interface IUserVoteDetailDAO {

	/**
	 * @Title: 新增
	 * @Description: 
	 * @param userVoteDetail
	 * @return int
	 * @throws
	 */
	public int insert(UserVoteDetail userVoteDetail);

	/**
	 * 
	 * @Title: 修改
	 * @Description: 
	 * @param userVoteDetail
	 * @return int
	 * @throws
	 */
	public int update(UserVoteDetail userVoteDetail);

	/**
	 * @Title: 删除
	 * @Description: 
	 * @param userVoteDetail
	 * @return int
	 * @throws
	 */
	public int delete(String date,int uid);
	
	/**
	 * @Title: 删除全部数据
	 * @Description: 
	 * @param 
	 * @return int
	 * @throws
	 */
	public int truncateAll(String date);
	
	/**
	 * @Title: 查询
	 * @Description: 根据参数对象中的date以及uid查询
	 * @param userVoteDetail
	 * @return UserVoteDetail
	 * @throws
	 */
	public UserVoteDetail selectUserVoteDetail(String date,int uid);

	/**
	 * @Title: 查询全部
	 * @Description: 
	 * @param 
	 * @return List<UserVoteDetail>
	 * @throws
	 */
	public PageHolder<UserVoteDetail> findAllUserVoteDetail(String date,int startIndex,int endIndex);

}
