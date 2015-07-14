package com.youguu.asteroid.rpc.client;

import com.youguu.asteroid.rpc.client.activity.ActivityLotteryRPCServiceImpl;
import com.youguu.asteroid.rpc.client.activity.IActivityLotteryRPCService;
import com.youguu.asteroid.rpc.client.ad.AdWallRPCServiceImpl;
import com.youguu.asteroid.rpc.client.ad.IAdWallRPCService;
import com.youguu.asteroid.rpc.client.bank.BankRPCServiceImpl;
import com.youguu.asteroid.rpc.client.bank.IBankRPCService;
import com.youguu.asteroid.rpc.client.sec.SecRPCService;
import com.youguu.asteroid.rpc.client.sec.SecRPCServiceImpl;
import com.youguu.asteroid.rpc.client.func.FuncRPCServiceImpl;
import com.youguu.asteroid.rpc.client.func.IFuncRPCService;
import com.youguu.asteroid.rpc.client.fund.FundRPCServiceImpl;
import com.youguu.asteroid.rpc.client.fund.IFundRPCService;
import com.youguu.asteroid.rpc.client.tool.IToolRPCService;
import com.youguu.asteroid.rpc.client.tool.ToolRPCServiceImpl;
import com.youguu.asteroid.rpc.client.tradeday.ITradeDayRPCService;
import com.youguu.asteroid.rpc.client.tradeday.TradeDayRPCServiceImpl;
import com.youguu.asteroid.rpc.client.windvane.IWindVaneRPCService;
import com.youguu.asteroid.rpc.client.windvane.WindVaneRPCServiceImpl;
import com.youguu.asteroid.rpc.client.word.ISensitiveWordRPCService;
import com.youguu.asteroid.rpc.client.word.SensitiveWordRPCServiceImpl;
import com.youguu.asteroid.rpc.client.wxgift.IWxgiftRPCService;
import com.youguu.asteroid.rpc.client.wxgift.WxgiftRPCServiceImpl;

/**
 * 
 * @ClassName: AsteroidRPCClientFactory
 * @Description: rpc client端工厂类
 * @author zhanglei
 * @date 2014年11月6日 下午1:56:07
 *
 */
public class AsteroidRPCClientFactory {
	private static ISensitiveWordRPCService sensitiveWordRPCService = null;
	
	private static ITradeDayRPCService tradeDayRPCService = null;
	
	private static IWindVaneRPCService windVaneRPCService = null;
	
	private static IToolRPCService toolRPCService = null;
	
	private static IAdWallRPCService adWallRPCService = null;
	
	private static IWxgiftRPCService wxgiftRPCService = null;
	
	private static IActivityLotteryRPCService activityLotteryRPCService = null;
	
	private static IBankRPCService bankRPCService = null;
	
	private static SecRPCService secRPCService=null;
	private static IFundRPCService fundRPCService = null;
	private static IFuncRPCService funcRPCService = null;
	
	/**
	 * 
	* @Title: getSensitiveWordRPCService
	* @Description: 获取敏感词操作
	* @param @return    
	* @return ISensitiveWordRPCService    返回类型
	* @throws
	 */
	public static ISensitiveWordRPCService getSensitiveWordRPCService(){
		if(sensitiveWordRPCService != null){
			return sensitiveWordRPCService;
		}else{
			synchronized (AsteroidRPCClientFactory.class) {
				if(sensitiveWordRPCService != null){
					return sensitiveWordRPCService;
				}else{
					sensitiveWordRPCService = new SensitiveWordRPCServiceImpl();
				}
			}
		}
		return sensitiveWordRPCService;
	}
	
	/**
	 * 
	* @Title: getSensitiveWordRPCService
	* @Description: 获取交易日RPC客户端service
	* @param @return    
	* @return ISensitiveWordRPCService    返回类型
	* @throws
	 */
	public static ITradeDayRPCService getTradeDayRPCService(){
		if(tradeDayRPCService != null){
			return tradeDayRPCService;
		}else{
			synchronized (AsteroidRPCClientFactory.class) {
				if(tradeDayRPCService != null){
					return tradeDayRPCService;
				}else{
					tradeDayRPCService = new TradeDayRPCServiceImpl();
				}
			}
		}
		return tradeDayRPCService;
	}
	
