package com.youguu.asteroid.wxgift.pojo;

import java.util.Date;

/**
 * 
* @Title: Openlog.java 
* @Package com.youguu.asteroid.wxgift.pojo 
* @Description: 红包拆开记录
* @author wangd
* @date 2015年2月7日 下午1:50:40 
* @version V1.0
 */
public class Openlog {
	
	/**
	 * 分享用户
	 */
	private String openid;
	
	/**
	 * 打开用户
	 */
	private String hopenid;
	
	/**
	 * 创建时间
	 */
	private Date ctime;
	
	/**
	 * 第几个用户
	 */
	private int num;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getHopenid() {
		return hopenid;
	}

	public void setHopenid(String hopenid) {
		this.hopenid = hopenid;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
	
}
