package com.youguu.asteroid.windvane.service.impl;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.youguu.asteroid.tradeday.service.ITradeDayService;
import com.youguu.asteroid.windvane.mq.IMqSender;
import com.youguu.asteroid.windvane.pojo.MarketWindVanePollVote;
import com.youguu.asteroid.windvane.pojo.MqSystemNotice;
import com.youguu.asteroid.windvane.pojo.UserVoteDetail;
import com.youguu.asteroid.windvane.pojo.UserVoteDetailHis;
import com.youguu.asteroid.windvane.pojo.UserVoteRecord;
import com.youguu.asteroid.windvane.service.IMarketWindVanePollVoteService;
import com.youguu.asteroid.windvane.service.IUserVoteDetailHisService;
import com.youguu.asteroid.windvane.service.IUserVoteDetailService;
import com.youguu.asteroid.windvane.service.IUserVoteRecordService;
import com.youguu.asteroid.windvane.service.IWindVaneDisposeService;
import com.youguu.asteroid.windvane.util.Constants;
import com.youguu.core.util.Log4jUtil;
import com.youguu.core.util.PageHolder;
import com.youguu.mall.rpc.client.MallRPCClientFactory;
import com.youguu.mall.rpc.client.coin.UserCoinRPCService;
import com.youguu.quote.pojo.CurStatus;
import com.youguu.quote.pojo.KLine;
import com.youguu.quote.rpc.client.QuoteClient;
import com.youguu.taskmonitor.common.RunResultCode;
import com.youguu.taskmonitor.jetty.client.TaskJettyClient;

/**
 * 
 * @Title: WindVaneDisposeServiceImpl.java 
 * @Package com.youguu.asteroid.windvane.service.impl 
 * @Description: 供APP接口调用，提供风向标功能主要方法的实现类
 * @author 徐云杰
 * @date 2014年12月2日 上午9:31:38 
 * @version V1.0
 */
@Service("windVaneDisposeService")
public class WindVaneDisposeServiceImpl implements IWindVaneDisposeService {

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	private SimpleDateFormat sdfs = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat sdfH = new SimpleDateFormat("HH");
	private NumberFormat nFormat=NumberFormat.getPercentInstance();
	private static Logger log = Log4jUtil.getLogger("windVane");

	@Resource
	private IMqSender mqSender;

	@Resource
	private IUserVoteDetailService userVoteDetailService;

	@Resource
	private IUserVoteDetailHisService userVoteDetailHisService;

	@Resource
	private IMarketWindVanePollVoteService marketWindVanePollVoteService;

	@Resource
	private ITradeDayService tradeDayService;

	@Resource
	private IUserVoteRecordService userVoteRecordService;

	private UserCoinRPCService userCoinRPCService = MallRPCClientFactory.getUserCoinRPCService();

