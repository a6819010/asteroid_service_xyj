package com.youguu.asteroid.activity.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
* @Title: ActivityTask.java
* @Package com.youguu.asteroid.activity
* @Description: 活动任务
* @author 徐云杰
* @date 2015年3月9日 上午11:24:48
* @version V1.0
 */
public class ActivityTask implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 东莞券商编号
	 */
	public static int BROKER_ID = 1004;
	
	/**
	 * 任务ID
	 */
	private int id;
	
	/**
	 * 任务名称
	 */
	private String name;
	
	/**
	 * 任务奖励抽奖次数
	 */
	private int awardNum;
	
	/**
	 * 开始时间
	 */
	private Date beginTime;
	
	/**
	 * 结束时间
	 */
	private Date endTime;
	
	/**
	 * 创建时间
	 */
	private Date ctime;
	
	public ActivityTask() {
	}

	public ActivityTask(String name, int awardNum, Date beginTime, Date endTime) {
		this.name = name;
		this.awardNum = awardNum;
		this.beginTime = beginTime;
		this.endTime = endTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAwardNum() {
		return awardNum;
	}

	public void setAwardNum(int awardNum) {
		this.awardNum = awardNum;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

}
