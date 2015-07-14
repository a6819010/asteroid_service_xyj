package com.youguu.asteroid.rpc.client.sec;

import java.nio.ByteBuffer;
import java.util.List;

import org.apache.thrift.TException;

import com.youguu.asteroid.rpc.common.Constants;
import com.youguu.asteroid.rpc.thrift.gen.SecAccountRecordThrift;
import com.youguu.asteroid.rpc.thrift.gen.SecAccountAndTradeThrift;
import com.youguu.asteroid.rpc.thrift.gen.SecThriftRpcService.Iface;
import com.youguu.asteroid.rpc.thrift.gen.SecThriftRpcService.Client;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.core.util.RPCServiceClient;
import com.youguu.core.util.rpc.multipex.RPCMultiplexConnection;
import com.youguu.core.util.rpc.multipex.RPCMultiplexPool;

public class SecClient implements Iface{
	private static final Log logger = LogFactory.getLog(Constants.ASTEROIDRPC_CLIENT);
	
	private static RPCMultiplexPool pool = RPCServiceClient.getMultiplexCPool(Constants.ASTEROIDRPCPOOL);
	
	SecClient() {
		super();
	}
	
	private RPCMultiplexConnection getClient() {
		try {
			return pool.borrowObject();
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
		}
		return null;
	}
	

	@Override
	public int addSecAccountAndTrade(SecAccountAndTradeThrift secAccountAndTradeThrift) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).addSecAccountAndTrade(secAccountAndTradeThrift);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public int delSecAccountAndTradeById(int id) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).delSecAccountAndTradeById(id);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}
	
	@Override
	public int updateSecAccountAndTrade(
			SecAccountAndTradeThrift secAccountAndTradeThrift)
			throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).updateSecAccountAndTrade(secAccountAndTradeThrift);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public SecAccountAndTradeThrift getSecAccountAndTradeById(int id) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).getSecAccountAndTradeById(id);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public List<SecAccountAndTradeThrift> getSecAccountAndTradeList(int osType,int type) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			List<SecAccountAndTradeThrift> list=client.getClient(Client.class).getSecAccountAndTradeList(osType,type);
			return list;//client.getClient(Client.class).getSecAccountAndTradeList(osType,type);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public int addSecAccountRecord(SecAccountRecordThrift secAccountRecordThrift)
			throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).addSecAccountRecord(secAccountRecordThrift);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public SecAccountRecordThrift getSecAccountRecordById(int id)
			throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).getSecAccountRecordById(id);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}

	@Override
	public ByteBuffer querySecAccountRecord(String phone, int secNo,
			long createtime, int pageIndex, int pageSize) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).querySecAccountRecord(phone, secNo, createtime, pageIndex, pageSize);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}


	@Override
	public List<SecAccountRecordThrift> getSecAccountRecordThriftList(
			String phone, int secNo, long createtime) throws TException {
		RPCMultiplexConnection client = null;
		try {
			client = getClient();
			return client.getClient(Client.class).getSecAccountRecordThriftList(phone, secNo, createtime);
		} catch(TException e){
			client.setIdle(false);
			throw e;
		}finally {
			if(client != null){
				try {
					pool.returnObject(client);
				} catch (Exception e) {
					logger.error(e);;
				}
			}
		}
	}


}
