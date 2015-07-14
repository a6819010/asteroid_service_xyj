package com.youguu.asteroid.rpc.client.func;

import java.util.List;

import org.apache.thrift.TApplicationException;
import org.apache.thrift.TException;

import com.youguu.asteroid.rpc.common.Constants;
import com.youguu.asteroid.rpc.thrift.gen.FuncThriftRpcService.Client;
import com.youguu.asteroid.rpc.thrift.gen.FuncThriftRpcService.Iface;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.core.util.RPCServiceClient;
import com.youguu.core.util.rpc.multipex.RPCMultiplexConnection;
import com.youguu.core.util.rpc.multipex.RPCMultiplexPool;

public class FuncClient implements Iface {

	
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
	public List<String> queryFunc(String ak) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).queryFunc(ak);
		} catch (Exception e) {
			if (e instanceof TApplicationException && ((TApplicationException) e).getType() == TApplicationException.MISSING_RESULT)
			{
				return null; //注意调用方法需要判断是否为null
			}else{
				conn.setIdle(false);
				throw e;
			}
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
