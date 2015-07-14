package com.youguu.asteroid.rpc.common;

import com.youguu.asteroid.rpc.server.activity.ActivityLotteryThriftRpcServiceImpl;
import com.youguu.asteroid.rpc.server.ad.AdWallThriftRpcServiceImpl;
import com.youguu.asteroid.rpc.server.bank.BankThriftRpcServiceImpl;
import com.youguu.asteroid.rpc.server.sec.SecThriftRpcServiceImpl;
import com.youguu.asteroid.rpc.server.func.FuncThriftRpcServiceImpl;
import com.youguu.asteroid.rpc.server.fund.FundThriftRpcServiceImpl;
import com.youguu.asteroid.rpc.server.tool.ToolThriftRpcServiceImpl;
import com.youguu.asteroid.rpc.server.tradeday.TradeDayThriftRpcServiceImpl;
import com.youguu.asteroid.rpc.server.windvane.WindVaneThriftRpcServiceImpl;
import com.youguu.asteroid.rpc.server.word.WordThriftRpcServiceImpl;
import com.youguu.asteroid.rpc.server.wxgift.WxgiftThriftRpcServiceImpl;
import com.youguu.asteroid.rpc.thrift.gen.WordThriftRpcService.Client;
import com.youguu.asteroid.rpc.thrift.gen.WordThriftRpcService.Iface;
import com.youguu.asteroid.rpc.thrift.gen.WordThriftRpcService.Processor;

/**
 * 
 * @ClassName: MultiplexProp
 * @Description: 对应的客户端，服务端
 * @author zhanglei
 * @date 2014年11月6日 上午11:14:46
 *
 */
public enum MultiplexProp {
	
	WordThriftRpcService("WordThriftRpcService",
						Client.class,
						Processor.class,
						Iface.class,
						WordThriftRpcServiceImpl.class),
	TradeDayThriftRpcService("TradeDayThriftRpcService",
			com.youguu.asteroid.rpc.thrift.gen.TradeDayThriftRpcService.Client.class,
			com.youguu.asteroid.rpc.thrift.gen.TradeDayThriftRpcService.Processor.class,
			com.youguu.asteroid.rpc.thrift.gen.TradeDayThriftRpcService.Iface.class,
			TradeDayThriftRpcServiceImpl.class),
			
	WindVaneThriftRpcService("WindVaneThriftRpcService",
			com.youguu.asteroid.rpc.thrift.gen.WindVaneThriftRpcService.Client.class,
			com.youguu.asteroid.rpc.thrift.gen.WindVaneThriftRpcService.Processor.class,
			com.youguu.asteroid.rpc.thrift.gen.WindVaneThriftRpcService.Iface.class,
			WindVaneThriftRpcServiceImpl.class),
			
	ToolThriftRpcService("ToolThriftRpcService",
			com.youguu.asteroid.rpc.thrift.gen.ToolThriftRpcService.Client.class,
			com.youguu.asteroid.rpc.thrift.gen.ToolThriftRpcService.Processor.class,
			com.youguu.asteroid.rpc.thrift.gen.ToolThriftRpcService.Iface.class,
			ToolThriftRpcServiceImpl.class),
	AdWallThriftRpcService("AdWallThriftRpcService",
			com.youguu.asteroid.rpc.thrift.gen.AdWallThriftRpcService.Client.class,
			com.youguu.asteroid.rpc.thrift.gen.AdWallThriftRpcService.Processor.class,
			com.youguu.asteroid.rpc.thrift.gen.AdWallThriftRpcService.Iface.class,
			AdWallThriftRpcServiceImpl.class),
	WxgiftRPCService("WxgiftRPCService",
			com.youguu.asteroid.rpc.thrift.gen.WxgiftThriftRpcService.Client.class,
			com.youguu.asteroid.rpc.thrift.gen.WxgiftThriftRpcService.Processor.class,
			com.youguu.asteroid.rpc.thrift.gen.WxgiftThriftRpcService.Iface.class,
			WxgiftThriftRpcServiceImpl.class),
	ActivityLotteryThriftRpcService("ActivityLotteryThriftRpcService",
			com.youguu.asteroid.rpc.thrift.gen.ActivityLotteryThriftRpcService.Client.class,
			com.youguu.asteroid.rpc.thrift.gen.ActivityLotteryThriftRpcService.Processor.class,
			com.youguu.asteroid.rpc.thrift.gen.ActivityLotteryThriftRpcService.Iface.class,
			ActivityLotteryThriftRpcServiceImpl.class),
	BankRPCService("BankRPCService",
			com.youguu.asteroid.rpc.thrift.gen.BankThriftRpcService.Client.class,
			com.youguu.asteroid.rpc.thrift.gen.BankThriftRpcService.Processor.class,
			com.youguu.asteroid.rpc.thrift.gen.BankThriftRpcService.Iface.class,
			BankThriftRpcServiceImpl.class
			),
	SecRPCService("SecRPCService",
			com.youguu.asteroid.rpc.thrift.gen.SecThriftRpcService.Client.class,
			com.youguu.asteroid.rpc.thrift.gen.SecThriftRpcService.Processor.class,
			com.youguu.asteroid.rpc.thrift.gen.SecThriftRpcService.Iface.class,
			SecThriftRpcServiceImpl.class
			),
	FundRPCService("FundRPCService",
			com.youguu.asteroid.rpc.thrift.gen.FundService.Client.class,
			com.youguu.asteroid.rpc.thrift.gen.FundService.Processor.class,
			com.youguu.asteroid.rpc.thrift.gen.FundService.Iface.class,
			FundThriftRpcServiceImpl.class
			),
	FuncThriftRpcService("FuncThriftRpcService",
			com.youguu.asteroid.rpc.thrift.gen.FuncThriftRpcService.Client.class,
			com.youguu.asteroid.rpc.thrift.gen.FuncThriftRpcService.Processor.class,
			com.youguu.asteroid.rpc.thrift.gen.FuncThriftRpcService.Iface.class,
			FuncThriftRpcServiceImpl.class
			);
	
	Class<?> processor;
	
	Class<?> client;
	
	Class<?> iface;
	
	Class<?> impl;
	
	private String name;
	
	MultiplexProp(String name,Class<?> client,Class<?> processor,Class<?> iface,Class<?> impl){
		this.processor = processor;
		this.client = client;
		this.name = name;
		this.iface = iface;
		this.impl = impl;
	}

	public Class<?> getProcessor() {
		return processor;
	}

	public void setProcessor(Class<?> processor) {
		this.processor = processor;
	}

	public Class<?> getClient() {
		return client;
	}

	public void setClient(Class<?> client) {
		this.client = client;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Class<?> getIface() {
		return iface;
	}

	public void setIface(Class<?> iface) {
		this.iface = iface;
	}

	public Class<?> getImpl() {
		return impl;
	}

	public void setImpl(Class<?> impl) {
		this.impl = impl;
	}
}
