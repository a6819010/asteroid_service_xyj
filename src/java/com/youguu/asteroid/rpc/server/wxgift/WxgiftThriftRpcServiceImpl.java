package com.youguu.asteroid.rpc.server.wxgift;

import javax.annotation.Resource;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import com.youguu.asteroid.rpc.common.Constants;
import com.youguu.asteroid.rpc.thrift.gen.WxgiftThriftRpcService.Iface;
import com.youguu.asteroid.wxgift.service.IWxgiftService;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
@Service("wxgiftThriftRpcService")
public class WxgiftThriftRpcServiceImpl implements Iface {
	private static final Log logger = LogFactory.getLog(Constants.ASTEROIDRPC_SERVER);
	
	@Resource
	private IWxgiftService wxgiftService;
	@Override
	public String queryStatus(String openid, String hopenid) throws TException {
		return wxgiftService.queryStatus(openid, hopenid).toJSONString();
	}

	@Override
	public int open(String openid, String hopenid) throws TException {
		return wxgiftService.open(openid, hopenid);
	}

	@Override
	public int phone(String openid, String phone) throws TException {
		return wxgiftService.phone(openid, phone);
	}

}
