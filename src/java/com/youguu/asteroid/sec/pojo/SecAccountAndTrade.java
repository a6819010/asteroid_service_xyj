package com.youguu.asteroid.sec.pojo;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

/**
 * 
* @ClassName: SecAccountAndTrade 
* @Description: TODO(券商开户及交易列表实体类) 
* @author zhangkai 
* @date 2015年5月28日 下午5:59:29 
*
 */
public class SecAccountAndTrade implements Serializable {
	/**
	 * 类型为开户
	 */
	public static int SEC_TYPE_ACCOUNT=1;
	/**
	 * 类型为交易
	 */
	public static int SEC_TYPE_TRADE=2;
	/**
	 * 主键
	 */
	private int id ;
	/**
	 * 券商名字
	 */
	private String name;
	/**
	 * 券商编号
	 */
	private int secNo;
	/**
	 * 系统类型
	 */
	private int osType;
	/**
	 * 对象类型  开户、交易
	 */
	private int type;
	/**
	 * 后台设置排序
	 */
	private int orders;
	/**
	 * json字符串
	 */
	private String jsonStr;
	/**
	 * 开户json bean
	 */
    private SecAccount secAccount;
    /**
     * 交易json bean
     */
    private SecTrade secTrade;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getOrders() {
		return orders;
	}
	public void setOrders(int orders) {
		this.orders = orders;
	}
	public String getJsonStr() {
		return jsonStr;
	}
	public void setJsonStr(String jsonStr) {
		this.jsonStr = jsonStr;
		/*if(this.type==SEC_TYPE_ACCOUNT){
			secAccount=JSON.parseObject(jsonStr, SecAccount.class);
		}else if(this.type==SEC_TYPE_TRADE){
			secTrade=JSON.parseObject(jsonStr, SecTrade.class);
		}*/
	}
	public int getSecNo() {
		return secNo;
	}
	public void setSecNo(int secNo) {
		this.secNo = secNo;
	}
	public int getOsType() {
		return osType;
	}
	public void setOsType(int osType) {
		this.osType = osType;
	}
	public SecAccount getSecAccount() {
		return secAccount;
	}
	public void setSecAccount(SecAccount secAccount) {
		this.secAccount = secAccount;
		this.jsonStr=JSON.toJSONString(secAccount);
	}
	public SecTrade getSecTrade() {
		return secTrade;
	}
	public void setSecTrade(SecTrade secTrade) {
		this.secTrade = secTrade;
		this.jsonStr=JSON.toJSONString(secTrade);
	}
	@Override
	public String toString() {
		return "SecAccountAndTrade [id=" + id + ", name=" + name + ", sec_no="
				+ secNo + ", os_type=" + osType + ", type=" + type
				+ ", orders=" + orders + ", jsonStr=" + jsonStr + "]";
	}
	

}
