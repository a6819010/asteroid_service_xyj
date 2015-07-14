package com.youguu.asteroid.wxgift.dao;

import com.youguu.asteroid.wxgift.pojo.Openlog;

public interface OpenlogDAO {
	/**
	 * 获取是否已经拆分
	 * @param openid
	 * @param hopenid
	 * @return
	 */
	Openlog getOpenlog(String openid,String hopenid);
	
	/**
	 * 保存拆包记录
	 * @param openid
	 * @param hopenid
	 * @param num
	 * @return
	 */
	int saveOpenlog(String openid,String hopenid,int num);
}
