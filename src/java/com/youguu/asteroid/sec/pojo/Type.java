package com.youguu.asteroid.sec.pojo;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
* @ClassName: Type 
* @Description: TODO(按钮类型类) 
* @author zhangkai 
* @date 2015年5月28日 上午10:24:43 
*
 */
public class Type implements Serializable{
	public static String TYPE_DOWNLOAD="1";
	public static String TYPE_RESERVATION="2";
	public static String TYPE_PARAM="3";
	public static String TYPE_OTHER="4";
	@JSONField(name="des")
	private String desc;
	private String type;
	private String main;
	private String param;
	private String paramtype;
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	public String getParamtype() {
		return paramtype;
	}
	public void setParamtype(String paramtype) {
		this.paramtype = paramtype;
	}

}
