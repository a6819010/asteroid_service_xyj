package com.youguu.asteroid.windvane.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
* @Title: UserVoteDetailHis.java 
* @Package com.youguu.asteroid.windvane.pojo 
* @Description:用户投票明细历史
* @author 徐云杰
* @date 2014年12月1日 上午11:32:44 
* @version V1.0
 */
public class UserVoteDetailHis implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
	private int uid;
	
	/**
	 * 创建时间
	 */
	private Date ctime;
	
	/**
	 * 历史投票时间
	 */
	private String date;
	
	/**
	 * 1：涨 2：跌
	 */
	private int type;

	public UserVoteDetailHis() {
	}

	public UserVoteDetailHis(int uid, Date ctime, String date, int type) {
		this.uid = uid;
		this.ctime = ctime;
		this.date = date;
		this.type = type;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
