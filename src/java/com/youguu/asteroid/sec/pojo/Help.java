package com.youguu.asteroid.sec.pojo;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
/**
 * 
* @ClassName: Help 
* @Description: TODO(开户指引类) 
* @author zhangkai 
* @date 2015年5月28日 上午10:24:00 
*
 */
public class Help implements Serializable{
	private String title;
	@JSONField(name="des")
	private String des;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	

}
