package com.youguu.asteroid.wxgift.service;

import com.alibaba.fastjson.JSONObject;

/**
 * 
* @Title: IWcgiftService.java 
* @Package com.youguu.asteroid.wxgift.service 
* @Description: 拆红包活动
* @author wangd
* @date 2015年2月9日 下午3:26:13 
* @version V1.0
 */
public interface IWxgiftService {
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
