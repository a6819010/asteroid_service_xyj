package com.youguu.asteroid.windvane.pojo;

/**
* @Title: MqVote.java 
* @Package com.youguu.asteroid.windvane.pojo 
* @Description: MQ消息内容,市场风向标统计投票用
* @author 徐云杰
* @date 2014年12月3日 下午2:32:25 
* @version V1.0
 */
public class MqVote {
	
	private int uid;
	private String date;
	private int type;
	
	public MqVote() {
		super();
	}

	public MqVote(int uid, String date, int type) {
		this.uid = uid;
		this.date = date;
		this.type = type;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
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
