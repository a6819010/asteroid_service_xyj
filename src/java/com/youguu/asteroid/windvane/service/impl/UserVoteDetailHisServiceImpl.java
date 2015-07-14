package com.youguu.asteroid.windvane.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.youguu.asteroid.windvane.dao.IUserVoteDetailHisDAO;
import com.youguu.asteroid.windvane.pojo.UserVoteDetailHis;
import com.youguu.asteroid.windvane.service.IUserVoteDetailHisService;
import com.youguu.core.util.PageHolder;

/**
* @Title: UserVoteDetailHisServiceImpl.java 
* @Package com.youguu.asteroid.windvane.service.impl 
* @Description: 用户投票明细Service接口实现类
* @author 徐云杰
* @date 2014年12月1日 上午11:41:36 
* @version V1.0
 */
@Service("userVoteDetailHisService")
public class UserVoteDetailHisServiceImpl implements IUserVoteDetailHisService {

	@Resource
	private IUserVoteDetailHisDAO userVoteDetailHisDAO;
	
	@Override
	public int addUserVoteDetailHis(UserVoteDetailHis userVoteDetailHis) {
		return userVoteDetailHisDAO.insert(userVoteDetailHis);
	}

	@Override
	public int batchInsert(List<UserVoteDetailHis> list) {
		return userVoteDetailHisDAO.batchInsert(list);
	}

	@Override
	public int updateUserVoteDetailHis(UserVoteDetailHis userVoteDetailHis) {
		return userVoteDetailHisDAO.update(userVoteDetailHis);
	}

	@Override
	public int deleteUserVoteDetailHis(String date,int uid) {
		return userVoteDetailHisDAO.delete(date,uid);
	}

	@Override
	public UserVoteDetailHis getUserVoteDetailHis(String date,int uid) {
		return userVoteDetailHisDAO.selectUserVoteDetailHis(date,uid);
	}

	@Override
	public PageHolder<UserVoteDetailHis> findAllUserVoteDetailHis(
			Map<String, Object> parameter, int pageIndex, int pageSize) {
		return userVoteDetailHisDAO.findAllUserVoteDetailHis(parameter, pageIndex, pageSize);
	}

}
