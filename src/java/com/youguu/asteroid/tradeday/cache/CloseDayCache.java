package com.youguu.asteroid.tradeday.cache;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import com.youguu.asteroid.tradeday.service.ITradeDayService;
import com.youguu.asteroid.tradeday.service.impl.TradeDayServiceImpl;
import com.youguu.asteroid.util.SpringUtil;

/*
 * 用于缓存当前非交易日列表
 */
public class CloseDayCache {
	
	private static CloseDayCache cache = new CloseDayCache();
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	private CloseDayCache()
	{
		
	}
	
	public static CloseDayCache getCache() {
		return cache;
	}
	
	/**
	 * 用于标识当前缓存加载的日期
	 */
	private String date;
	
	/**
	 * 缓存最大日期
	 */
	private String maxDate;
	
	/**
	 * 节假日的缓存
	 */
	private Set<String> daySet;
	
	/**
	 * 数据初始化
	 */
	public void load(){
		ITradeDayService tds = (TradeDayServiceImpl)SpringUtil.getBean("tradeDayService");
		this.maxDate = tds.getMaxTradeDay();
		this.daySet = tds.getTradeDayList();
	}
	
	/**
	 * 更新缓存时间
	 */
	public void resetCacheDate(){
		this.date = sdf.format(new Date());
	}

	public String getDate() {
		return date;
	}

	public String getMaxDate() {
		return maxDate;
	}

	public Set<String> getDaySet() {
		boolean needLoad = false;
		
		String nowTime = sdf.format(new Date());
		
		if(!nowTime.equals(this.date))
		{
			synchronized (CloseDayCache.class) {
				if(!nowTime.equals(this.date)){
					resetCacheDate();
					needLoad = true;
				}
			}
			if(needLoad){
				load();
			}
		}
		return daySet;
	}

}
