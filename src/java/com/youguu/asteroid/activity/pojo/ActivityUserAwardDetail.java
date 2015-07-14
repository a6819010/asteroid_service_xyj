package com.youguu.asteroid.activity.pojo;

import java.io.Serializable;

/**
 * 
* @Title: ActivityUserAwardDetail.java
* @Package com.youguu.asteroid.activity
* @Description:用户抽奖明细
* @author 徐云杰
* @date 2015年3月9日 上午11:34:49
* @version V1.0
 */
public class ActivityUserAwardDetail implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	/**
	 * 用户ID
	 */
	private int userId;
	
	/**
	 * 任务ID
	 */
	private int taskId;
	
	/**
	 * 任务状态： 0：未使用  1：使用
	 */
	private int status;
	
	public ActivityUserAwardDetail() {
	}

	public ActivityUserAwardDetail(int userId, int taskId, int status) {
		this.userId = userId;
		this.taskId = taskId;
		this.status = status;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
