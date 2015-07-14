package com.youguu.asteroid.rpc.server.tradeday;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import com.youguu.asteroid.rpc.common.Constants;
import com.youguu.asteroid.rpc.thrift.gen.TradeDayThriftRpcService.Iface;
import com.youguu.asteroid.tradeday.service.impl.TradeDayServiceImpl;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;

/**
 * 
* @Title: TradeDayThriftRpcServiceImpl.java 
* @Package com.youguu.asteroid.rpc.server.tradeday 
* @Description: 交易日RPC服务端实现类 
* @author 徐云杰
* @date 2014年11月27日 下午6:44:52 
* @version V1.0
 */
@Service("tradeDayThriftRpcService")
public class TradeDayThriftRpcServiceImpl implements Iface {

	private static final Log logger = LogFactory.getLog(Constants.ASTEROIDRPC_SERVER);
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	@Resource
	private TradeDayServiceImpl tradeDayService;
	
	@Override
	public boolean isTradeDay_string(String date) throws TException {
		try {
			return tradeDayService.isTradeDay(date);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return true;
		}
	}

	@Override
	public boolean isTradeDay_long(long date) throws TException {
		try {
			return tradeDayService.isTradeDay(sdf.parse(String.valueOf(date)));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return true;
		}
	}

	@Override
	public String nextTradeDay_string(String date, int num) throws TException {
		try {
			return tradeDayService.nextTradeDay(date, num);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return "";
		}
	}

	@Override
	public String nextTradeDay_long(long date, int num) throws TException {
		try {
			return tradeDayService.nextTradeDay(sdf.parse(String.valueOf(date)), num);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return "";
		}
	}

	@Override
	public String queryTradeDayEnd(long date, int days,
			boolean isContainStartDate) throws TException {
		try {
			return tradeDayService.queryTradeDayEnd(sdf.parse(sdf.format(new Date(date))), days, isContainStartDate);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return "";
		}
	}

	@Override
	public int queryTradeDayInterval(long date, int days,
			boolean isContainStartDate) throws TException {
		try {
			return tradeDayService.queryTradeDayInterval(sdf.parse(sdf.format(new Date(date))), days, isContainStartDate);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return -1;
		}
	}

	@Override
	public int getTradeDayNum(String beginDate, String endDate)throws TException {
		try {
			return tradeDayService.getTradeDayNum(beginDate, endDate);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return 0;
		}
	}

}
