package com.youguu.asteroid.tradeday.pojo;

import java.io.Serializable;

/**
* @Title: MncgClosedDays.java 
* @Package com.youguu.asteroid.tradeday.pojo 
* @Description: 交易日bean
* @author 徐云杰
* @date 2014年11月27日 下午2:51:39 
* @version V1.0
 */
public class MncgClosedDays  implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	private String time;

	public MncgClosedDays() {
	}

	public MncgClosedDays(String time) {
		this.time = time;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
	
}