	@Override
	public Map<String, String> findWindVane(int uid) {
		Map<String,String> map = new HashMap<String,String>();
		nFormat.setMaximumFractionDigits(2);//设置小数位数
		nFormat.setMaximumIntegerDigits(3);//设置整数位数
		String voteStatus=Constants.VOTESTATUS_YES;//是否可投票 1：禁投期  2：可投期
		String userStatus=Constants.USERSTATUS_YES;//用户是否投票 1：已投  2：未投
		String up = "5";//看涨人数
		String down = "5";//看跌人数
		String upstr = "0.5";//看涨百分比
		String downstr = "0.5";//看跌百分比
		try {
			//获取交易日
			String nowDate = this.getTradeDay();
			if(nowDate != null && !"".equals(nowDate))
			{
				//获取当前时间的小时位数
				int time = Integer.valueOf(sdfH.format(new Date()));

				//如果小时位数大于等于10并且小于16的话证明投票处于锁定期内
				if(time >= 10 && time < 16)
					voteStatus = Constants.VOTESTATUS_NO;
				else
					voteStatus = Constants.VOTESTATUS_YES;

				if(voteStatus.equals(Constants.VOTESTATUS_YES))
				{
					if(uid > 0)
					{
						UserVoteDetail uvd = userVoteDetailService.getUserVoteDetail(nowDate,uid);
						if(uvd != null)
							userStatus = Constants.USERSTATUS_NO;
						else
							userStatus = Constants.USERSTATUS_YES;
					}
				}

				//查询当前统投
				MarketWindVanePollVote  mwv = marketWindVanePollVoteService.getMarketWindVanePollVote(nowDate);
				if(mwv != null)
				{
					up = String.valueOf(mwv.getUp());
					down = String.valueOf(mwv.getDown());
					//upstr = nFormat.format((float)mwv.getUp() / (float)mwv.getNum());
					//downstr = nFormat.format(1 - (float)mwv.getUp() / (float)mwv.getNum());
					upstr = String.valueOf((float)mwv.getUp() / (float)mwv.getNum());
					downstr = String.valueOf(1 - (float)mwv.getUp() / (float)mwv.getNum());
				}
				else
				{
					//增加新的预测统投
					createNewVote();
					mwv = marketWindVanePollVoteService.getMarketWindVanePollVote(nowDate);
					if(mwv != null)
					{
						up = String.valueOf(mwv.getUp());
						down = String.valueOf(mwv.getDown());
						upstr = String.valueOf((float)mwv.getUp() / (float)mwv.getNum());
						downstr = String.valueOf(1 - (float)mwv.getUp() / (float)mwv.getNum());
					}
				}
			}
			//装载map
			map.put("voteStatus", voteStatus);
			map.put("userStatus", userStatus);
			map.put("up", up);
			map.put("down", down);
			map.put("upstr", upstr);
			map.put("downstr", downstr);

		} catch (NumberFormatException e) {
			log.error("findWindVane",e);
		}catch (ParseException e) {
			log.error("findWindVane",e);
		}
		return map;
	}

	@Override
	public int vote(int uid,int voteflag) {
		//判断用户是否登录
		if(uid <=0)
			return 0;

		try {
			//获取交易日
			String nowDate = this.getTradeDay();

			//判断用户是否已投过票了
			if(userVoteDetailService.getUserVoteDetail(nowDate,uid) != null)
				return 3;

			//增加用户投票记录到明细表中
			int num = userVoteDetailService.addUserVoteDetail(new UserVoteDetail(uid,new Date(),nowDate,voteflag));

			if(num > 0)
			{
				//完成投票任务处理
				mqSender.doTask(uid, "27010006");
				mqSender.sendMsg(uid,nowDate, voteflag);
			}
			else
			{
				return 2;
			}
		} catch (Exception e) {
			log.error("vote",e);
			return 2;
		}

		return 1;
	}

