package com.youguu.asteroid.windvane.pojo;

import java.util.Date;

/**
* @Title: MqSystemNotice.java 
* @Package com.youguu.asteroid.windvane.pojo 
* @Description: 市场风向标MQ内容bean，发送系统通知 
* @author 徐云杰
* @date 2014年12月5日 上午10:51:42 
* @version V1.0
 */
public class MqSystemNotice {

	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 用户ID，int数组
	 */
	private int [] toUids;
	
	/**
	 * 消息类型，系统类型为2
	 */
	private int type;
	
	/**
	 * 消息内容
	 */
	private String msg;
	
	/**
	 * 发送时间
	 */
	private Date ctime;
	
	public MqSystemNotice() {
	}
	
	public MqSystemNotice(String title, int[] toUids, int type, String msg,
			Date ctime) {
		this.title = title;
		this.toUids = toUids;
		this.type = type;
		this.msg = msg;
		this.ctime = ctime;
	}



	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int[] getToUids() {
		return toUids;
	}
	public void setToUids(int[] toUids) {
		this.toUids = toUids;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	
}
