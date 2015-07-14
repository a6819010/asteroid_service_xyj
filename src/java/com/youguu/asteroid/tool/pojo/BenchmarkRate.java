package com.youguu.asteroid.tool.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: BenchmarkRate
 * @Description: 基准利率表
 * @author shilei
 * @date 2014年10月21日 上午9:55:50
 *
 */
public class BenchmarkRate implements Serializable {
	private int id;
	private double businessRate;
	private double housingRate;
	private Date updateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBusinessRate() {
		return businessRate;
	}

	public void setBusinessRate(double businessRate) {
		this.businessRate = businessRate;
	}

	public double getHousingRate() {
		return housingRate;
	}

	public void setHousingRate(double housingRate) {
		this.housingRate = housingRate;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
