package com.youguu.asteroid.wxgift.util;

public enum GiftType {
	
	PAY_CAR_50(101,"50元充值卡"),
	PAY_CAR_20(102,"20元充值卡"),
	PAY_CAR_10(103,"10元充值卡"),
	VIP_CAR(1,"会员月卡"),
	RESET_CAR(2,"重置卡"),
	TRACE_CAR(3,"追踪周卡"),
	FUND_CAR_50(4,"50万资金卡"),
	FUND_CAR_10(5,"10万资金卡"),
	FUND_CAR_1(6,"1万资金卡"),
	COIN_CAR_1000(7,"1000金币卡"),
	COIN_CAR_100(8,"100金币卡");
	
	
	private int type;
	
	private String name;
	
	 GiftType(int type,String name){
		 this.name = name;
		 this.type = type;
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
	
	/**
	 * 是否为道具卡  
	 * @param type
	 * @return
	 */
	public static boolean isProp(int type){
		if(type==PAY_CAR_50.getType() || type==PAY_CAR_20.getType() || type==PAY_CAR_10.getType()){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * 获取道具描述
	 * @param type
	 * @return
	 */
	public static String getDes(int type){
		GiftType[] gts = GiftType.values();
		for(GiftType gt:gts){
			if(gt.getType() == type){
				return gt.getName();
			}
		}
		return null;
	}
	 
	 
}