	@Override
	public Map<String, List<Double>> cowThanBear() {
		Map<String, List<Double>> map = new HashMap<String, List<Double>>();
		try {
			//获取最近10日的上证指数收盘价
			List<KLine> listK = QuoteClient.getNDaysKLineList("10000001", sdfs.format(new Date()), 0, 10, -1);
			List<Double> szlist = new ArrayList<Double>();
			for(KLine k :listK)
			{
				szlist.add((double)(Math.round(k.getCurPx()*100))/100);
			}

			//获取最近10日市场风向标涨跌比值
			List<Double> votelist = marketWindVanePollVoteService.getNDaysWindVane(10);

			map.put("szlist", szlist);
			map.put("votelist", votelist);
		} catch (Exception e) {
			log.error("cowThanBear",e);
			return null;
		}
		return map;
	}
	/**
	 * TODO
	 * 1.updateResult 方法混淆
	 * 2.修改用户投票结果 批量获取用户数据  每1000（配置常量）提取并修改数据
	 * 3.根据时间获取用户投票明细
	 * 1.批量 -- 单线程 
	 * 2.封装
	 */
	@Override
	public int closeClear() {
		try {
			Calendar c = Calendar.getInstance();
			String nowDate = sdf.format(c.getTime());//当前时间
			//根据当前时间查询统投
			MarketWindVanePollVote  mwpv = marketWindVanePollVoteService.getMarketWindVanePollVote(nowDate);
			if(mwpv == null)
				return 0;

			//获取上证指数
			List<CurStatus> list = QuoteClient.getCurStatusByCodes("10000001");
			//涨跌结果
			int zdstatus = Constants.DEF;//1:涨  2:跌
			if(list != null)
			{
				float zdf = list.get(0).getChange();
				if(zdf > 0)
					zdstatus = Constants.UP;
				else
					zdstatus = Constants.DOWN;
			}

			//修改统投结果
			marketWindVanePollVoteService.updateResult(sdf.format(new Date()),zdstatus);

			//获取所有用户投票明细
			int k = 0;
			PageHolder<UserVoteDetail> listDetail;
			List<UserVoteDetailHis> listDetailHis;
			while(true)
			{
				listDetail = userVoteDetailService.findAllUserVoteDetail(nowDate,k+1,Constants.EXECUTE_NUM);
				k = k+Constants.EXECUTE_NUM;
				if(listDetail != null  && listDetail.getList() != null && listDetail.size()>0)
				{
					//修改用户投票正确率，发送预测正确用户系统消息
					userClearing(listDetail.getList(),zdstatus);

					//批量转存到用户投票明细历史表中
					listDetailHis = new ArrayList<UserVoteDetailHis>();
					int i = 0;
					for(UserVoteDetail uvd : listDetail)
					{
						i++;
						listDetailHis.add(new UserVoteDetailHis(uvd.getUid(),uvd.getCtime(),uvd.getDate(),uvd.getType()));
						if(i == Constants.COMMIT_NUM)
						{
							userVoteDetailHisService.batchInsert(listDetailHis);
							listDetailHis = new ArrayList<UserVoteDetailHis>();
							i=0;
						}
					}
					
					if(listDetailHis.size() > 0)
					{
						userVoteDetailHisService.batchInsert(listDetailHis);
						log.info("批量保存用户投票历史数据");
					}
				}
				else
				{
					break;
				}
			}
			//清空用户投票明细
			userVoteDetailService.truncateAll(nowDate);
			log.info("清空用户投票明细");
			//创建新的预测日统计数据
			this.createNewVote();
			log.info("创建新的预测统计");
			TaskJettyClient.addTaskResult("00110001",new Date(),RunResultCode.SUCCESS.getIndex(), "风向标定时结算运行成功");
		} catch (Exception e) {
			TaskJettyClient.addTaskResult("00110001",new Date(),RunResultCode.FAILURE.getIndex(), "风向标定时结算异常,请检查日志");
			log.error("closeClear",e);
			return 0;
		}

		return 1;
	}

	/**
	 * 
	 * @Title: userClearing
	 * @Description: 用户结算
	 * @param listDetail 用户投票数据
	 * @param zdstatus  涨跌结果
	 * void    返回类型
	 * @throws
	 */
	private void userClearing(List<UserVoteDetail> listDetail,int zdstatus)
	{
		//修改用户投票正确率
		UserVoteRecord u;
		//记录投票正确的用户ID
		StringBuffer uidsStr = new StringBuffer();
		for(UserVoteDetail uvd : listDetail)
		{
			u = userVoteRecordService.getUserVoteRecord(uvd.getUid());
			if(u != null)
			{
				u.setNum(u.getNum()+1);
				if(uvd.getType() == 1)
					u.setUp(u.getUp()+1);
				else
					u.setDown(u.getDown()+1);

				//更新用户投票成功次数，同时给预测正确的小伙伴再发10金币，并记录下他们的uid，统一发送系统消息
				if(uvd.getType() == zdstatus)
				{
					u.setRight(u.getRight()+1);
					boolean res = userCoinRPCService.plusCoin(uvd.getUid(), 10, 1237);
					if(res)
						uidsStr.append(uvd.getUid()+",");
				}
				userVoteRecordService.updateUserVoteRecord(u);
			}
			else
			{
				u = new UserVoteRecord();
				u.setUid(uvd.getUid());
				u.setNum(1);
				if(uvd.getType() == 1)
					u.setUp(1);
				else
					u.setDown(1);

				if(uvd.getType() == zdstatus)
				{
					u.setRight(1);
					boolean res = userCoinRPCService.plusCoin(uvd.getUid(), 10, 1237);
					if(res)
						uidsStr.append(uvd.getUid()+",");
				}
				userVoteRecordService.addUserVoteRecord(u);
			}
		}

		//给预测成功用户发送系统通知
		sendMessage(uidsStr.toString(),zdstatus);
	}

