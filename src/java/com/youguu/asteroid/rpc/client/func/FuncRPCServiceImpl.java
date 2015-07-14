package com.youguu.asteroid.rpc.client.func;

import java.util.List;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import com.youguu.asteroid.rpc.common.Constants;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;


@Service("funcRPCService")
public class FuncRPCServiceImpl implements IFuncRPCService {

	private static final Log logger = LogFactory.getLog(Constants.ASTEROIDRPC_CLIENT);
	public FuncClient getClient(){
		return new FuncClient();
	}
	
	@Override
	public List<String> queryFunc(String ak) {
		try {
			return getClient().queryFunc(ak);
		} catch (TException e) {
			logger.error(e);
		}
		return null;
	}

}
