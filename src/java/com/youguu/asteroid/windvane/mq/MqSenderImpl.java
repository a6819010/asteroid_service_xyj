package com.youguu.asteroid.windvane.mq;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;



import com.alibaba.fastjson.JSONObject;
import com.youguu.asteroid.windvane.pojo.MqSystemNotice;
import com.youguu.asteroid.windvane.util.Constants;
import com.youguu.jms.handler.IMqHandler;
import com.youguu.jms.handler.MqHandlerProvider;
import com.youguu.jms.pojo.Message;
import com.youguu.member.client.service.impl.AsyncMemberRpcServiceImpl;

@Service("mqSender")
public class MqSenderImpl implements IMqSender {
	
	@Resource
	private AsyncMemberRpcServiceImpl asyncMemberRpcService;

	@Override
	public boolean doTask(int uid,String taskId) {
		int num = asyncMemberRpcService.doTask(uid, taskId);
		return num == 1 ? true : false;
	}

	@Override
	public boolean sendSystemNotice(MqSystemNotice mqSystemNotice) {
		Message<MqSystemNotice> dd = new Message<MqSystemNotice>(1, mqSystemNotice);
	    IMqHandler handler = MqHandlerProvider.get("assist");
	    return handler.sendMsg(dd);
	}
	
	@Override
	public boolean sendMsg(int uid, String date, int type) {
		JSONObject obj = new JSONObject();
		obj.put("uid", uid);
		obj.put("date", date);
		obj.put("type", type);
		Message<JSONObject> dd = new Message<JSONObject>(Constants.UPDATEMARKETPOLLVOTE, obj);
		IMqHandler handler = MqHandlerProvider.get(Constants.MQ_QUEUE);
		return handler.sendMsg(dd);
	}

}
