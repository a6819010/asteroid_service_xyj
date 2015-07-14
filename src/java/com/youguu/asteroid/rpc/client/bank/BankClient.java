package com.youguu.asteroid.rpc.client.bank;

import java.util.List;
import java.util.Map;

import org.apache.thrift.TApplicationException;
import org.apache.thrift.TException;

import com.youguu.asteroid.rpc.common.Constants;
import com.youguu.asteroid.rpc.thrift.gen.BankGroupThrift;
import com.youguu.asteroid.rpc.thrift.gen.BankThrift;
import com.youguu.asteroid.rpc.thrift.gen.BankThriftRpcService.Iface;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.core.util.RPCServiceClient;
import com.youguu.core.util.rpc.multipex.RPCMultiplexConnection;
import com.youguu.core.util.rpc.multipex.RPCMultiplexPool;
import com.youguu.asteroid.rpc.thrift.gen.BankThriftRpcService.Client;

public class BankClient implements Iface {
	
	private static final Log logger = LogFactory.getLog(Constants.BANK_CLIENT);
	
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
	public int addBank(BankThrift bankThrift) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).addBank(bankThrift);
		} catch (TException e) {
			if (e instanceof TApplicationException && ((TApplicationException) e).getType() == TApplicationException.MISSING_RESULT)
			{
				return 0;
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

	@Override
	public int removeBankById(int id) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).removeBankById(id);
		} catch (TException e) {
			if (e instanceof TApplicationException && ((TApplicationException) e).getType() == TApplicationException.MISSING_RESULT)
			{
				return 0;
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

	@Override
	public int modifyBankById(int id, BankThrift bankThrift) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).modifyBankById(id,bankThrift);
		} catch (TException e) {
			if (e instanceof TApplicationException && ((TApplicationException) e).getType() == TApplicationException.MISSING_RESULT)
			{
				return 0;
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

	@Override
	public BankThrift getBankById(int id) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).getBankById(id);
		} catch (TException e) {
			if (e instanceof TApplicationException && ((TApplicationException) e).getType() == TApplicationException.MISSING_RESULT)
			{
				return null;
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

	@Override
	public List<BankThrift> getBankList() throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).getBankList() ;
		} catch (TException e) {
			if (e instanceof TApplicationException && ((TApplicationException) e).getType() == TApplicationException.MISSING_RESULT)
			{
				return null;
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

	@Override
	public int addBankGroup(List<BankGroupThrift> listBankGroup)
			throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).addBankGroup(listBankGroup);
		} catch (TException e) {
			if (e instanceof TApplicationException && ((TApplicationException) e).getType() == TApplicationException.MISSING_RESULT)
			{
				return 0;
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

	@Override
	public int removeBankGroupById(int id) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).removeBankGroupById(id);
		} catch (TException e) {
			if (e instanceof TApplicationException && ((TApplicationException) e).getType() == TApplicationException.MISSING_RESULT)
			{
				return 0;
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

	@Override
	public int modifyBankGroupById(int id, BankGroupThrift bankGroupThrift)
			throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).modifyBankGroupById(id,bankGroupThrift);
		} catch (TException e) {
			if (e instanceof TApplicationException && ((TApplicationException) e).getType() == TApplicationException.MISSING_RESULT)
			{
				return 0;
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

	@Override
	public List<BankGroupThrift> getBankGroupList(int type,String bankCode) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).getBankGroupList(type,bankCode);
		} catch (TException e) {
			if (e instanceof TApplicationException && ((TApplicationException) e).getType() == TApplicationException.MISSING_RESULT)
			{
				return null;
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

	@Override
	public List<BankThrift> getBankGroupByType(int type) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).getBankGroupByType(type);
		} catch (TException e) {
			if (e instanceof TApplicationException && ((TApplicationException) e).getType() == TApplicationException.MISSING_RESULT)
			{
				return null;
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

	@Override
	public BankGroupThrift getBankGroupById(int id) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).getBankGroupById(id);
		} catch (TException e) {
			if (e instanceof TApplicationException && ((TApplicationException) e).getType() == TApplicationException.MISSING_RESULT)
			{
				return null;
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

	@Override
	public List<BankThrift> getBankListById(List<Integer> id) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).getBankListById(id);
		} catch (TException e) {
			if (e instanceof TApplicationException && ((TApplicationException) e).getType() == TApplicationException.MISSING_RESULT)
			{
				return null;
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

	@Override
	public List<BankThrift> findBankByGroup(int type, String bankCode)throws TException{
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).findBankByGroup(type, bankCode);
		} catch (TException e) {
			if (e instanceof TApplicationException && ((TApplicationException) e).getType() == TApplicationException.MISSING_RESULT)
			{
				return null;
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

	@Override
	public List<BankThrift> findBankByParams(int id, String bankName,
			String bankNameAbbr) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).findBankByParams(id, bankName, bankNameAbbr);
		} catch (TException e) {
			if (e instanceof TApplicationException && ((TApplicationException) e).getType() == TApplicationException.MISSING_RESULT)
			{
				return null;
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
