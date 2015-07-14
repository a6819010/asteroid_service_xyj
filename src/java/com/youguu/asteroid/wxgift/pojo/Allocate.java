package com.youguu.asteroid.wxgift.pojo;

import java.util.Date;

/**
 * 
* @Title: Allocate.java 
* @Package com.youguu.asteroid.wxgift.pojo 
* @Description: 奖品预分配 
* @author wangd
* @date 2015年2月7日 下午1:46:12 
* @version V1.0
 */
public class Allocate {
	private int id;
	
	/**
	 * 奖品类型
	 */
	private int type;
	
	/**
	 * 状态 0 未分配 1已分配
	 */
	private int status;
	
	/**
	 * 道具兑换码
	 */
	private String cdkey;
	
	/**
	 * 可用日期
	 */
	private Date ctime;
	
	/**
	 * 使用时间
	 */
	private Date utime;
	
	/**
	 * 使用的用户
	 */
	private String openid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCdkey() {
		return cdkey;
	}

	public void setCdkey(String cdkey) {
		this.cdkey = cdkey;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public Date getUtime() {
		return utime;
	}

	public void setUtime(Date utime) {
		this.utime = utime;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	
}
