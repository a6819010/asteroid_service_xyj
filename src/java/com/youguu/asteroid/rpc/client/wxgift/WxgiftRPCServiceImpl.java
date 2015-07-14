package com.youguu.asteroid.rpc.client.wxgift;

import org.apache.thrift.TException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.youguu.asteroid.rpc.common.Constants;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;

public class WxgiftRPCServiceImpl implements IWxgiftRPCService {
	
	private static final Log logger = LogFactory.getLog(Constants.ASTEROIDRPC_CLIENT);
	
	private WxgiftClient getClient(){
		return new WxgiftClient();
	}
	
	@Override
	public JSONObject queryStatus(String openid, String hopenid) {
		String result = null;
		try {
			result = getClient().queryStatus(openid, hopenid);
		} catch (TException e) {
			e.printStackTrace();
		}
		return JSON.parseObject(result);
	}

	@Override
	public int open(String openid, String hopenid) {
		
		try {
			return getClient().open(openid, hopenid);
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
		
	}

	@Override
	public int phone(String openid, String phone) {
		try {
			return getClient().phone(openid, phone);
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
	}

}
