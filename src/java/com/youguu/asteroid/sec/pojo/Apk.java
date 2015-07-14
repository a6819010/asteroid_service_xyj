package com.youguu.asteroid.sec.pojo;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
* @ClassName: Apk 
* @Description: TODO(下载包描述类) 
* @author zhangkai 
* @date 2015年5月28日 上午10:24:20 
*
 */
public class Apk implements Serializable {
	private String name;//券商名字
	@JSONField(name="package")
	private String packageStr;//包
	private String url;//下载地址
	private String version;//版本号
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPackageStr() {
		return packageStr;
	}
	public void setPackageStr(String packageStr) {
		this.packageStr = packageStr;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	

}
