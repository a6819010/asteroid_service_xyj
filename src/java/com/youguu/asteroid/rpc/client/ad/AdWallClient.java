package com.youguu.asteroid.rpc.client.ad;

import java.nio.ByteBuffer;
import java.util.List;

import org.apache.thrift.TException;

import com.youguu.asteroid.rpc.common.Constants;
import com.youguu.asteroid.rpc.thrift.gen.AdWallThrift;
import com.youguu.asteroid.rpc.thrift.gen.AdWallThriftRpcService.Client;
import com.youguu.asteroid.rpc.thrift.gen.AdWallThriftRpcService.Iface;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.core.util.RPCServiceClient;
import com.youguu.core.util.rpc.multipex.RPCMultiplexConnection;
import com.youguu.core.util.rpc.multipex.RPCMultiplexPool;
/**
 * 
 * @ClassName: AdWallClient
 * @Description: 模拟炒股广告墙rpc客户端
 * @author zhanglei
 * @date 2014年12月4日 下午6:56:17
 *
 */
public class AdWallClient implements Iface {

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
	 * 添加广告
	 * @param t
	 * @return
	 */
	@Override
	public int addAdWall(AdWallThrift t) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).addAdWall(t);
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
	 * 删除广告
	 * @param id
	 * @return
	 */
	@Override
	public int deleteAdWall(int id) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).deleteAdWall(id);
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
	 * 修改广告
	 * @param t
	 * @return
	 */
	@Override
	public int updateAdWall(AdWallThrift t) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).updateAdWall(t);
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
	 * 查询广告
	 * @param id
	 * @return
	 */
	@Override
	public AdWallThrift getAdWall(int id) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).getAdWall(id);
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
	 * 查询广告 分页
	 * @param hm
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@Override
	public ByteBuffer queryAdWallList(ByteBuffer hm, int pageIndex, int pageSize)
			throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).queryAdWallList(hm, pageIndex, pageSize);
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
	 * 将广告按位置类型缓存到redis中
	 * @param positionType
	 * @return
	 */
	@Override
	public boolean flushRedis(String positionType) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).flushRedis(positionType);
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
	 * 按照位置类型从redis中查询广告
	 * @param positionType
	 * @return
	 */
	@Override
	public List<AdWallThrift> queryAdWallFromRedis(String positionType)
			throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).queryAdWallFromRedis(positionType);
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
