
package com.youguu.asteroid.bank.pojo;

/**
 * @ClassName: Bank
 * @Description: 银行信息列表
 * @author zhaozhichao
 * @date 2015年4月27日 下午15:01:12
 *
 */
public class Bank {
	
	private int id;			       //银行id
	private String bankName;      //银行全称
	private String bankNameAbbr; //银行简称
	private String bankLogo;      //银行logo
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankNameAbbr() {
		return bankNameAbbr;
	}
	public void setBankNameAbbr(String bankNameAbbr) {
		this.bankNameAbbr = bankNameAbbr;
	}
	public String getBankLogo() {
		return bankLogo;
	}
	public void setBankLogo(String bankLogo) {
		this.bankLogo = bankLogo;
	}
	
}