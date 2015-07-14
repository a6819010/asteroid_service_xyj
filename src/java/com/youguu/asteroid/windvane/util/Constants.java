package com.youguu.asteroid.windvane.util;

/**
* @Title: Constants.java 
* @Package com.youguu.asteroid.windvane.util 
* @Description: 市场风向标常量定义类
* @author 徐云杰
* @date 2014年12月2日 下午6:27:38 
* @version V1.0
 */
public class Constants {
	/**
	 * 上涨
	 */
	public static final int UP = 1;
	
	/**
	 * 下跌
	 */
	public static final int DOWN = 2;
	
	/**
	 * 涨跌默认状态
	 */
	public static final int DEF = 0;
	
	/**
	 * 可投期
	 */
	public static final String VOTESTATUS_YES = "2";
	
	/**
	 * 禁投期
	 */
	public static final String VOTESTATUS_NO = "1";
	
	/**
	 * 用户已投票
	 */
	public static final String USERSTATUS_NO = "1";
	
	/**
	 * 用户未投票
	 */
	public static final String USERSTATUS_YES = "2";
	
	/**
	 * 更新统投数据
	 */
	public static final int UPDATEMARKETPOLLVOTE = 1;
	
	/**
	 * 风向标mq队列
	 */
	public static final String MQ_QUEUE = "market_wind";
	
	/**
	 * 投票预测正确标题
	 */
	public static final String WINDVANE_TITLE = "竞猜获胜";
	
	/**
	 * 投票预测正确文案
	 */
	public static final String WINDVANE_CONTENT = "恭喜你，在%s日的大盘竞猜中你与%s的用户一同竞猜获胜，奖励您10金币，快去宝箱中查看吧";
	
	/**
	 * 结算单批执行数量
	 */
	public static final int EXECUTE_NUM = 1000;
	
	/**
	 * 结算提交数量
	 */
	public static final int COMMIT_NUM = 500;

}
