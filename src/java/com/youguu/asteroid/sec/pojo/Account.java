package com.youguu.asteroid.sec.pojo;

import java.io.Serializable;

/**
 * 
* @ClassName: Account 
* @Description: TODO(券商列表交易类型 account类) 
* @author zhangkai 
* @date 2015年5月28日 下午6:29:33 
*
 */
public class Account  implements Serializable{
	
	private String name;
	private String type;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

}
