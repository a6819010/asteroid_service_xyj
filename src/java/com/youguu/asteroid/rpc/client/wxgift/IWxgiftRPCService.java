package com.youguu.asteroid.rpc.client.wxgift;

import com.alibaba.fastjson.JSONObject;

public interface IWxgiftRPCService {
	/**
	 * 获取用户状态
	 * @param openid
	 * @param hopenid
	 * @return
	 */
	JSONObject queryStatus(String openid,String hopenid);
	
	/**
	 * 拆红包
	 * @param openid
	 * @param hopenid
	 * @return
	 */
	int open(String openid,String hopenid);
	
	/**
	 * 保存用户手机号
	 * @param openid
	 * @param phone
	 * @return
	 */
	int phone(String openid,String phone);
}
