package com.youguu.asteroid.wxgift.pojo;

import java.util.Date;

/**
 * 
* @Title: UserInfo.java 
* @Package com.youguu.asteroid.wxgift.pojo 
* @Description: 用户分享记录
* @author wangd
* @date 2015年2月7日 下午2:00:34 
* @version V1.0
 */
public class UserInfo {
	
	/**
	 * 分享的用户
	 */
	private String openid;
	/**
	 * 打开数量
	 */
	private int num;
	/**
	 * 奖品类型
	 */
	private int type;
	/**
	 * 兑换码
	 */
	private String cdkey;
	
	/**
	 * 创建时间
	 */
	private Date ctime;
	
	/**
	 * 修改时间
	 */
	private Date utime;
	
	/**
	 * 手机号码
	 */
	private String phone;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
