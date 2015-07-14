package com.youguu.asteroid.wxgift.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.youguu.asteroid.wxgift.dao.AllocateDAO;
import com.youguu.asteroid.wxgift.dao.WxgiftSqlDAO;
import com.youguu.asteroid.wxgift.pojo.Allocate;
@Repository("allocateDAO")
public class AllocateDAOImpl extends WxgiftSqlDAO<Allocate> implements AllocateDAO {

	@Override
	public Allocate getNextAllocate() {
		return this.findUniqueBy("getNextAllocate", null);
	}

	@Override
	public int sucAllocateStatus(int id,String openid) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("openid", openid);
		map.put("id", id);
		return this.updateBy("updateStatus", map);
	}

}
