package com.youguu.asteroid.rpc.client.tradeday;

import org.apache.thrift.TException;

import com.youguu.asteroid.rpc.common.Constants;
import com.youguu.asteroid.rpc.thrift.gen.TradeDayThriftRpcService.Client;
import com.youguu.asteroid.rpc.thrift.gen.TradeDayThriftRpcService.Iface;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.core.util.RPCServiceClient;
import com.youguu.core.util.rpc.multipex.RPCMultiplexConnection;
import com.youguu.core.util.rpc.multipex.RPCMultiplexPool;

/**
* @Title: TradeDayClient.java 
* @Package com.youguu.asteroid.rpc.client.tradeday 
* @Description: 获取交易日RPC客户端 
* @author 徐云杰
* @date 2014年11月27日 下午5:54:28 
* @version V1.0
 */
public class TradeDayClient implements Iface {
	
	private static final Log logger = LogFactory.getLog(Constants.ASTEROIDRPC_CLIENT);
	
	private static RPCMultiplexPool pool = RPCServiceClient.getMultiplexCPool(Constants.ASTEROIDRPCPOOL);
	
	/**
	 * 
	* @Title: getConnection
	* @Description: 获取链接
	* @param @return    
	* @return RPCMultiplexConnection    返回类型
	* @throws
	 */
	private RPCMultiplexConnection getConnection(){
		try {
			return pool.borrowObject();
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return null;
	}

	/**
	 *判断是否为交易日
	 */
	@Override
	public boolean isTradeDay_string(String date) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).isTradeDay_string(date);
		} catch (TException e) {
			conn.setIdle(false);
			throw e;
		}finally{
			if(conn != null){
				try {
					pool.returnObject(conn);
				} catch (Exception e) {
					logger.error(e);
				}
			}
		}
	}

	/**
	 *判断是否为交易日
	 */
	@Override
	public boolean isTradeDay_long(long date) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).isTradeDay_long(date);
		} catch (TException e) {
			conn.setIdle(false);
			throw e;
		}finally{
			if(conn != null){
				try {
					pool.returnObject(conn);
				} catch (Exception e) {
					logger.error(e);
				}
			}
		}
	}

	/**
	 *获取下一个交易日
	 */
	@Override
	public String nextTradeDay_string(String date, int num) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).nextTradeDay_string(date, num);
		} catch (TException e) {
			conn.setIdle(false);
			throw e;
		}finally{
			if(conn != null){
				try {
					pool.returnObject(conn);
				} catch (Exception e) {
					logger.error(e);
				}
			}
		}
	}

	/**
	 *获取下一个交易日
	 */
	@Override
	public String nextTradeDay_long(long date, int num) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).nextTradeDay_long(date, num);
		} catch (TException e) {
			conn.setIdle(false);
			throw e;
		}finally{
			if(conn != null){
				try {
					pool.returnObject(conn);
				} catch (Exception e) {
					logger.error(e);
				}
			}
		}
	}

	@Override
	public String queryTradeDayEnd(long date, int days,
			boolean isContainStartDate) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).queryTradeDayEnd(date, days, isContainStartDate);
		} catch (TException e) {
			conn.setIdle(false);
			throw e;
		}finally{
			if(conn != null){
				try {
					pool.returnObject(conn);
				} catch (Exception e) {
					logger.error(e);
				}
			}
		}
	}

	@Override
	public int queryTradeDayInterval(long date, int days,
			boolean isContainStartDate) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).queryTradeDayInterval(date, days, isContainStartDate);
		} catch (TException e) {
			conn.setIdle(false);
			throw e;
		}finally{
			if(conn != null){
				try {
					pool.returnObject(conn);
				} catch (Exception e) {
					logger.error(e);
				}
			}
		}
	}

	@Override
	public int getTradeDayNum(String beginDate, String endDate)throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).getTradeDayNum(beginDate, endDate);
		} catch (TException e) {
			conn.setIdle(false);
			throw e;
		}finally{
			if(conn != null){
				try {
					pool.returnObject(conn);
				} catch (Exception e) {
					logger.error(e);
				}
			}
		}
	}

	
}
