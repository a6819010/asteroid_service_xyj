package com.youguu.asteroid.windvane.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.youguu.asteroid.windvane.dao.IUserVoteDetailHisDAO;
import com.youguu.asteroid.windvane.dao.WindVaneSqlDAO;
import com.youguu.asteroid.windvane.pojo.UserVoteDetailHis;
import com.youguu.core.util.PageHolder;

/**
* @Title: UserVoteDetailHisDAOImpl.java 
* @Package com.youguu.asteroid.windvane.dao.impl 
* @Description: 用户投票明细历史DAO接口实现类
* @author 徐云杰
* @date 2014年12月1日 上午11:38:43 
* @version V1.0
 */
@Repository("userVoteDetailHisDAO")
public class UserVoteDetailHisDAOImpl extends WindVaneSqlDAO<UserVoteDetailHis> implements
		IUserVoteDetailHisDAO {
	
	@Override
	public int insert(UserVoteDetailHis o) {
		return super.insert(o);
	}
	
	@Override
	public int update(UserVoteDetailHis o) {
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
	public int batchInsert(List<UserVoteDetailHis> list) {
		return super.batchInsert(list, "insertList");
	}

	@Override
	public UserVoteDetailHis selectUserVoteDetailHis(String date,int uid) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("date", date);
		map.put("uid", uid);
		return super.findUniqueBy("selectUserVoteDetailHis", map);
	}

	@Override
	public PageHolder<UserVoteDetailHis> findAllUserVoteDetailHis(
			Map<String, Object> parameter, int pageIndex, int pageSize) {
		return super.pagedQuery("findAllUserVoteDetailHis", parameter, pageIndex, pageSize);
	}

}
