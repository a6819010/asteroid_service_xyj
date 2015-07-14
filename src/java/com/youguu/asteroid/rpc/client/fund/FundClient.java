package com.youguu.asteroid.rpc.client.fund;

import java.util.List;

import org.apache.thrift.TApplicationException;
import org.apache.thrift.TException;

import com.youguu.asteroid.rpc.common.Constants;
import com.youguu.asteroid.rpc.thrift.gen.FundConvertThrift;
import com.youguu.asteroid.rpc.thrift.gen.FundDivThrift;
import com.youguu.asteroid.rpc.thrift.gen.FundService.Client;
import com.youguu.asteroid.rpc.thrift.gen.FundService.Iface;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.core.util.RPCServiceClient;
import com.youguu.core.util.rpc.multipex.RPCMultiplexConnection;
import com.youguu.core.util.rpc.multipex.RPCMultiplexPool;

public class FundClient implements Iface{

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
	public List<FundConvertThrift> queryFundConvert(String fundCode, String regDateStart, String regDateEnd,
			String convertDateStart, String convertDateEnd, int convertType,
			int status, int pageStart, int pageSize) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).queryFundConvert(fundCode, regDateStart, regDateEnd, convertDateStart, convertDateEnd, convertType, status, pageStart, pageSize);
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

	@Override
	public int insertFundConvert(FundConvertThrift fund) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).insertFundConvert(fund);
		} catch (Exception e) {
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
	public int updateFundConvert(FundConvertThrift fund) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).updateFundConvert(fund);
		} catch (Exception e) {
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
	public int deleteFundConvert(int id) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).deleteFundConvert(id);
		} catch (Exception e) {
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
	public List<FundDivThrift> queryFundDiv(String fundCode,
			String regDateStart, String regDateEnd, String convertDateStart,
			String convertDateEnd, int divType, int status, int pageStart,
			int pageSize) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).queryFundDiv(fundCode,regDateStart, regDateEnd, convertDateStart, convertDateEnd, divType, status, pageStart, pageSize);
		} catch (Exception e) {
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
	public int insertFundDiv(FundDivThrift fund) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).insertFundDiv(fund);
		} catch (Exception e) {
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
	public int updateFundDiv(FundDivThrift fund) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).updateFundDiv(fund);
		} catch (Exception e) {
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
	public int deleteFundDiv(int id) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).deleteFundDiv(id);
		} catch (Exception e) {
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
	public FundConvertThrift findCById(int id) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).findCById(id);
		} catch (Exception e) {
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
	public FundDivThrift findDById(int id) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).findDById(id);
		} catch (Exception e) {
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
