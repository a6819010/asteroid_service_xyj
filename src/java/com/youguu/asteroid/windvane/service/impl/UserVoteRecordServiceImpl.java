package com.youguu.asteroid.windvane.service.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.youguu.asteroid.windvane.dao.IUserVoteRecordDAO;
import com.youguu.asteroid.windvane.pojo.UserVoteRecord;
import com.youguu.asteroid.windvane.service.IUserVoteRecordService;
import com.youguu.core.util.PageHolder;

/**
* @Title: UserVoteRecordServiceImpl.java 
* @Package com.youguu.asteroid.windvane.service.impl 
* @Description:  用户投票记录Service接口实现类
* @author 徐云杰
* @date 2014年12月1日 上午11:42:53 
* @version V1.0
 */
@Service("userVoteRecordService")
public class UserVoteRecordServiceImpl implements IUserVoteRecordService {
	
	@Resource
	private IUserVoteRecordDAO userVoteRecordDAO;

	@Override
	public int addUserVoteRecord(UserVoteRecord userVoteRecord) {
		return userVoteRecordDAO.insert(userVoteRecord);
	}

	@Override
	public int updateUserVoteRecord(UserVoteRecord userVoteRecord) {
		return userVoteRecordDAO.update(userVoteRecord);
	}

	@Override
	public int deleteUserVoteRecord(int uid) {
		return userVoteRecordDAO.delete(uid);
	}

	@Override
	public UserVoteRecord getUserVoteRecord(int uid) {
		return userVoteRecordDAO.selectUserVoteRecord(uid);
	}

	@Override
	public PageHolder<UserVoteRecord> findAllUserVoteRecord(
			Map<String, Object> parameter, int pageIndex, int pageSize) {
		return userVoteRecordDAO.findAllUserVoteRecord(parameter, pageIndex, pageSize);
	}

}
