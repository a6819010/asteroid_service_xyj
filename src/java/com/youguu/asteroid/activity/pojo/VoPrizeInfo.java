package com.youguu.asteroid.activity.pojo;

/**
 * 
* @Title: VoPrizeInfo.java
* @Package com.youguu.asteroid.activity.pojo
* @Description: 生成奖品池PO，业务传递用
* @author 徐云杰
* @date 2015年3月10日 下午6:21:27
* @version V1.0
 */
public class VoPrizeInfo {
	
	/**
	 * 奖品ID
	 */
	private int prizeId;
	
	/**
	 * 任务ID
	 */
	private int taskId;
	
	/**
	 * 生成数量
	 */
	private int num;
	
	public VoPrizeInfo() {
	}

	public VoPrizeInfo(int prizeId, int taskId, int num) {
		this.prizeId = prizeId;
		this.taskId = taskId;
		this.num = num;
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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
