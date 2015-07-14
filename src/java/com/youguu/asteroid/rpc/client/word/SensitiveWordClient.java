package com.youguu.asteroid.rpc.client.word;

import com.youguu.asteroid.rpc.common.Constants;
import com.youguu.asteroid.rpc.thrift.gen.SensitiveWordThrift;
import com.youguu.asteroid.rpc.thrift.gen.WordThriftRpcService.Client;
import com.youguu.asteroid.rpc.thrift.gen.WordThriftRpcService.Iface;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.core.util.RPCServiceClient;
import com.youguu.core.util.rpc.multipex.RPCMultiplexConnection;
import com.youguu.core.util.rpc.multipex.RPCMultiplexPool;
import org.apache.thrift.TException;

import java.nio.ByteBuffer;
/**
 * 
 * @ClassName: SensitiveWordClient
 * @Description: 敏感词rpc客户端
 * @author zhanglei
 * @date 2014年11月6日 下午2:02:11
 *
 */
public class SensitiveWordClient implements Iface {

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
	 * 添加敏感词
	 */
	@Override
	public int addSensitiveWord(String words) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).addSensitiveWord(words);
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
	 * 修改敏感词
	 */
	@Override
	public int updateSensitiveWord(SensitiveWordThrift word) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).updateSensitiveWord(word);
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
	 * 删除敏感词
	 */
	@Override
	public int deleteSensitiveWord(int id) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).deleteSensitiveWord(id);
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
	 * 获取敏感词
	 */
	@Override
	public SensitiveWordThrift getSensitiveWord(int id) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).getSensitiveWord(id);
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
	 * 分页查询敏感词
	 */
	@Override
	public ByteBuffer querySensitiveWordList(String word, int pageIndex,
			int pageSize) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).querySensitiveWordList(word, pageIndex, pageSize);
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
	public boolean isContainSensitiveWord(String text) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).isContainSensitiveWord(text);
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
	 * 刷新敏感词库
	 */
	@Override
	public boolean refreshSensitiveWord() throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).refreshSensitiveWord();
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
	public ByteBuffer getMatchedWords(String text) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).getMatchedWords(text);
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
	public String getStringByImg(ByteBuffer img) throws TException {
		RPCMultiplexConnection conn = null;
		try {
			conn = getConnection();
			return conn.getClient(Client.class).getStringByImg(img);
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
