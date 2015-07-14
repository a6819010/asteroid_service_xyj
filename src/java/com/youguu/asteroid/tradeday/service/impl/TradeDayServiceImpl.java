package com.youguu.asteroid.tradeday.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.youguu.asteroid.tradeday.cache.CloseDayCache;
import com.youguu.asteroid.tradeday.dao.IMncgClosedDaysDAO;
import com.youguu.asteroid.tradeday.service.ITradeDayService;
import com.youguu.core.util.DateUtil;

/**
 * 
* @Title: TradeDayServiceImpl.java 
* @Package com.youguu.asteroid.tradeday.service.impl 
* @Description: 交易日获取接口实现类
* @author 徐云杰
* @date 2014年11月26日 下午4:05:15 
* @version V1.0
 */
@Service("tradeDayService")
public class TradeDayServiceImpl implements ITradeDayService {

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	private SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	
	@Resource
	private IMncgClosedDaysDAO mncgClosedDaysDAO;

	@Override
	public Set<String> getTradeDayList() {
		return mncgClosedDaysDAO.getTradeDayList();
	}
	
	@Override
	public String getMaxTradeDay() {
		return mncgClosedDaysDAO.getMaxTradeDay();
	}

	@Override
	public boolean isTradeDay(String date){
		Set<String> list = CloseDayCache.getCache().getDaySet();
		date = date.replace("-", "");
		return !list.contains(date);
	}

	@Override
	public boolean isTradeDay(Date date) {
		Set<String> list = CloseDayCache.getCache().getDaySet();
		return !list.contains(sdf.format(date));
	}

	@Override
	public String nextTradeDay(String date, int num) throws ParseException{
		Set<String> list = CloseDayCache.getCache().getDaySet();
		String maxday = CloseDayCache.getCache().getMaxDate();
		Calendar c = Calendar.getInstance();
		date = date.replace("-", "");
		Date nowdate = sdf.parse(date);
		String day = "";
		String tradeday="";
		while(num!=0)
		{
			c.setTime(nowdate);
			c.add(Calendar.DAY_OF_MONTH, 1);
			nowdate = c.getTime();
			day = sdf.format(nowdate);
			if(Integer.valueOf(day) > Integer.valueOf(maxday))
			{
				break;
			}
			if(!list.contains(day))
			{
				tradeday = day;
				num--;
			}
		}
		return tradeday;
	}

	@Override
	public String nextTradeDay(Date date, int num)throws ParseException {
		HashSet<String> list = (HashSet<String>)CloseDayCache.getCache().getDaySet();
		String maxday = CloseDayCache.getCache().getMaxDate();
		Calendar c = Calendar.getInstance();
		Date nowdate = sdf.parse(sdf.format(date));
		String day = "";
		String tradeday="";
		while(num!=0)
		{
			c.setTime(nowdate);
			c.add(Calendar.DAY_OF_MONTH, 1);
			nowdate = c.getTime();
			day = sdf.format(nowdate);
			if(Integer.valueOf(day) > Integer.valueOf(maxday))
			{
				break;
			}
			if(!list.contains(day))
			{
				tradeday = day;
				num--;
			}
		}
		return tradeday;
	}
	
	/**
	 * @param date T日，格式： yyyy-MM-dd
	 * @param days 交易日天数
	 * @param isContainStartDate 是否包含T日 true-从T日开始计算截止日，false-从T+1日开始计算截止日
	 * @return yyyyMMdd
	 * @throws ParseException
	 */
	public String queryTradeDayEnd(Date date, int days, boolean isContainStartDate)
			throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.setTime(date);
		
		if (!isContainStartDate) {
			calendar.add(Calendar.DAY_OF_MONTH, 1);
		}
		
		HashSet<String> list = (HashSet<String>) CloseDayCache.getCache().getDaySet();
		String maxday = CloseDayCache.getCache().getMaxDate();//一年中最后一天交易日
		String tradeday = "";
		
		while (days != 0) {
			if (calendar.getTime().getTime() > sdf.parse(maxday).getTime()) {
				break;
			}
			if (!list.contains(sdf.format(calendar.getTime()))) {
				tradeday = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
				days--;
			}
			calendar.add(Calendar.DAY_OF_MONTH, 1);
		}
		return tradeday;
	}

	@Override
	public int queryTradeDayInterval(Date date, int days,
			boolean isContainStartDate) throws ParseException {
		String endDate = this.queryTradeDayEnd(date, days, isContainStartDate);
		return DateUtil.daysBetween(date, new SimpleDateFormat("yyyy-MM-dd").parse(endDate), isContainStartDate);
	}

	@Override
	public int getTradeDayNum(String beginDate, String endDate) {
		try {
			Date start = sdf2.parse(beginDate);
			Date end = sdf2.parse(endDate);
			return jsTradeDayNum(start, end);
		} catch (ParseException e) {
		}
		return 0;
	}
	
	private int jsTradeDayNum(Date beginDate, Date endDate)
	{
		int endTime = Integer.valueOf(sdf.format(endDate));
		int nowTime=0;
		int num=0;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(beginDate);
		nowTime = Integer.valueOf(sdf.format(calendar.getTime()));
		Set<String> list = (HashSet<String>) CloseDayCache.getCache().getDaySet();
		while(nowTime<=endTime)
		{
			if(!list.contains(String.valueOf(nowTime)))
			{
				num++;
			}
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			nowTime = Integer.valueOf(sdf.format(calendar.getTime()));
		}
		return num;
	}
	
}
