package test.rpc;

import org.apache.ibatis.cache.Cache;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youguu.asteroid.base.ContextLoader;
import com.youguu.asteroid.tradeday.cache.CloseDayCache;

public class CacheTradeTest {
	class DataGet extends Thread{
		public void run(){
			for(int i=0;i<10000;i++){
				CloseDayCache.getCache().getDaySet();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args){
		ApplicationContext app = new AnnotationConfigApplicationContext(ContextLoader.class);
		CloseDayCache.getCache().getDaySet();
		CacheTradeTest ctt = new CacheTradeTest();
		for(int i=0;i<1000;i++){
			DataGet dg = ctt.new DataGet();
			dg.start();
		}
		
		
//		while(true){
//			CloseDayCache.getCache().setDate();
//			try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	}
}
