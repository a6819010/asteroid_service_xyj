package com.youguu.asteroid.rpc.client.windvane;

import java.util.List;
import java.util.Map;

import org.apache.thrift.TException;

import com.youguu.asteroid.rpc.common.ClassCast;
import com.youguu.asteroid.rpc.common.Constants;
import com.youguu.asteroid.windvane.pojo.MarketWindVanePollVote;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;

/**
* @Title: WindVaneRPCServiceImpl.java 
* @Package com.youguu.asteroid.rpc.client.windvane 
* @Description: 风向标service接口实现类,RPC 
* @author 徐云杰
* @date 2014年12月4日 下午4:02:34 
* @version V1.0
 */
public class WindVaneRPCServiceImpl implements IWindVaneRPCService {
	
private static final Log logger = LogFactory.getLog(Constants.ASTEROIDRPC_CLIENT);
	
	private WindVaneClient getClient(){
		return new WindVaneClient();
	}

	@Override
	public MarketWindVanePollVote getMarketWindVanePollVote(String date) {
		try {
			return ClassCast.thriftToPojo(getClient().getMarketWindVanePollVote(date));
		} catch (TException e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public int updateMarketWindVanePollVote(
			MarketWindVanePollVote marketWindVanePollVote) {
		try {
			return getClient().updateMarketWindVanePollVote(ClassCast.pojoToThrift(marketWindVanePollVote));
		} catch (TException e) {
			logger.error(e.getMessage(), e);
			return -1;
		}
	}

	@Override
	public int closeClear() {
		try {
			return getClient().closeClear();
		} catch (TException e) {
			logger.error(e.getMessage(), e);
			return -1;
		}
	}

	@Override
	public Map<String, String> findWindVane(int uid) {
		try {
			return getClient().findWindVane(uid);
		} catch (TException e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public int vote(int uid, int voteflag) {
		try {
			return getClient().vote(uid, voteflag);
		} catch (TException e) {
			logger.error(e.getMessage(), e);
			return -1;
		}
	}

	@Override
	public Map<String, List<Double>> cowThanBear() {
		try {
			return getClient().cowThanBear();
		} catch (TException e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public List<String> getNDaysWindVaneTime(int daynum) {
		try {
			return getClient().getNDaysWindVaneTime(daynum);
		} catch (TException e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

}
