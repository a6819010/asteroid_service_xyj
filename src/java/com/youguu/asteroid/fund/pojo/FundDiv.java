package com.youguu.asteroid.fund.pojo;

public class FundDiv {
	private int id;
	private String fundCode;//基金代码（6位）
	private int divType;//类型（0：分红，1：扩/缩股）
	private double cashBT;//分红（税前）
	private double cashAT;//分红（税后）
	private double fundRatio;//扩股/缩股比率
	private String regDate;//股权登记日
	private String exdivDate;//除权除息日
	private int status;//分红状态（0：未处理，1：已登记，2：已分红）
	private String importTime;//入库时间
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFundCode() {
		return fundCode;
	}
	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}
	public int getDivType() {
		return divType;
	}
	public void setDivType(int divType) {
		this.divType = divType;
	}
	public double getCashBT() {
		return cashBT;
	}
	public void setCashBT(double cashBT) {
		this.cashBT = cashBT;
	}
	public double getCashAT() {
		return cashAT;
	}
	public void setCashAT(double cashAT) {
		this.cashAT = cashAT;
	}
	public double getFundRatio() {
		return fundRatio;
	}
	public void setFundRatio(double fundRatio) {
		this.fundRatio = fundRatio;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getExdivDate() {
		return exdivDate;
	}
	public void setExdivDate(String exdivDate) {
		this.exdivDate = exdivDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getImportTime() {
		return importTime;
	}
	public void setImportTime(String importTime) {
		this.importTime = importTime;
	}
	
	
}
