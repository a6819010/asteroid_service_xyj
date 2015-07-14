package com.youguu.asteroid.tool.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: TaxLevel
 * @Description: 工资纳税标准等级
 * @author shilei
 * @date 2014年10月21日 上午9:58:10
 *
 */
public class TaxLevel implements Serializable{
	private int id;
	private int salaryStart;
	private int salaryEnd;
	private double taxRate;
	private int quickDeduction;
	private Date updateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalaryStart() {
		return salaryStart;
	}

	public void setSalaryStart(int salaryStart) {
		this.salaryStart = salaryStart;
	}

	public int getSalaryEnd() {
		return salaryEnd;
	}

	public void setSalaryEnd(int salaryEnd) {
		this.salaryEnd = salaryEnd;
	}
	
	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getQuickDeduction() {
		return quickDeduction;
	}

	public void setQuickDeduction(int quickDeduction) {
		this.quickDeduction = quickDeduction;
	}

}
