package com.youguu.asteroid.sec.pojo;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class Sub implements Serializable{
	@JSONField(name="account")
	private List<Account> account;
	private String ak;
	private String funcs;
	private String type ;
	private String method;
	private Help help;
	private Phone phone;
	private String randUrl;
	private String title;
	private String url;
	public List<Account> getAccount() {
		return account;
	}
	public void setAccount(List<Account> account) {
		this.account = account;
	}
	public String getAk() {
		return ak;
	}
	public void setAk(String ak) {
		this.ak = ak;
	}
	public String getFuncs() {
		return funcs;
	}
	public void setFuncs(String funcs) {
		this.funcs = funcs;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public Help getHelp() {
		return help;
	}
	public void setHelp(Help help) {
		this.help = help;
	}
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	public String getRandUrl() {
		return randUrl;
	}
	public void setRandUrl(String randUrl) {
		this.randUrl = randUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
