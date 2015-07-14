package com.youguu.asteroid.tool.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: DepositRate
 * @Description: 存款利率表
 * @author shilei
 * @date 2014年10月21日 上午9:56:29
 * 
 */
public class DepositRate implements Serializable{
	private int id;
	private String bankCode;
	private String bankName;
	private double currentDepositRate;
	private double fixedDeposit3month;
	private double fixedDeposit6month;
	private double fixedDeposit1year;
	private double fixedDeposit2year;
	private double fixedDeposit3year;
	private double fixedDeposit5year;
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

	public double getCurrentDepositRate() {
		return currentDepositRate;
	}

	public void setCurrentDepositRate(double currentDepositRate) {
		this.currentDepositRate = currentDepositRate;
	}

	public double getFixedDeposit3month() {
		return fixedDeposit3month;
	}

	public void setFixedDeposit3month(double fixedDeposit3month) {
		this.fixedDeposit3month = fixedDeposit3month;
	}

	public double getFixedDeposit6month() {
		return fixedDeposit6month;
	}

	public void setFixedDeposit6month(double fixedDeposit6month) {
		this.fixedDeposit6month = fixedDeposit6month;
	}

	public double getFixedDeposit1year() {
		return fixedDeposit1year;
	}

	public void setFixedDeposit1year(double fixedDeposit1year) {
		this.fixedDeposit1year = fixedDeposit1year;
	}

	public double getFixedDeposit2year() {
		return fixedDeposit2year;
	}

	public void setFixedDeposit2year(double fixedDeposit2year) {
		this.fixedDeposit2year = fixedDeposit2year;
	}

	public double getFixedDeposit3year() {
		return fixedDeposit3year;
	}

	public void setFixedDeposit3year(double fixedDeposit3year) {
		this.fixedDeposit3year = fixedDeposit3year;
	}

	public double getFixedDeposit5year() {
		return fixedDeposit5year;
	}

	public void setFixedDeposit5year(double fixedDeposit5year) {
		this.fixedDeposit5year = fixedDeposit5year;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
