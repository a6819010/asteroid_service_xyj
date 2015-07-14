package com.youguu.asteroid.rpc.server.func;

import java.util.List;

import javax.annotation.Resource;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import com.youguu.asteroid.func.service.IFuncService;
import com.youguu.asteroid.rpc.thrift.gen.FuncThriftRpcService.Iface;

@Service("funcThriftRpcService")
public class FuncThriftRpcServiceImpl implements Iface {

	@Resource
	private IFuncService ifuncS;
	
	@Override
	public List<String> queryFunc(String ak) throws TException {
		return ifuncS.queryFunc(ak);
	}

}
