package com.youguu.asteroid.activity.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
* @Title: ActivityUser.java
* @Package com.youguu.asteroid.activity
* @Description: 活动用户表
* @author 徐云杰
* @date 2015年3月9日 上午11:28:46
* @version V1.0
 */
public class ActivityUser implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * 券商编号
	 */
	private int brokerId;
	
	/**
	 * 客户号
	 */
	private String brokerUserId;
	
	/**
	 * 任务ID
	 */
	private int taskId;
	
	/**
	 * 创建时间
	 */
	private  Date ctime;
	
	public ActivityUser() {
	}

	public ActivityUser(int brokerId, String brokerUserId, int taskId,Date ctime) {
		this.brokerId = brokerId;
		this.brokerUserId = brokerUserId;
		this.taskId = taskId;
		this.ctime = ctime;
	}

	public int getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(int brokerId) {
		this.brokerId = brokerId;
	}

	public String getBrokerUserId() {
		return brokerUserId;
	}

	public void setBrokerUserId(String brokerUserId) {
		this.brokerUserId = brokerUserId;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	
}
