package com.youguu.asteroid.sec.pojo;

import java.io.Serializable;

public class IOS implements Serializable{
	
	private String appid;
	private String customurl;
	private String download;
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getCustomurl() {
		return customurl;
	}
	public void setCustomurl(String customurl) {
		this.customurl = customurl;
	}
	public String getDownload() {
		return download;
	}
	public void setDownload(String download) {
		this.download = download;
	}

}
