package com.youguu.asteroid.rpc.server.windvane;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import com.youguu.asteroid.rpc.common.ClassCast;
import com.youguu.asteroid.rpc.common.Constants;
import com.youguu.asteroid.rpc.thrift.gen.MarketWindVanePollVoteThrift;
import com.youguu.asteroid.rpc.thrift.gen.WindVaneThriftRpcService.Iface;
import com.youguu.asteroid.windvane.service.impl.MarketWindVanePollVoteServiceImpl;
import com.youguu.asteroid.windvane.service.impl.WindVaneDisposeServiceImpl;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;

/**
* @Title: WindVaneThriftRpcServiceImpl.java 
* @Package com.youguu.asteroid.rpc.server.windvane 
* @Description: 风向标RPC服务端实现类
* @author 徐云杰
* @date 2014年12月4日 下午4:20:12 
* @version V1.0
 */
@Service("windVaneThriftRpcService")
public class WindVaneThriftRpcServiceImpl implements Iface {
	
	private static final Log logger = LogFactory.getLog(Constants.ASTEROIDRPC_SERVER);
	
	@Resource
	private MarketWindVanePollVoteServiceImpl marketWindVanePollVoteService;
	
	@Resource
	private WindVaneDisposeServiceImpl windVaneDisposeService;

	@Override
	public MarketWindVanePollVoteThrift getMarketWindVanePollVote(String date)
			throws TException {
		try {
			return ClassCast.pojoToThrift(marketWindVanePollVoteService.getMarketWindVanePollVote(date));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public int updateMarketWindVanePollVote(MarketWindVanePollVoteThrift mwv)
			throws TException {
		try {
			return marketWindVanePollVoteService.updateMarketWindVanePollVote(ClassCast.thriftToPojo(mwv));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return -1;
		}
	}

	@Override
	public int closeClear() throws TException {
		try {
			return windVaneDisposeService.closeClear();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return -1;
		}
	}

	@Override
	public Map<String, String> findWindVane(int uid) throws TException {
		try {
			return windVaneDisposeService.findWindVane(uid);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public int vote(int uid, int voteflag) throws TException {
		try {
			return windVaneDisposeService.vote(uid, voteflag);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return -1;
		}
	}

	@Override
	public Map<String, List<Double>> cowThanBear() throws TException {
		try {
			return windVaneDisposeService.cowThanBear();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public List<String> getNDaysWindVaneTime(int daynum) throws TException {
		try {
			return marketWindVanePollVoteService.getNDaysWindVaneTime(daynum);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

}
