package com.youguu.asteroid.sec.pojo;

import java.io.Serializable;
import java.util.Date;

public class SecAccountRecord implements Serializable{
	private int id;
	private String phone;
	private String ak;
	private int secNo;
	private Date createtime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAk() {
		return ak;
	}
	public void setAk(String ak) {
		this.ak = ak;
	}
	public int getSecNo() {
		return secNo;
	}
	public void setSecNo(int secNo) {
		this.secNo = secNo;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	@Override
	public String toString() {
		return "SecAccountRecord [id=" + id + ", phone=" + phone + ", ak=" + ak
				+ ", secNo=" + secNo + ", createtime=" + createtime + "]";
	}

}
