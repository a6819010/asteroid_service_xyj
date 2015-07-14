package com.youguu.asteroid.tool.pojo;

import java.io.Serializable;
import java.util.Date;

public class LendingRate implements Serializable{
	private int id;
	private String bankCode;
	private String bankName;
	private double month6Below; // 六个月以内（含6个月）
	private double month6ToYear1;// 六个月至一年（含1年）
	private double year1ToYear3;// 一至三年（含3年）
	private double year3ToYear5;// 三至五年（含5年）
	private double year5Below;// 五年以下(含5年)，公积金贷款分为五年以下和五年以上两种利率
	private double year5Above;// 五年以上
	private Date updateTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public double getMonth6Below() {
		return month6Below;
	}

	public void setMonth6Below(double month6Below) {
		this.month6Below = month6Below;
	}

	public double getMonth6ToYear1() {
		return month6ToYear1;
	}

	public void setMonth6ToYear1(double month6ToYear1) {
		this.month6ToYear1 = month6ToYear1;
	}

	public double getYear1ToYear3() {
		return year1ToYear3;
	}

	public void setYear1ToYear3(double year1ToYear3) {
		this.year1ToYear3 = year1ToYear3;
	}

	public double getYear3ToYear5() {
		return year3ToYear5;
	}

	public void setYear3ToYear5(double year3ToYear5) {
		this.year3ToYear5 = year3ToYear5;
	}

	public double getYear5Below() {
		return year5Below;
	}

	public void setYear5Below(double year5Below) {
		this.year5Below = year5Below;
	}

	public double getYear5Above() {
		return year5Above;
	}

	public void setYear5Above(double year5Above) {
		this.year5Above = year5Above;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
