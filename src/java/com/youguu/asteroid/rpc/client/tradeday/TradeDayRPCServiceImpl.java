package com.youguu.asteroid.rpc.client.tradeday;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.thrift.TException;

import com.youguu.asteroid.rpc.common.Constants;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;

/**
 * 
* @Title: TradeDayRPCServiceImpl.java 
* @Package com.youguu.asteroid.rpc.client.tradeday 
* @Description: 交易日service接口实现类,RPC 
* @author 徐云杰
* @date 2014年11月27日 下午6:22:41 
* @version V1.0
 */
public class TradeDayRPCServiceImpl implements ITradeDayRPCService {
	
	private static final Log logger = LogFactory.getLog(Constants.ASTEROIDRPC_CLIENT);
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	private TradeDayClient getClient(){
		return new TradeDayClient();
	}

	@Override
	public boolean isTradeDay(String date) throws ParseException {
		try {
			return getClient().isTradeDay_string(date);
		} catch (TException e) {
			logger.error(e.getMessage(), e);
			return true;
		}
	}

	@Override
	public boolean isTradeDay(Date date) {
		try {
			return getClient().isTradeDay_long(Long.valueOf(sdf.format(date)));
		} catch (TException e) {
			logger.error(e.getMessage(), e);
			return true;
		}
	}

	@Override
	public String nextTradeDay(String date, int num) throws ParseException {
		try {
			return getClient().nextTradeDay_string(date, num);
		} catch (TException e) {
			logger.error(e.getMessage(), e);
			return "";
		}
	}

	@Override
	public String nextTradeDay(Date date, int num) throws ParseException {
		try {
			return getClient().nextTradeDay_long(Long.valueOf(sdf.format(date)), num);
		} catch (TException e) {
			logger.error(e.getMessage(), e);
			return "";
		}
	}

	@Override
	public String queryTradeDayEnd(Date date, int days,
			boolean isContainStartDate) throws ParseException {
		try {
			return getClient().queryTradeDayEnd(date.getTime(), days, isContainStartDate);
		} catch (TException e) {
			logger.error(e.getMessage(), e);
			return "";
		}
	}

	@Override
	public int queryTradeDayInterval(Date date, int days,
			boolean isContainStartDate) throws ParseException {
		try {
			return getClient().queryTradeDayInterval(date.getTime(), days, isContainStartDate);
		} catch (TException e) {
			logger.error(e.getMessage(), e);
			return -1;
		}
	}

	@Override
	public int getTradeDayNum(String beginDate, String endDate) {
		try {
			return getClient().getTradeDayNum(beginDate, endDate);
		} catch (TException e) {
			logger.error(e.getMessage(), e);
			return 0;
		}
	}

	
}
