package com.youguu.asteroid.rpc.server;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.thrift.TMultiplexedProcessor;
import org.apache.thrift.TProcessor;
import org.apache.thrift.transport.TTransportException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youguu.asteroid.base.ContextLoader;
import com.youguu.asteroid.rpc.common.MultiplexProp;
import com.youguu.asteroid.tradeday.cache.CloseDayCache;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.core.util.PropertiesUtil;
import com.youguu.core.util.rpc.ThriftRpcServer;

/**
 * 
 * @ClassName: BootStrap
 * @Description: rpc server 启动入口
 * @author zhanglei
 * @date 2014年11月6日 上午11:17:37
 *
 */
public class BootStrap {
	private static final Log logger = LogFactory.getLog(BootStrap.class);
	
	public static void main(String[] args) {
		
		ApplicationContext app = new AnnotationConfigApplicationContext(ContextLoader.class);
		
		TMultiplexedProcessor processor = new TMultiplexedProcessor();
		
		for(MultiplexProp prop:MultiplexProp.values()){
			try {
				Constructor<?> cons = prop.getProcessor().getConstructor(prop.getIface());
				
				processor.registerProcessor( prop.getName() , (TProcessor) cons.newInstance(app.getBean(prop.getImpl())));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		Properties prop = null;
		try {
			prop = PropertiesUtil.getProperties("properties/asteroid_rpc_server.properties");
			if(null==prop){
				logger.error("没有找到启动文件：asteroid_rpc_server.properties");
				return;
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		String host = prop.getProperty("asteroid.rpc.host.name").trim();
		int hostPort = Integer.valueOf(prop.getProperty("asteroid.rpc.host.port").trim()).intValue();
		int workerThreads = Integer.valueOf(prop.getProperty("asteroid.rpc.server.workerThreads")).intValue();
        
		ThriftRpcServer server = new ThriftRpcServer(
				host, 
				hostPort, 
				workerThreads, 
				processor);

        
		try {
			CloseDayCache.getCache().load();
			CloseDayCache.getCache().resetCacheDate();
			server.start();
		} catch (TTransportException e) {
			e.printStackTrace();
		}
       


	}

}
