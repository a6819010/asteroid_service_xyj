package com.youguu.asteroid.rpc.client.windvane;

import java.util.List;
import java.util.Map;

import org.apache.thrift.TException;

import com.youguu.asteroid.rpc.common.Constants;
import com.youguu.asteroid.rpc.thrift.gen.MarketWindVanePollVoteThrift;
import com.youguu.asteroid.rpc.thrift.gen.WindVaneThriftRpcService.Client;
import com.youguu.asteroid.rpc.thrift.gen.WindVaneThriftRpcService.Iface;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.core.util.RPCServiceClient;
import com.youguu.core.util.rpc.multipex.RPCMultiplexConnection;
import com.youguu.core.util.rpc.multipex.RPCMultiplexPool;

/**
 * 
* @Title: WindVaneClient.java 
* @Package com.youguu.asteroid.rpc.client.windvane 
* @Description: 获取风向标RPC客户端
* @author 徐云杰
* @date 2014年12月4日 下午3:56:38 
* @version V1.0
 */
public class WindVaneClient implements Iface {

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
	public MarketWindVanePollVoteThrift getMarketWindVanePollVote(String date)
			throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).getMarketWindVanePollVote(date);
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
	public int updateMarketWindVanePollVote(MarketWindVanePollVoteThrift mwv)
			throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).updateMarketWindVanePollVote(mwv);
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
	public int closeClear() throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).closeClear();
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
	public Map<String, String> findWindVane(int uid) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).findWindVane(uid);
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
	public int vote(int uid, int voteflag) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).vote(uid, voteflag);
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
	public Map<String, List<Double>> cowThanBear() throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).cowThanBear();
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
	public List<String> getNDaysWindVaneTime(int daynum) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).getNDaysWindVaneTime(daynum);
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
