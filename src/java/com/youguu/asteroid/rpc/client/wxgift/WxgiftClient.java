package com.youguu.asteroid.rpc.client.wxgift;

import org.apache.thrift.TException;

import com.youguu.asteroid.rpc.common.Constants;
import com.youguu.asteroid.rpc.thrift.gen.WxgiftThriftRpcService.Client;
import com.youguu.asteroid.rpc.thrift.gen.WxgiftThriftRpcService.Iface;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.core.util.RPCServiceClient;
import com.youguu.core.util.rpc.multipex.RPCMultiplexConnection;
import com.youguu.core.util.rpc.multipex.RPCMultiplexPool;

public class WxgiftClient implements Iface {
	
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

	@Override
	public String queryStatus(String openid, String hopenid) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).queryStatus(openid, hopenid);
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
	public int open(String openid, String hopenid) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).open(openid, hopenid);
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
	public int phone(String openid, String phone) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).phone(openid, phone);
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
