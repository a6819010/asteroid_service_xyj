package com.youguu.asteroid.windvane.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.youguu.asteroid.windvane.dao.IUserVoteDetailDAO;
import com.youguu.asteroid.windvane.pojo.UserVoteDetail;
import com.youguu.asteroid.windvane.service.IUserVoteDetailService;
import com.youguu.core.util.PageHolder;

/**
* @Title: UserVoteDetailServiceImpl.java 
* @Package com.youguu.asteroid.windvane.service.impl 
* @Description:  用户投票明细历史Service接口实现类
* @author 徐云杰
* @date 2014年12月1日 上午11:42:17 
* @version V1.0
 */
@Service("userVoteDetailService")
public class UserVoteDetailServiceImpl implements IUserVoteDetailService {
	
	@Resource
	private IUserVoteDetailDAO userVoteDetailDAO;

	@Override
	public int addUserVoteDetail(UserVoteDetail userVoteDetail) {
		return userVoteDetailDAO.insert(userVoteDetail);
	}

	@Override
	public int updateUserVoteDetail(UserVoteDetail userVoteDetail) {
		return userVoteDetailDAO.update(userVoteDetail);
	}

	@Override
	public int deleteUserVoteDetail(String date,int uid) {
		return userVoteDetailDAO.delete(date,uid);
	}

	@Override
	public UserVoteDetail getUserVoteDetail(String date,int uid) {
		return userVoteDetailDAO.selectUserVoteDetail(date,uid);
	}

	@Override
	public PageHolder<UserVoteDetail> findAllUserVoteDetail(String date,int startIndex,int endIndex) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("date", date);
		map.put("startIndex", startIndex);
		map.put("endIndex", endIndex);
		return userVoteDetailDAO.findAllUserVoteDetail(date,startIndex,endIndex);
	}

	@Override
	public int truncateAll(String date) {
		return userVoteDetailDAO.truncateAll(date);
	}

}
