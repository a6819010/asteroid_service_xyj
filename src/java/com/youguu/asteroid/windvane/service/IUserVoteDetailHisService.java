package com.youguu.asteroid.windvane.service;

import java.util.List;
import java.util.Map;

import com.youguu.asteroid.windvane.pojo.UserVoteDetailHis;
import com.youguu.core.util.PageHolder;

/**
* @Title: IUserVoteDetailHisService.java 
* @Package com.youguu.asteroid.windvane.service 
* @Description: 用户投票明细Service接口
* @author 徐云杰
* @date 2014年12月1日 上午11:41:10 
* @version V1.0
 */
public interface IUserVoteDetailHisService {

	/**
	 * @Title: 新增
	 * @Description: 
	 * @param userVoteDetailHis
	 * @return int
	 * @throws
	 */
	public int addUserVoteDetailHis(UserVoteDetailHis userVoteDetailHis);
	
	/**
	 * @Title: 批量新增
	 * @Description: 
	 * @param List<UserVoteDetailHis>
	 * @return int
	 * @throws
	 */
	public int batchInsert(List<UserVoteDetailHis> list);

	/**
	 * 
	 * @Title: 修改
	 * @Description: 
	 * @param userVoteDetailHis
	 * @return int
	 * @throws
	 */
	public int updateUserVoteDetailHis(UserVoteDetailHis userVoteDetailHis);

	/**
	 * @Title: 删除
	 * @Description: 
	 * @param userVoteDetailHis
	 * @return int
	 * @throws
	 */
	public int deleteUserVoteDetailHis(String date,int uid);
	
	/**
	 * @Title: 查询
	 * @Description: 根据参数对象中的date以及uid查询
	 * @param UserVoteDetailHis
	 * @return UserVoteDetailHis
	 * @throws
	 */
	public UserVoteDetailHis getUserVoteDetailHis(String date,int uid);

	/**
	 * @Title: 分页查询
	 * @Description: 
	 * @param 
	 * @return PageHolder<UserVoteDetailHis>
	 * @throws
	 */
	public PageHolder<UserVoteDetailHis> findAllUserVoteDetailHis(Map<String, Object> parameter, int pageIndex, int pageSize);

}
