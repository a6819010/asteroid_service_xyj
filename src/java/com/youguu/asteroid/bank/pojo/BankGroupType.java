package com.youguu.asteroid.bank.pojo;

/**
 * 
* @Title: BankGroupType.java
* @Package com.youguu.asteroid.bank.pojo
* @Description: 设定bankGroupType的类型
* @author zhaozhichao
* @date 2015年4月30日 上午9:49:06
* @version V1.0
 */
public enum BankGroupType {

	YOUGUU_PAY("优顾提现", 1),
	LL_CODE("连连代付", 2),
	YB_CODE("易宝支付", 3);

	private int type;
	private String name;

	public int getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	private BankGroupType(String name, int type) {
		this.name = name;
		this.type = type;
	}
	
}
