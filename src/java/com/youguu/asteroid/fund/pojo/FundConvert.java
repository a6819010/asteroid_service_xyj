package com.youguu.asteroid.fund.pojo;


/**
* @Title: FundConvert.java
* @Package com.youguu.asteroid.fund.pojo
* @Description: 分级基金除权除息
* @author zhaozhichao
* @date 2015年5月25日 下午2:56:15
* @version V1.0
 */
public class FundConvert {
	private int id;
	private String afundCode;//A类基金代码
	private String bfundCode;//B类基金代码
	private int convertType;//折算类型（0：定期折算，1：上折，2：下折）
	private double aconvertRate;//A类拆分比率
	private double bconvertRate;//B类拆分比率
	private double abRatio;//A类/B类份额比
	private String regDate;//基金折算登记日
	private String convertDate;//基金折算日
	private int status;//是否处理（0：未处理，1：已登记,2:已处理）
	private String importTime;//入库时间

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getConvertType() {
		return convertType;
	}
	public void setConvertType(int convertType) {
		this.convertType = convertType;
	}
	public double getAbRatio() {
		return abRatio;
	}
	public String getAfundCode() {
		return afundCode;
	}
	public void setAfundCode(String afundCode) {
		this.afundCode = afundCode;
	}
	public String getBfundCode() {
		return bfundCode;
	}
	public void setBfundCode(String bfundCode) {
		this.bfundCode = bfundCode;
	}
	public double getAconvertRate() {
		return aconvertRate;
	}
	public void setAconvertRate(double aconvertRate) {
		this.aconvertRate = aconvertRate;
	}
	public double getBconvertRate() {
		return bconvertRate;
	}
	public void setBconvertRate(double bconvertRate) {
		this.bconvertRate = bconvertRate;
	}
	public void setAbRatio(double abRatio) {
		this.abRatio = abRatio;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getConvertDate() {
		return convertDate;
	}
	public void setConvertDate(String convertDate) {
		this.convertDate = convertDate;
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
