package com.youguu.asteroid.windvane.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.youguu.asteroid.windvane.dao.IUserVoteRecordDAO;
import com.youguu.asteroid.windvane.dao.WindVaneSqlDAO;
import com.youguu.asteroid.windvane.pojo.UserVoteRecord;
import com.youguu.core.util.PageHolder;

/**
* @Title: UserVoteRecordDAOImpl.java 
* @Package com.youguu.asteroid.windvane.dao.impl 
* @Description: 用户投票记录DAO接口实现类
* @author 徐云杰
* @date 2014年12月1日 上午11:39:04 
* @version V1.0
 */
@Repository("userVoteRecordDAO")
public class UserVoteRecordDAOImpl extends WindVaneSqlDAO<UserVoteRecord> implements
		IUserVoteRecordDAO {
	
	@Override
	public int insert(UserVoteRecord o) {
		return super.insert(o);
	}
	
	@Override
	public int update(UserVoteRecord o) {
		return super.update(o);
	}

	@Override
	public int delete(int uid) {
		return super.delete(uid);
	}

	@Override
	public UserVoteRecord selectUserVoteRecord(int uid) {
		return super.get(uid);
	}

	@Override
	public PageHolder<UserVoteRecord> findAllUserVoteRecord(
			Map<String, Object> parameter, int pageIndex, int pageSize) {
		return super.pagedQuery("findAllUserVoteRecord", parameter, pageIndex, pageSize);
	}

}
