package com.youguu.asteroid.bank.pojo;


/**
 * @ClassName: Bank
 * @Description: 银行信息列表
 * @author zhaozhichao
 * @date 2015年4月27日 下午15:03:31
 *
 */
public class BankGroup {
	
	private int id;			//功能类型id
	private int groupType; 	//分组类型 
	private int bankId; 	//银行id
	private String bankCode;//分组银行代码
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGroupType() {
		return groupType;
	}
	public void setGroupType(int groupType) {
		this.groupType = groupType;
	}
	public int getBankId() {
		return bankId;
	}
	public void setBankId(int bankId) {
		this.bankId = bankId;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	
	
	
}
