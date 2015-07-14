package com.youguu.asteroid.windvane.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.youguu.asteroid.windvane.dao.IUserVoteDetailDAO;
import com.youguu.asteroid.windvane.dao.WindVaneSqlDAO;
import com.youguu.asteroid.windvane.pojo.UserVoteDetail;
import com.youguu.core.util.PageHolder;

/**
* @Title: UserVoteDetailDAOImpl.java 
* @Package com.youguu.asteroid.windvane.dao.impl 
* @Description: 用户投票明细DAO接口实现类
* @author 徐云杰
* @date 2014年12月1日 上午11:38:21 
* @version V1.0
 */
@Repository("userVoteDetailDAO")
public class UserVoteDetailDAOImpl extends WindVaneSqlDAO<UserVoteDetail> implements
		IUserVoteDetailDAO {
	
	@Override
	public int insert(UserVoteDetail o) {
		return super.insert(o);
	}
	
	@Override
	public int update(UserVoteDetail o) {
		return super.update(o);
	}

	@Override
	public int delete(String date,int uid) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("date", date);
		map.put("uid", uid);
		return super.deleteBy("delete", map);
	}

	@Override
	public UserVoteDetail selectUserVoteDetail(String date,int uid) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("date", date);
		map.put("uid", uid);
		return super.findUniqueBy("selectUserVoteDetail", map);
	}

	@Override
	public PageHolder<UserVoteDetail> findAllUserVoteDetail(String date,int startIndex,int endIndex) {
		return super.rawPagedQuery("findAllUserVoteDetail", date, startIndex, endIndex, false);
	}

	@Override
	public int truncateAll(String date) {
		return super.deleteBy("truncateAll", date);
	}

}
