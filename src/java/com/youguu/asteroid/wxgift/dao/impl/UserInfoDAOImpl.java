package com.youguu.asteroid.wxgift.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.youguu.asteroid.wxgift.dao.UserInfoDAO;
import com.youguu.asteroid.wxgift.dao.WxgiftSqlDAO;
import com.youguu.asteroid.wxgift.pojo.UserInfo;
@Repository("userInfoDAO")
public class UserInfoDAOImpl extends WxgiftSqlDAO<UserInfo> implements UserInfoDAO {

	@Override
	public int saveUserInfo(String openid) {
		UserInfo ui = new UserInfo();
		ui.setOpenid(openid);
		ui.setNum(1);
		return this.insert(ui);
	}

	@Override
	public UserInfo getUserInfo(String openid) {
		return this.get(openid);
	}

	@Override
	public int incOpenNum(String openid, int num) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("openid", openid);
		map.put("num", num);
		map.put("utime", new Date());
		return this.updateBy("incOpenNum", map);
	}

	@Override
	public int updateAllocate(String openid, int type, String cdkey) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("openid", openid);
		map.put("type", type);
		map.put("cdkey", cdkey);
		map.put("utime", new Date());
		return this.updateBy("updateAllocate", map);
	}

	@Override
	public int updateUserPhone(String openid, String phone) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("openid", openid);
		map.put("phone", phone);
		map.put("utime", new Date());
		return this.updateBy("updateUserPhone", map);
	}

}
