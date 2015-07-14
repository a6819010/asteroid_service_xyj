package com.youguu.asteroid.sec.pojo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
* @ClassName: Phone 
* @Description: TODO(客服电话类) 
* @author zhangkai 
* @date 2015年5月28日 上午10:23:17 
*
 */
public class Phone {
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
