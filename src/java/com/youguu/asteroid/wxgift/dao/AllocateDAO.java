package com.youguu.asteroid.wxgift.dao;

import com.youguu.asteroid.wxgift.pojo.Allocate;

public interface AllocateDAO {
	/**
	 * 获取奖励
	 * @return
	 */
	Allocate getNextAllocate();
	
	/**
	 * 修改奖品的状态
	 * @return
	 */
	int sucAllocateStatus(int id,String openid);
}
