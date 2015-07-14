package com.youguu.asteroid.tool.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @ClassName: ForeignCurrency
 * @Description: 外汇汇率表
 * @author shilei
 * @date 2014年10月21日 上午9:56:15
 *
 */
public class ForeignCurrency implements Serializable{
	private int id;
	private String beforeMoneyCode;
	private String beforeMoneyName;
	private String afterMoneyCode;
	private String afterMoneyName;
	private double convertRate;
	private Date updateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBeforeMoneyCode() {
		return beforeMoneyCode;
	}

	public void setBeforeMoneyCode(String beforeMoneyCode) {
		this.beforeMoneyCode = beforeMoneyCode;
	}

	public String getBeforeMoneyName() {
		return beforeMoneyName;
	}

	public void setBeforeMoneyName(String beforeMoneyName) {
		this.beforeMoneyName = beforeMoneyName;
	}

	public String getAfterMoneyCode() {
		return afterMoneyCode;
	}

	public void setAfterMoneyCode(String afterMoneyCode) {
		this.afterMoneyCode = afterMoneyCode;
	}

	public String getAfterMoneyName() {
		return afterMoneyName;
	}

	public void setAfterMoneyName(String afterMoneyName) {
		this.afterMoneyName = afterMoneyName;
	}

	public double getConvertRate() {
		return convertRate;
	}

	public void setConvertRate(double convertRate) {
		this.convertRate = convertRate;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