	/**
	 * 
	* @Title: getWindVaneRPCService
	* @Description: 获取风向标RPC客户端service
	* @param @return    
	* @return IWindVaneRPCService    返回类型
	* @throws
	 */
	public static IWindVaneRPCService getWindVaneRPCService(){
		if(windVaneRPCService != null){
			return windVaneRPCService;
		}else{
			synchronized (AsteroidRPCClientFactory.class) {
				if(windVaneRPCService != null){
					return windVaneRPCService;
				}else{
					windVaneRPCService = new WindVaneRPCServiceImpl();
				}
			}
		}
		return windVaneRPCService;
	}
	/**
	* @Title: getToolRPCService 
	* @Description: 获取工具箱RPC客户端 
	* @param @return    设定文件 
	* @return IToolRPCService    返回类型 
	* @throws
	 */
	public static IToolRPCService getToolRPCService(){
		if(toolRPCService != null){
			return toolRPCService;
		}else{
			synchronized (AsteroidRPCClientFactory.class) {
				if(toolRPCService != null){
					return toolRPCService;
				}else{
					toolRPCService = new ToolRPCServiceImpl();
				}
			}
		}
		return toolRPCService;
	}
	
	/**
	 * 
	* @Title: getAdWallRPCService
	* @Description: 模拟炒股广告墙RPC客户端service
	* @return    
	* IAdWallRPCService    返回类型
	* @throws
	 */
	public static IAdWallRPCService getAdWallRPCService(){
		if(adWallRPCService != null){
			return adWallRPCService;
		}else{
			synchronized (AsteroidRPCClientFactory.class) {
				if(adWallRPCService != null){
					return adWallRPCService;
				}else{
					adWallRPCService = new AdWallRPCServiceImpl();
				}
			}
		}
		return adWallRPCService;
	}
	
	
	/**
	 * 
	* @Title: getAdWallRPCService
	* @Description: 获取微信礼包
	* @return    
	* IAdWallRPCService    返回类型
	* @throws
	 */
	public static IWxgiftRPCService getWxgiftRPCService(){
		if(wxgiftRPCService != null){
			return wxgiftRPCService;
		}else{
			synchronized (AsteroidRPCClientFactory.class) {
				if(wxgiftRPCService != null){
					return wxgiftRPCService;
				}else{
					wxgiftRPCService = new WxgiftRPCServiceImpl();
				}
			}
		}
		return wxgiftRPCService;
	}
	
	/**
	 * 
	* @Title: getActivityLotteryRPCService
	* @Description: 获取活动抽奖RPC服务
	* @return    
	* IActivityLotteryRPCService    返回类型
	* @throws
	 */
	public static IActivityLotteryRPCService getActivityLotteryRPCService(){
		if(activityLotteryRPCService != null){
			return activityLotteryRPCService;
		}else{
			synchronized (AsteroidRPCClientFactory.class) {
				if(activityLotteryRPCService != null){
					return activityLotteryRPCService;
				}else{
					activityLotteryRPCService = new ActivityLotteryRPCServiceImpl();
				}
			}
		}
		return activityLotteryRPCService;
	}
	
	public static IBankRPCService getBankRPCService(){
		if(bankRPCService != null){
			return bankRPCService;
		}else{
			synchronized (AsteroidRPCClientFactory.class) {
				if(bankRPCService != null){
					return bankRPCService;
				}else{
					bankRPCService = new BankRPCServiceImpl();
				}
			}
		}
		return bankRPCService;
	}
	
	public static SecRPCService getSecRPCService(){
		if(secRPCService != null){
			return secRPCService;
		}else{
			synchronized (AsteroidRPCClientFactory.class) {
				if(secRPCService != null){
					return secRPCService;
				}else{
					secRPCService = new SecRPCServiceImpl();
				}
			}
		}
		return secRPCService;
	}
	public static IFundRPCService getFunRPCService(){
		if(fundRPCService != null){
			return fundRPCService;
		}else{
			synchronized (AsteroidRPCClientFactory.class) {
				if(fundRPCService != null){
					return fundRPCService;
				}else{
					fundRPCService = new FundRPCServiceImpl();
				}
			}
		}
		return fundRPCService;
	}
	
	public static IFuncRPCService getFuncRPCService(){
		if(funcRPCService != null){
			return funcRPCService;
		}else{
			synchronized (AsteroidRPCClientFactory.class) {
				if(funcRPCService != null){
					return funcRPCService;
				}else{
					funcRPCService = new FuncRPCServiceImpl();
				}
			}
		}
		return funcRPCService;
	}
}
