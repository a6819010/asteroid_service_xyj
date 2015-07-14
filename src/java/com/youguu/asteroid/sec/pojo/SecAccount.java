package com.youguu.asteroid.sec.pojo;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
* @ClassName: SecBasicPro 
* @Description: TODO(券商开户列表_基础信息类) 
* @author zhangkai 
* @date 2015年5月28日 上午10:26:10 
*
 */
public class SecAccount implements Serializable{
	private String name;
	private String logo;
	private int secNo;
	private Apk apk;
	private IOS ios;
	@JSONField(name="banner")
	private List<Banner> banner;
	@JSONField(name="des")
	private List<Description> des;
	private Help help;
	private Type type;
	private Phone phone;
	
	public Apk getApk() {
		return apk;
	}
	public void setApk(Apk apk) {
		this.apk = apk;
	}
	public int getSecNo() {
		return secNo;
	}
	public void setSecNo(int secNo) {
		this.secNo = secNo;
	}
	public IOS getIos() {
		return ios;
	}
	public void setIos(IOS ios) {
		this.ios = ios;
	}
	public List<Banner> getBanner() {
		return banner;
	}
	public void setBanner(List<Banner> banner) {
		this.banner = banner;
	}
	public List<Description> getDes() {
		return des;
	}
	public void setDes(List<Description> des) {
		this.des = des;
	}
	public Help getHelp() {
		return help;
	}
	public void setHelp(Help help) {
		this.help = help;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
}
