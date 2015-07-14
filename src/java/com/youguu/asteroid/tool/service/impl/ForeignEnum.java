package com.youguu.asteroid.tool.service.impl;


public enum ForeignEnum {

	人民币("CNY", "人民币"),
	美元("USD", "美元"),
	欧元("EUR", "欧元"),
	英镑("GBP", "英镑"),
	港币("HKD", "港币"),
	日元("JPY", "日元"),
	加拿大元("CAD", "加拿大元"),
	澳元("AUD", "澳元"),
	新加坡元("SGD", "新加坡元"),
	新西兰元("NZD", "新西兰元"),
	韩元("KRW", "韩元"),
	澳门元("MOP", "澳门元"),
	菲律宾元("PHP", "菲律宾元"),
	泰国铢("THB", "泰国铢"),
	瑞士法郎("CHF", "瑞士法郎"),
	卢布("RUB", "卢布"),
	挪威克朗("NOK", "挪威克朗"),
	瑞典克朗("SEK", "瑞典克朗"),
	丹麦克朗("DKK", "丹麦克朗");


	private String code;
	private String name;

	private ForeignEnum(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public static String getName(String code) {
		for (ForeignEnum c : ForeignEnum.values()) {
			if (c.getCode().equals(code)) {
				return c.name;
			}
		}
		return null;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
