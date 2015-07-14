package com.youguu.asteroid.activity.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
* @Title: ActivityPrizePool.java
* @Package com.youguu.asteroid.activity
* @Description: 奖品池
* @author 徐云杰
* @date 2015年3月9日 上午11:20:56
* @version V1.0
 */
public class ActivityPrizePool implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 奖池ID
	 */
	private int id;
	
	/**
	 * 奖品ID
	 */
	private int prizeId;
	
	/**
	 * 任务ID
	 */
	private int taskId;
	
	/**
	 * 奖池状态：0：未领取 1：已领取
	 */
	private int status;
	
	/**
	 * 兑换码
	 */
	private String cdkey;
	
	/**
	 * 修改时间
	 */
	private Date mtime;
	
	/**
	 * 创建时间
	 */
	private Date ctime;
	
	/**
	 * 奖品名称
	 */
	private String prizeName;
	
	public ActivityPrizePool() {
	}
	
	public ActivityPrizePool(int prizeId, int taskId, int status,
			String cdkey, Date ctime) {
		this.prizeId = prizeId;
		this.taskId = taskId;
		this.status = status;
		this.cdkey = cdkey;
		this.ctime = ctime;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrizeId() {
		return prizeId;
	}
	public void setPrizeId(int prizeId) {
		this.prizeId = prizeId;
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
	public String getCdkey() {
		return cdkey;
	}
	public void setCdkey(String cdkey) {
		this.cdkey = cdkey;
	}
	public Date getMtime() {
		return mtime;
	}
	public void setMtime(Date mtime) {
		this.mtime = mtime;
	}
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public String getPrizeName() {
		return prizeName;
	}
	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}

}
