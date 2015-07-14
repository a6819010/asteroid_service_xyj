package com.youguu.asteroid.activity.pojo;

import java.io.Serializable;

/**
 * 
* @Title: ActivityUserAwardNum.java
* @Package com.youguu.asteroid.activity
* @Description: 用户抽奖总次数
* @author 徐云杰
* @date 2015年3月9日 上午11:38:32
* @version V1.0
 */
public class ActivityUserAwardNum implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户ID
	 */
	private int userId;
	
	/**
	 * 用户昵称
	 */
	private String nickName;
	
	/**
	 * 抽奖总次数
	 */
	private int awardTotal;
	
	public ActivityUserAwardNum() {
	}
	
	public ActivityUserAwardNum(int userId, String nickName, int awardTotal) {
		this.userId = userId;
		this.nickName = nickName;
		this.awardTotal = awardTotal;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getAwardTotal() {
		return awardTotal;
	}

	public void setAwardTotal(int awardTotal) {
		this.awardTotal = awardTotal;
	}

}
