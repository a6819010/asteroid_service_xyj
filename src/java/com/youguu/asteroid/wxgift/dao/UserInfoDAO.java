package com.youguu.asteroid.wxgift.dao;

import com.youguu.asteroid.wxgift.pojo.UserInfo;

public interface UserInfoDAO {
	
	/**
	 * 新增记录
	 * @param openid
	 * @return
	 */
	int saveUserInfo(String openid);
	
	/**
	 * 获取用户记录
	 * @param openid
	 * @return
	 */
	UserInfo getUserInfo(String openid);
	
	/**
	 * 增加打开数
	 * @param num
	 * @return
	 */
	int incOpenNum(String openid,int num);
	
	/**
	 * 分配用户奖励
	 * @param type
	 * @param cdkey
	 * @return
	 */
	int updateAllocate(String openid,int type,String cdkey);
	
	/**
	 * 记录用户电话
	 * @param openid
	 * @param phobe
	 * @return
	 */
	int updateUserPhone(String openid,String phone);
}
