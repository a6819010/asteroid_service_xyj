package com.youguu.asteroid.windvane.mq;

import com.youguu.asteroid.windvane.pojo.MqSystemNotice;

/**
 * 
* @Title: IMqSender.java 
* @Package com.youguu.asteroid.windvane.mq 
* @Description: MQ消息发送
* @author 徐云杰
* @date 2014年12月5日 下午7:31:27 
* @version V1.0
 */
public interface IMqSender {
	/**
		* @Title: 
		* @Description: 完成投票任务处理
		* @param 
		* @return 
		* @throws
	 */
	boolean doTask(int uid,String taskId);
	
	/**
		* @Title: 
		* @Description: 发送系统消息
		* @param 
		* @return 
		* @throws
	 */
	boolean sendSystemNotice(MqSystemNotice mqSystemNotice);
	
	/**
		* @Title: 
		* @Description: 向MQ队列发送消息，累加统计投票用
		* @param 
		* @return 
		* @throws
	 */
	boolean sendMsg(int uid,String date,int type);
	
}
