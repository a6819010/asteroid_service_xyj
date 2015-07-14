package com.youguu.asteroid.rpc.common;




/**
 * 
 * @ClassName: ClientMultiplexProp
 * @Description: 对应的客户端
 * @author zhanglei
 * @date 2014年11月6日 上午10:32:55
 *
 */
public enum ClientMultiplexProp {

	WordThriftRpcService("WordThriftRpcService",
			com.youguu.asteroid.rpc.thrift.gen.WordThriftRpcService.Client.class,
			com.youguu.asteroid.rpc.thrift.gen.WordThriftRpcService.Processor.class,
			com.youguu.asteroid.rpc.thrift.gen.WordThriftRpcService.Iface.class),
	TradeDayThriftRpcService("TradeDayThriftRpcService",
					com.youguu.asteroid.rpc.thrift.gen.TradeDayThriftRpcService.Client.class,
					com.youguu.asteroid.rpc.thrift.gen.TradeDayThriftRpcService.Processor.class,
					com.youguu.asteroid.rpc.thrift.gen.TradeDayThriftRpcService.Iface.class),
	WindVaneThriftRpcService("WindVaneThriftRpcService",
			com.youguu.asteroid.rpc.thrift.gen.WindVaneThriftRpcService.Client.class,
			com.youguu.asteroid.rpc.thrift.gen.WindVaneThriftRpcService.Processor.class,
			com.youguu.asteroid.rpc.thrift.gen.WindVaneThriftRpcService.Iface.class),
	ToolThriftRpcService("ToolThriftRpcService",
					com.youguu.asteroid.rpc.thrift.gen.ToolThriftRpcService.Client.class,
					com.youguu.asteroid.rpc.thrift.gen.ToolThriftRpcService.Processor.class,
					com.youguu.asteroid.rpc.thrift.gen.ToolThriftRpcService.Iface.class),
	AdWallThriftRpcService("AdWallThriftRpcService",
			com.youguu.asteroid.rpc.thrift.gen.AdWallThriftRpcService.Client.class,
			com.youguu.asteroid.rpc.thrift.gen.AdWallThriftRpcService.Processor.class,
			com.youguu.asteroid.rpc.thrift.gen.AdWallThriftRpcService.Iface.class),
			
   WxgiftRPCService("WxgiftRPCService",
			com.youguu.asteroid.rpc.thrift.gen.WxgiftThriftRpcService.Client.class,
			com.youguu.asteroid.rpc.thrift.gen.WxgiftThriftRpcService.Processor.class,
			com.youguu.asteroid.rpc.thrift.gen.WxgiftThriftRpcService.Iface.class),
			
   ActivityLotteryThriftRpcService("ActivityLotteryThriftRpcService",
					com.youguu.asteroid.rpc.thrift.gen.ActivityLotteryThriftRpcService.Client.class,
					com.youguu.asteroid.rpc.thrift.gen.ActivityLotteryThriftRpcService.Processor.class,
					com.youguu.asteroid.rpc.thrift.gen.ActivityLotteryThriftRpcService.Iface.class),
	BankRPCService("BankRPCService",
					com.youguu.asteroid.rpc.thrift.gen.BankThriftRpcService.Client.class,
					com.youguu.asteroid.rpc.thrift.gen.BankThriftRpcService.Processor.class,
					com.youguu.asteroid.rpc.thrift.gen.BankThriftRpcService.Iface.class),
  SecRPCService("SecRPCService",
			com.youguu.asteroid.rpc.thrift.gen.SecThriftRpcService.Client.class,
			com.youguu.asteroid.rpc.thrift.gen.SecThriftRpcService.Processor.class,
			com.youguu.asteroid.rpc.thrift.gen.SecThriftRpcService.Iface.class),
	FundRPCService("FundRPCService",
					com.youguu.asteroid.rpc.thrift.gen.FundService.Client.class,
					com.youguu.asteroid.rpc.thrift.gen.FundService.Processor.class,
					com.youguu.asteroid.rpc.thrift.gen.FundService.Iface.class),
	FuncThriftRpcService("FuncThriftRpcService",
			com.youguu.asteroid.rpc.thrift.gen.FuncThriftRpcService.Client.class,
			com.youguu.asteroid.rpc.thrift.gen.FuncThriftRpcService.Processor.class,
			com.youguu.asteroid.rpc.thrift.gen.FuncThriftRpcService.Iface.class);
	
	
	
	Class<?> processor;

	Class<?> client;

	Class<?> iface;

	private String name;

	ClientMultiplexProp(String name,Class<?> client,Class<?> processor,Class<?> iface){
		this.processor = processor;
		this.client = client;
		this.name = name;
		this.iface = iface;
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

}
