package com.youguu.asteroid.windvane.pojo;

import java.io.Serializable;

/**
 * 
* @Title: UserVoteRecord.java 
* @Package com.youguu.asteroid.windvane.pojo 
* @Description: 用户投票记录
* @author 徐云杰
* @date 2014年12月1日 上午11:33:13 
* @version V1.0
 */
public class UserVoteRecord implements Serializable  {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	private int uid;
	
	/**
	 * 投票次数
	 */
	private int num;
	
	/**
	 * 投涨次数
	 */
	private int up;
	
	/**
	 * 投跌次数
	 */
	private int down;
	
	/**
	 * 投票正确次数
	 */
	private int rights;

	public UserVoteRecord() {
	}

	public UserVoteRecord(int uid, int num, int up, int down, int rights) {
		this.uid = uid;
		this.num = num;
		this.up = up;
		this.down = down;
		this.rights = rights;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getUp() {
		return up;
	}

	public void setUp(int up) {
		this.up = up;
	}

	public int getDown() {
		return down;
	}

	public void setDown(int down) {
		this.down = down;
	}

	public int getRight() {
		return rights;
	}

	public void setRight(int rights) {
		this.rights = rights;
	}

}
