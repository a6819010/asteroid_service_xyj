package com.youguu.asteroid.activity.pojo;

import java.io.Serializable;

/**
 * 
* @Title: ActivityPrize.java
* @Package com.youguu.asteroid.activity
* @Description:奖品
* @author 徐云杰
* @date 2015年3月9日 上午10:57:49
* @version V1.0
 */
public class ActivityPrize implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 奖品ID
	 */
	private int id;
	
	/**
	 * 奖品名称
	 */
	private String name;
	
	/**
	 * 奖品价值
	 */
	private int prizeValue;
	
	/**
	 * 奖品类型：1:实物   2:优顾炒股道具(兑换码)
	 */
	private int prizeType;
	
	public ActivityPrize() {
	}

	public ActivityPrize(String name, int prizeValue, int prizeType) {
		this.name = name;
		this.prizeValue = prizeValue;
		this.prizeType = prizeType;
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

	public int getPrizeValue() {
		return prizeValue;
	}

	public void setPrizeValue(int prizeValue) {
		this.prizeValue = prizeValue;
	}

	public int getPrizeType() {
		return prizeType;
	}

	public void setPrizeType(int prizeType) {
		this.prizeType = prizeType;
	}
	
}
