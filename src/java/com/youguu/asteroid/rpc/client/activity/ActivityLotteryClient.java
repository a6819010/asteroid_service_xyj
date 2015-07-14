package com.youguu.asteroid.rpc.client.activity;

import java.nio.ByteBuffer;
import java.util.List;

import org.apache.thrift.TException;

import com.youguu.asteroid.rpc.common.Constants;
import com.youguu.asteroid.rpc.thrift.gen.ActivityLotteryThriftRpcService.Client;
import com.youguu.asteroid.rpc.thrift.gen.ActivityLotteryThriftRpcService.Iface;
import com.youguu.asteroid.rpc.thrift.gen.ActivityPrizeThrift;
import com.youguu.asteroid.rpc.thrift.gen.ActivityUserThrift;
import com.youguu.asteroid.rpc.thrift.gen.VoPrizeInfoThrift;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.core.util.RPCServiceClient;
import com.youguu.core.util.rpc.multipex.RPCMultiplexConnection;
import com.youguu.core.util.rpc.multipex.RPCMultiplexPool;

/**
 * 
* @Title: ActivityLotteryClient.java
* @Package com.youguu.asteroid.rpc.client.activity
* @Description: 活动抽奖客户端
* @author 徐云杰
* @date 2015年3月12日 下午2:04:03
* @version V1.0
 */
public class ActivityLotteryClient implements Iface {
	
	private static final Log log = LogFactory.getLog(Constants.ASTEROIDRPC_CLIENT);

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
			log.error(e.getMessage(),e);
		}
		return null;
	}

	@Override
	public ByteBuffer findUserAwardInfo(int userId)throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).findUserAwardInfo(userId);
		} catch (TException e) {
			conn.setIdle(false);
			throw e;
		}finally{
			if(conn != null){
				try {
					pool.returnObject(conn);
				} catch (Exception e) {
					log.error("findUserAwardInfo",e);
				}
			}
		}
	}

	@Override
	public ByteBuffer findUserAwardRecord(int userId) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).findUserAwardRecord(userId);
		} catch (TException e) {
			conn.setIdle(false);
			throw e;
		}finally{
			if(conn != null){
				try {
					pool.returnObject(conn);
				} catch (Exception e) {
					log.error("findUserAwardRecord",e);
				}
			}
		}
	}

	@Override
	public ByteBuffer clickLottery(int userId) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).clickLottery(userId);
		} catch (TException e) {
			conn.setIdle(false);
			throw e;
		}finally{
			if(conn != null){
				try {
					pool.returnObject(conn);
				} catch (Exception e) {
					log.error("clickLottery",e);
				}
			}
		}
	}

	@Override
	public ByteBuffer getAward(int poolId, String phone, int userId)throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).getAward(poolId, phone, userId);
		} catch (TException e) {
			conn.setIdle(false);
			throw e;
		}finally{
			if(conn != null){
				try {
					pool.returnObject(conn);
				} catch (Exception e) {
					log.error("getAward",e);
				}
			}
		}
	}

	@Override
	public int createPrizePool(List<VoPrizeInfoThrift> listDate, int batchNum)throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).createPrizePool(listDate, batchNum);
		} catch (TException e) {
			conn.setIdle(false);
			throw e;
		}finally{
			if(conn != null){
				try {
					pool.returnObject(conn);
				} catch (Exception e) {
					log.error("createPrizePool",e);
				}
			}
		}
	}

	@Override
	public int createBigPrize(VoPrizeInfoThrift vpi) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).createBigPrize(vpi);
		} catch (TException e) {
			conn.setIdle(false);
			throw e;
		}finally{
			if(conn != null){
				try {
					pool.returnObject(conn);
				} catch (Exception e) {
					log.error("createBigPrize",e);
				}
			}
		}
	}

	@Override
	public int comparisonData() throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).comparisonData();
		} catch (TException e) {
			conn.setIdle(false);
			throw e;
		}finally{
			if(conn != null){
				try {
					pool.returnObject(conn);
				} catch (Exception e) {
					log.error("comparisonData",e);
				}
			}
		}
	}

	@Override
	public ByteBuffer findAllActivityUser(ByteBuffer parameter, int pageIndex,int pageSize) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).findAllActivityUser(parameter, pageIndex, pageSize);
		} catch (TException e) {
			conn.setIdle(false);
			throw e;
		}finally{
			if(conn != null){
				try {
					pool.returnObject(conn);
				} catch (Exception e) {
					log.error("findAllActivityUser",e);
				}
			}
		}
	}

	@Override
	public ByteBuffer findAllActivityPrize(ByteBuffer parameter, int pageIndex,int pageSize) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).findAllActivityPrize(parameter, pageIndex, pageSize);
		} catch (TException e) {
			conn.setIdle(false);
			throw e;
		}finally{
			if(conn != null){
				try {
					pool.returnObject(conn);
				} catch (Exception e) {
					log.error("findAllActivityPrize",e);
				}
			}
		}
	}

	@Override
	public ByteBuffer findAllUserAwardNum(ByteBuffer parameter, int pageIndex,int pageSize) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).findAllUserAwardNum(parameter, pageIndex, pageSize);
		} catch (TException e) {
			conn.setIdle(false);
			throw e;
		}finally{
			if(conn != null){
				try {
					pool.returnObject(conn);
				} catch (Exception e) {
					log.error("findAllUserAwardNum",e);
				}
			}
		}
	}

	@Override
	public int batchInsertActivityUser(List<ActivityUserThrift> listData)throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).batchInsertActivityUser(listData);
		} catch (TException e) {
			conn.setIdle(false);
			throw e;
		}finally{
			if(conn != null){
				try {
					pool.returnObject(conn);
				} catch (Exception e) {
					log.error("batchInsertActivityUser",e);
				}
			}
		}
	}

	@Override
	public int addActivityPrize(ActivityPrizeThrift ap) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).addActivityPrize(ap);
		} catch (TException e) {
			conn.setIdle(false);
			throw e;
		}finally{
			if(conn != null){
				try {
					pool.returnObject(conn);
				} catch (Exception e) {
					log.error("addActivityPrize",e);
				}
			}
		}
	}

	@Override
	public ByteBuffer findAllActivityUserAwardRecord(ByteBuffer parameter,int pageIndex, int pageSize) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).findAllActivityUserAwardRecord(parameter, pageIndex, pageSize);
		} catch (TException e) {
			conn.setIdle(false);
			throw e;
		}finally{
			if(conn != null){
				try {
					pool.returnObject(conn);
				} catch (Exception e) {
					log.error("findAllActivityUserAwardRecord",e);
				}
			}
		}
	}

	@Override
	public int delActivityPrize(int id) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).delActivityPrize(id);
		} catch (TException e) {
			conn.setIdle(false);
			throw e;
		}finally{
			if(conn != null){
				try {
					pool.returnObject(conn);
				} catch (Exception e) {
					log.error("delActivityPrize",e);
				}
			}
		}
	}

	@Override
	public int updateUserAwardRecordStatus(int pooId, int status)throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).updateUserAwardRecordStatus(pooId, status);
		} catch (TException e) {
			conn.setIdle(false);
			throw e;
		}finally{
			if(conn != null){
				try {
					pool.returnObject(conn);
				} catch (Exception e) {
					log.error("updateUserAwardRecordStatus",e);
				}
			}
		}
	}

}
