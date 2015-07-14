package com.youguu.asteroid.tool.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: SocialInsurance
 * @Description: 社保及公积金缴存比例
 * @author shilei
 * @date 2014年10月21日 上午9:57:55
 *
 */
public class SocialInsurance implements Serializable{
	private int id;
	private String cityCode;
	private String cityName;
	private double oldRate;
	private double oldUp;
	private double oldDown;
	
	private double medicalRate;
	private double medicalExt;
	private double medicalUp;
	private double medicalDown;
	
	private double workRate;
	private double workUp;
	private double workDown;
	
	private double injuryRate;
	private double injuryUp;
	private double injuryDown;
	
	private double birthRate;
	private double birthUp;
	private double birthDown;
	
	private double houseRate;
	private double houseUp;
	private double houseDown;
	
	private Date updateTime;
	
	private int houseBase;
	private int socialBase;
	/**
	 * 社保基数封顶值
	 */
	private int socialMax;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public double getOldRate() {
		return oldRate;
	}

	public void setOldRate(double oldRate) {
		this.oldRate = oldRate;
	}

	public double getMedicalRate() {
		return medicalRate;
	}

	public void setMedicalRate(double medicalRate) {
		this.medicalRate = medicalRate;
	}

	public double getMedicalExt() {
		return medicalExt;
	}

	public void setMedicalExt(double medicalExt) {
		this.medicalExt = medicalExt;
	}

	public double getWorkRate() {
		return workRate;
	}

	public void setWorkRate(double workRate) {
		this.workRate = workRate;
	}

	public double getInjuryRate() {
		return injuryRate;
	}

	public void setInjuryRate(double injuryRate) {
		this.injuryRate = injuryRate;
	}

	public double getBirthRate() {
		return birthRate;
	}

	public void setBirthRate(double birthRate) {
		this.birthRate = birthRate;
	}

	public double getHouseRate() {
		return houseRate;
	}

	public void setHouseRate(double houseRate) {
		this.houseRate = houseRate;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getHouseBase() {
		return houseBase;
	}

	public void setHouseBase(int houseBase) {
		this.houseBase = houseBase;
	}

	public int getSocialBase() {
		return socialBase;
	}

	public void setSocialBase(int socialBase) {
		this.socialBase = socialBase;
	}

	public double getOldUp() {
		return oldUp;
	}

	public void setOldUp(double oldUp) {
		this.oldUp = oldUp;
	}

	public double getOldDown() {
		return oldDown;
	}

	public void setOldDown(double oldDown) {
		this.oldDown = oldDown;
	}

	public double getMedicalUp() {
		return medicalUp;
	}

	public void setMedicalUp(double medicalUp) {
		this.medicalUp = medicalUp;
	}

	public double getMedicalDown() {
		return medicalDown;
	}

	public void setMedicalDown(double medicalDown) {
		this.medicalDown = medicalDown;
	}

	public double getWorkUp() {
		return workUp;
	}

	public void setWorkUp(double workUp) {
		this.workUp = workUp;
	}

	public double getWorkDown() {
		return workDown;
	}

	public void setWorkDown(double workDown) {
		this.workDown = workDown;
	}

	public double getInjuryUp() {
		return injuryUp;
	}

	public void setInjuryUp(double injuryUp) {
		this.injuryUp = injuryUp;
	}

	public double getInjuryDown() {
		return injuryDown;
	}

	public void setInjuryDown(double injuryDown) {
		this.injuryDown = injuryDown;
	}

	public double getBirthUp() {
		return birthUp;
	}

	public void setBirthUp(double birthUp) {
		this.birthUp = birthUp;
	}

	public double getBirthDown() {
		return birthDown;
	}

	public void setBirthDown(double birthDown) {
		this.birthDown = birthDown;
	}

	public double getHouseUp() {
		return houseUp;
	}

	public void setHouseUp(double houseUp) {
		this.houseUp = houseUp;
	}

	public double getHouseDown() {
		return houseDown;
	}

	public void setHouseDown(double houseDown) {
		this.houseDown = houseDown;
	}

	public int getSocialMax() {
		return socialMax;
	}

	public void setSocialMax(int socialMax) {
		this.socialMax = socialMax;
	}
}