	/**
	 * 
	 * @Title: sendMessage
	 * @Description:给预测成功用户发送系统通知
	 * @param uidsStr 用户ID集合
	 * @param zdstatus  涨跌结果
	 * void    返回类型
	 * @throws
	 */
	private void sendMessage(String uidsStr,int zdstatus)
	{
		String [] uids = uidsStr.toString().split(",");
		if(uids !=null && uids.length>0 && !uids[0].equals(""))
		{
			int [] us = new int[uids.length];
			for(int i=0;i<uids.length;i++)
			{
				us[i] = Integer.valueOf(uids[i]);
			}

			//查询当前统投
			MarketWindVanePollVote  mwv = marketWindVanePollVoteService.getMarketWindVanePollVote(sdf.format(new Date()));
			String upstr = "50%";//看涨百分比
			String downstr = "50%";//看跌百分比
			String str = "50%";//用户提示百分比
			if(mwv != null)
			{
				nFormat.setMaximumFractionDigits(2);//设置小数位数
				nFormat.setMaximumIntegerDigits(3);//设置整数位数
				upstr = nFormat.format((float)mwv.getUp() / (float)mwv.getNum());
				downstr = nFormat.format(1 - (float)mwv.getUp() / (float)mwv.getNum());
				if(zdstatus == Constants.UP)
				{
					str = upstr;
				}
				else
				{
					str = downstr;
				}
			}

			//给预测正确并发送金币成功的用户发送系统消息
			if(us.length>0)
			{
				MqSystemNotice notice = new MqSystemNotice();
				notice.setTitle(Constants.WINDVANE_TITLE);
				notice.setToUids(us);
				notice.setType(2);
				notice.setMsg(String.format(Constants.WINDVANE_CONTENT, sdfs.format(new Date()),str));
				notice.setCtime(new Date());
				mqSender.sendSystemNotice(notice);
				log.info("给预测正确并发送金币成功的用户发送系统消息");
			}
			
		}
	}

	/**
	 * @Title: 获取交易日
	 * @Description: 
	 * @param 
	 * @return 
	 * @throws
	 */
	private String getTradeDay()throws ParseException
	{
		Calendar c = Calendar.getInstance();

		String nowDate = sdf.format(c.getTime());//当前时间
		//获取当前时间的小时位数并去0
		int time = c.get(Calendar.HOUR_OF_DAY);

		//如果当前时间小时位数大于等于下午4点，那么预测日则为T+1的交易日
		if(time >= 16)
		{
			return tradeDayService.nextTradeDay(c.getTime(), 1);
		}

		//判断当前时间是否为交易日，如果是则返回当前时间。如果不是则返回下个交易日
		if(tradeDayService.isTradeDay(nowDate))
			return nowDate;
		else
			return tradeDayService.nextTradeDay(c.getTime(), 1);

	}

	private int createNewVote() {
		try {
			String nowDate = this.getTradeDay();
			MarketWindVanePollVote  mwv = marketWindVanePollVoteService.getMarketWindVanePollVote(nowDate);
			if(mwv != null)
				return 0;

			Random random = new Random();

			int up = 80+random.nextInt(20);
			int down = 80+random.nextInt(20);
			return marketWindVanePollVoteService.addMarketWindVanePollVote(new MarketWindVanePollVote(nowDate,up+down,up,down,0));
		} catch (ParseException e) {
			log.error("findWindVane",e);
			return 0;
		}
	}

}
