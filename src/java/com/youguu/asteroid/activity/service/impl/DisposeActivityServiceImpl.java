package com.youguu.asteroid.activity.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.youguu.asteroid.activity.pojo.ActivityPrize;
import com.youguu.asteroid.activity.pojo.ActivityPrizePool;
import com.youguu.asteroid.activity.pojo.ActivityTask;
import com.youguu.asteroid.activity.pojo.ActivityUser;
import com.youguu.asteroid.activity.pojo.ActivityUserAwardDetail;
import com.youguu.asteroid.activity.pojo.ActivityUserAwardNum;
import com.youguu.asteroid.activity.pojo.ActivityUserAwardRecord;
import com.youguu.asteroid.activity.pojo.MqSystemNotice;
import com.youguu.asteroid.activity.pojo.VoPrizeInfo;
import com.youguu.asteroid.activity.service.IActivityPrizePoolService;
import com.youguu.asteroid.activity.service.IActivityPrizeService;
import com.youguu.asteroid.activity.service.IActivityTaskService;
import com.youguu.asteroid.activity.service.IActivityUserAwardDetailService;
import com.youguu.asteroid.activity.service.IActivityUserAwardNumService;
import com.youguu.asteroid.activity.service.IActivityUserAwardRecordService;
import com.youguu.asteroid.activity.service.IActivityUserService;
import com.youguu.asteroid.activity.service.IDisposeActivityService;
import com.youguu.asteroid.activity.util.Constants;
import com.youguu.core.util.Log4jUtil;
import com.youguu.core.util.PageHolder;
import com.youguu.core.util.PropertiesUtil;
import com.youguu.jms.handler.IMqHandler;
import com.youguu.jms.handler.MqHandlerProvider;
import com.youguu.jms.pojo.Message;
import com.youguu.member.client.service.MemberRpcService;
import com.youguu.member.common.pojo.RealStock;
import com.youguu.member.common.pojo.User;
import com.youguu.member.common.pojo.UserView;
import com.youguu.stat.op.pojo.StockOrderStat;
import com.youguu.stat.op.service.IStockOrderStatService;

/**
 * 
 * @Title: DisposeActivityServiceImpl.java
 * @Package com.youguu.asteroid.activity.service.impl
 * @Description: 客户端,后台业务处理统一调用Service入口实现类
 * @author 徐云杰
 * @date 2015年3月10日 上午11:10:20
 * @version V1.0
 */
@Service("disposeActivityService")
public class DisposeActivityServiceImpl implements IDisposeActivityService {

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static Logger log = Log4jUtil.getLogger("activity");

	@Resource
	private IActivityUserAwardRecordService activityUserAwardRecordService;

	@Resource
	private IActivityUserAwardNumService activityUserAwardNumService;

	@Resource
	private MemberRpcService asyncMemberRpcService;

	@Resource
	private IActivityPrizePoolService activityPrizePoolService;

	@Resource
	private IActivityUserAwardDetailService activityUserAwardDetailService;

	@Resource
	private IActivityTaskService activityTaskService;

	@Resource
	private IStockOrderStatService stockOrderStatService;

	@Resource
	private IActivityUserService activityUserService;

	@Resource
	private IActivityPrizeService activityPrizeService;

	@Override
	public Map<String, Object> findUserAwardInfo(int userId) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			//奖盘数据装载
			Map<String,Object> parmter1 = new HashMap<String,Object>();
			parmter1.put("cols", "id asc");
			PageHolder<ActivityPrize>  pageInfo =activityPrizeService.findAllActivityPrize(parmter1, 1, 50);
			if(pageInfo != null && pageInfo.getList() != null && pageInfo.getList().size()>0)
			{
				map.put("prizeList", pageInfo.getList());
			}
			else
			{
				map.put("prizeList", new ArrayList<ActivityPrize>());
			}

			if(userId <= 0)
			{
				map.put("status", "0000");
				map.put("message", "查询成功");
				map.put("recordList", getFalseData());
				return map;
			}

			//判断用户是否存在
			User user = asyncMemberRpcService.getUser(userId);
			if(user == null)
			{
				map.put("status", "1003");
				map.put("message", "无此用户");
				return map;
			}

			//获取用户绑定手机号
			String phone = asyncMemberRpcService.findUserPhone(userId);
			map.put("phone", phone);

			//获取用户剩余抽奖次数,判断剩余奖励次数
			ActivityUserAwardNum auan = activityUserAwardNumService.getUserAwardNum(userId);
			if(auan != null)
			{
				map.put("awardTotal", auan.getAwardTotal());
			}
			else
			{
				map.put("awardTotal", 0);
			}

			//查询中奖记录,滚动显示用
			Map<String,Object> parmter = new HashMap<String,Object>();
			parmter.put("cols", "ctime desc");
			List<ActivityUserAwardRecord> listAuar = getUserAwardRecord(parmter);
			listAuar = perfectInfo(listAuar);
			if(listAuar != null && listAuar.size()>50)
				map.put("recordList", listAuar);
			else
				map.put("recordList", getFalseData());

			//判断用户是否有没兑现的奖品
			List<ActivityUserAwardRecord> listauar = activityUserAwardRecordService.findNoCash(userId);
			if(listauar != null && listauar.size()>0)
			{
				map.put("status", "2001");
				map.put("message", "查询成功");
				map.put("poolId", listauar.get(0).getPoolId());
				map.put("prizeId", listauar.get(0).getPrizeId());
				map.put("prizeName", listauar.get(0).getPrizeName());
				return map;
			}

			map.put("status", "0000");
			map.put("message", "查询成功");
			return map;
		} catch (Exception e) {
			log.error("findUserAwardInfo", e);
			map.put("status", "1003");
			map.put("message", "网络不给力");
			return map;
		}
	}

	/**
	 * 
	 * @Title: getUserAwardRecord
	 * @Description: 查询中奖记录
	 * @param parmter
	 * @return    
	 * List<ActivityUserAwardRecord>    返回类型
	 * @throws
	 */
	private List<ActivityUserAwardRecord> getUserAwardRecord(Map<String, Object> parmter)
	{
		PageHolder<ActivityUserAwardRecord> pageInfo = activityUserAwardRecordService.findAllActivityUserAwardRecord(parmter, 1, 50);
		if(pageInfo != null && pageInfo.getList() != null && pageInfo.getList().size()>0)
		{
			return pageInfo.getList();
		}
		return null;
	}

	/**
	 * 
	 * @Title: perfectInfo
	 * @Description: 完善用户中奖信息
	 * @param list
	 * @return    
	 * List<ActivityUserAwardRecord>    返回类型
	 * @throws
	 */
	private List<ActivityUserAwardRecord> perfectInfo(List<ActivityUserAwardRecord> list)
	{
		List<ActivityUserAwardRecord> newList = new ArrayList<ActivityUserAwardRecord>();
		if(list != null && list.size()>0)
		{
			List<Integer> listId = new ArrayList<Integer>();
			for(ActivityUserAwardRecord auar:list)
			{
				listId.add(auar.getUserId());
			}
			String str = asyncMemberRpcService.queryUserViewList(listId);
			if(str != null && !"".equals(str))
			{
				List<UserView> listUv = JSONObject.parseArray(str,UserView.class);
				if(listUv != null && listUv.size()>0)
				{
					ActivityUserAwardRecord au;
					UserView uv;
					String name = "";
					for(int i =0;i<listUv.size();i++)
					{
						uv = listUv.get(i);
						au = new ActivityUserAwardRecord();
						au.setUserId(uv.getUserId());
						name = uv.getNickName();
						name = name.substring(0, name.length());
						au.setNickName(name+"*");
						au.setPic(uv.getHeadPic());
						au.setPrizeName(list.get(i).getPrizeName());
						newList.add(au);
					}
				}
			}
		}
		return newList;
	}

	@Override
	public Map<String, Object> findUserAwardRecord(int userId) {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			Map<String,Object> parmter = new HashMap<String,Object>();
			parmter.put("cols", "ctime desc");
			parmter.put("userId",userId);
			List<ActivityUserAwardRecord> listAuar = getUserAwardRecord(parmter);
			if(listAuar != null)
			{
				for(ActivityUserAwardRecord auar : listAuar)
				{
					auar.setCtimeStr(sdf.format(auar.getCtime()));
				}
				map.put("recordList", listAuar);
			}
			else
			{
				map.put("recordList", new ArrayList<ActivityUserAwardRecord>());
			}
			map.put("status", "0000");
			map.put("message", "查询成功");
			return map;
		} catch (Exception e) {
			log.error("findUserAwardRecord", e);
			map.put("status", "1003");
			map.put("message", "网络不给力");
			return map;
		}
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public synchronized Map<String, Object> clickLottery(int userId)throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			//获取用户剩余抽奖次数,判断剩余奖励次数
			ActivityUserAwardNum auan = activityUserAwardNumService.getUserAwardNum(userId);
			if(auan == null)
			{
				map.put("status", "1005");
				map.put("message", "您没有抽奖机会");
				return map;
			}

			if(auan.getAwardTotal() <= 0)
			{
				map.put("status", "1005");
				map.put("message", "您没有抽奖机会");
				return map;
			}

			//1.查询出未使用的抽奖信息
			ActivityUserAwardDetail auad = activityUserAwardDetailService.findDetail(userId);
			if(auad != null)
			{
				//修改状态
				activityUserAwardDetailService.updateStatus(auad.getId());
				//修改总次数
				int num = activityUserAwardNumService.updateNum(userId);

				if(num<=0){
					throw new Exception();
				}

				//获取一条奖池奖品
				ActivityPrizePool app = activityPrizePoolService.getOnePrize(auad.getTaskId());
				if(app==null){
					throw new Exception();
				}
				//修改奖池奖品状态
				activityPrizePoolService.updateStatus(app.getId());
				//新增一条用户获奖记录
				ActivityUserAwardRecord auar = new ActivityUserAwardRecord(app.getId(),userId,app.getPrizeId(),auan.getNickName(),"",0,"","",new Date());
				num = activityUserAwardRecordService.addActivityUserAwardRecord(auar);
				if(num<=0){
					throw new Exception();
				}
				map.put("poolId", app.getId());
				map.put("prizeId", app.getPrizeId());
				map.put("status", "0000");
				map.put("message", "查询成功");
				return map;
			}
			map.put("status", "1003");
			map.put("message", "网络不给力");
			return map;
		} catch (Exception e) {
			log.error("clickLottery", e);
			throw new Exception();
		}
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public Map<String, Object> getAward(int poolId,String phone,int userId)throws Exception {
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			if(poolId<=0 || userId<=0)
			{
				map.put("status", "1004");
				map.put("message", "领取失败");
				return map;
			}

			//修改用户中奖信息
			ActivityUserAwardRecord auar = new ActivityUserAwardRecord();
			auar.setPoolId(poolId);
			auar.setPhone(phone);
			int num = activityUserAwardRecordService.update(auar);

			//修改用户中奖信息状态
			Map<String,Integer> pmap = new HashMap<String,Integer>();
			pmap.put("poolId", poolId);
			pmap.put("status", 1);
			num = activityUserAwardRecordService.updateStatus(pmap);

			if(num<=0)
				throw new Exception();

			//给成功领取奖品的用户发送站内信
			auar = activityUserAwardRecordService.getRecord(poolId);
			sendMessage(userId,Constants.WINNING_TITLE,String.format(Constants.WINNING_COWNTENT,auar.getPrizeName()));
			map.put("status", "0000");
			map.put("message", "获取成功");
			return map;
		} catch (Exception e) {
			log.error("getAward", e);
			throw new Exception();
		}
	}

	/**
	 * 
	 * @Title: sendMessage
	 * @Description: 发送MQ
	 * @param userId
	 * @param title
	 * @param content    
	 * void    返回类型
	 * @throws
	 */
	private void sendMessage(int userId,String title,String content)
	{
		int uids[] = new int[1];
		uids[0]=userId;
		MqSystemNotice mq = new MqSystemNotice();
		mq.setTitle(title);
		mq.setToUids(uids);
		mq.setType(2);
		mq.setMsg(content);
		mq.setCtime(new Date());
		Message<MqSystemNotice> dd = new Message<MqSystemNotice>(1, mq);
		IMqHandler handler = MqHandlerProvider.get("assist");
		handler.sendMsg(dd);
	}

	@Override
	public int createPrizePool(List<VoPrizeInfo> list, int batchNum) {
		try {
			int totalNum = 0;
			if(list != null && list.size()>0)
			{
				List<VoPrizeInfo> newVoList = new ArrayList<VoPrizeInfo>();
				//计算出一批次的奖品总量和生成总量的奖品集合
				for(VoPrizeInfo info:list)
				{
					totalNum+=info.getNum();
					for(int i =0;i<info.getNum();i++)
					{
						newVoList.add(new VoPrizeInfo(info.getPrizeId(),info.getTaskId(),0));
					}
				}

				//将下标随机打乱，set中存储随机的下标。
				Set<String> set = new HashSet<String>();
				for(int i =0;i<totalNum;i++)
				{
					set.add(String.valueOf(i));
				}

				VoPrizeInfo vpi;
				ActivityPrizePool app;
				List<ActivityPrizePool> newList = new ArrayList<>();
				//根据批次遍历
				for(int i = 0;i<batchNum;i++)
				{
					Iterator<String> it = set.iterator();
					while(it.hasNext())
					{
						vpi = newVoList.get(Integer.valueOf(it.next()));
						app = new ActivityPrizePool(vpi.getPrizeId(),vpi.getTaskId(),0,"",new Date());
						newList.add(app);
					}
				}
				return activityPrizePoolService.batchInsert(newList);
			}
			return 0;
		} catch (NumberFormatException e) {
			log.error("createPrizePool", e);
			return 0;
		}
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int createBigPrize(VoPrizeInfo vpi)throws Exception{
		try {
			//获取奖品池中还未被使用的奖品List
			List<ActivityPrizePool> list = activityPrizePoolService.findPrizePoolListByTaskId(vpi.getTaskId());
			int index = 0;
			ActivityPrizePool app;
			//如果小于50的数量的话，证明奖品池中的奖品已经处于预警状态，需要马上增加奖品
			if(list.size()<=50)
			{
				return 2;
			}
			else if(list.size() <= 100)
			{
				//如果数量在50到100之间的话，则取数量除以5的倍数
				index = (int)list.size() / 5;
			}
			else if(list.size() > 100)
			{
				//如果数量在100以上的话，则取数量除以10的倍数
				index = (int)list.size() / 10;
			}

			Random random = new Random();
			index = 20+random.nextInt(index);

			app = list.get(index);
			//先将奖品状态改为备用状态，防止用户获取到
			app.setStatus(2);
			int num = activityPrizePoolService.updateReserveStatus(app);

			if(num<=0)
			{
				throw new Exception();
			}

			//修改奖品信息为大奖的信息，并将状态改为未使用状态
			app.setPrizeId(vpi.getPrizeId());
			app.setTaskId(vpi.getTaskId());
			app.setStatus(0);
			num = activityPrizePoolService.updateInfo(app);

			//如果信息修改失败，则回滚事务
			if(num<=0)
			{
				throw new Exception();
			}
			return 1;
		} catch (Exception e) {
			log.error("createBigPrize", e);
			throw new Exception();
		}
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int comparisonData()throws Exception {
		try {
			//查询出活动的开始结束日期
			ActivityTask task = activityTaskService.findActivityTask(1);
			Map<String,String> map;
			Map<String,Object> mapUser;
			List<RealStock> listLogin;
			List<StockOrderStat> listTrade;
			List<ActivityUser> listUser;
			List<ActivityUserAwardDetail> listUad;
			ActivityUserAwardNum auan;
			ActivityUserAwardDetail auad;
			User user;
			Map<String,Object> argMap;
			if(task != null)
			{
				map = new HashMap<String,String>();
				map.put("beginTime", sdf2.format(task.getBeginTime()));
				map.put("endTime", sdf2.format(task.getEndTime()));
				map.put("brokerId", String.valueOf(ActivityTask.BROKER_ID));
				//查询实盘登录用户LIST
				listLogin = asyncMemberRpcService.findRealStockList(map);

				//活动用户信息List
				mapUser = new HashMap<String,Object>();
				mapUser.put("taskId", 1);
				mapUser.put("beginTime", task.getBeginTime());
				mapUser.put("endTime", task.getEndTime());
				listUser = activityUserService.findListActivityUser(mapUser);

				//比较实盘登录用户
				if(listLogin != null && listUser != null)
				{
					for(ActivityUser auser : listUser)
					{
						for(RealStock rs :listLogin)
						{
							if(String.valueOf(auser.getBrokerId()).equals(rs.getBrokerId()) && auser.getBrokerUserId().equals(rs.getBrokerUserId()))
							{
								user = asyncMemberRpcService.getUser(rs.getUserId());
								if(user != null)
								{
									listUad = new ArrayList<ActivityUserAwardDetail>();
									//新增活动用户抽奖总记录信息
									auan = new ActivityUserAwardNum(user.getUserId(),user.getNickName(),task.getAwardNum());
									int num = activityUserAwardNumService.addActivityUserAwardNum(auan);
									if(num > 0)
									{
										//遍历奖励次数
										for(int i =0;i<task.getAwardNum();i++)
										{
											auad = new ActivityUserAwardDetail(user.getUserId(),1,0);
											listUad.add(auad);
										}
										//新增用户抽奖明细信息
										num = activityUserAwardDetailService.batchInsert(listUad);
										if(num <= 0)
										{
											throw new Exception();
										}
										Properties pro = PropertiesUtil.getProperties(Constants.WAP_URL_PATH,"utf-8");
										String lotteryContent = pro.getProperty(Constants.LOTTERY_CONTENT);
										sendMessage(user.getUserId(),Constants.LOTTERY_TITLE,String.format(lotteryContent,task.getAwardNum()));
										//修改活动用户表中状态
										argMap = new HashMap<String,Object>();
										argMap.put("brokerId", auser.getBrokerId());
										argMap.put("brokerUserId", auser.getBrokerUserId());
										argMap.put("taskId", 2);
										num = activityUserService.updateStatus(argMap);
										if(num <= 0)
										{
											throw new Exception();
										}
									}
								}
							}
						}
					}
				}
			}

			//查询出活动的开始结束日期
			task = activityTaskService.findActivityTask(2);
			if(task != null)
			{
				map = new HashMap<String,String>();
				map.put("beginTime", sdf2.format(task.getBeginTime()));
				map.put("endTime", sdf2.format(task.getEndTime()));
				map.put("brokerId", String.valueOf(ActivityTask.BROKER_ID));

				//查询实盘交易用户LIST
				listTrade = stockOrderStatService.findAllOrderStatByBrokerId(map);

				//活动用户信息List
				mapUser = new HashMap<String,Object>();
				mapUser.put("taskId", 2);
				mapUser.put("beginTime", task.getBeginTime());
				mapUser.put("endTime", task.getEndTime());
				listUser = activityUserService.findListActivityUser(mapUser);

				//比较实盘登录用户
				if(listTrade != null && listUser != null)
				{
					for(ActivityUser auser : listUser)
					{
						for(StockOrderStat rs :listTrade)
						{
							if(String.valueOf(auser.getBrokerId()).equals(String.valueOf(rs.getBrokerId())) && auser.getBrokerUserId().equals(rs.getBrokerUserId()))
							{
								user = asyncMemberRpcService.getUser(rs.getUserId());
								if(user != null)
								{
									listUad = new ArrayList<ActivityUserAwardDetail>();
									auan = activityUserAwardNumService.getUserAwardNum(user.getUserId());
									if(auan != null)
									{
										//增加用户抽奖总的数量
										argMap = new HashMap<String,Object>();
										argMap.put("userId", user.getUserId());
										argMap.put("num", task.getAwardNum());
										int num = activityUserAwardNumService.updateAddNum(argMap);

										if(num > 0)
										{
											//批量新增用户抽奖明细
											for(int i =0;i<task.getAwardNum();i++)
											{
												auad = new ActivityUserAwardDetail(user.getUserId(),2,0);
												listUad.add(auad);
											}
											num = activityUserAwardDetailService.batchInsert(listUad);

											if(num <= 0)
											{
												throw new Exception();
											}

											Properties pro = PropertiesUtil.getProperties(Constants.WAP_URL_PATH,"utf-8");
											String lotteryContent = pro.getProperty(Constants.LOTTERY_CONTENT);
											sendMessage(user.getUserId(),Constants.LOTTERY_TITLE,String.format(lotteryContent,task.getAwardNum()));

											//修改用户数据状态
											argMap = new HashMap<String,Object>();
											argMap.put("brokerId", auser.getBrokerId());
											argMap.put("brokerUserId", auser.getBrokerUserId());
											argMap.put("taskId", 3);
											num = activityUserService.updateStatus(argMap);

											if(num <= 0)
											{
												throw new Exception();
											}
										}
									}
									else
									{
										//如果为NULL表示比对登录时插入数据失败，则做补加操作
										ActivityTask task2 = activityTaskService.findActivityTask(1);
										auan = new ActivityUserAwardNum(user.getUserId(),user.getNickName(),task.getAwardNum()+task2.getAwardNum());
										int num = activityUserAwardNumService.addActivityUserAwardNum(auan);
										if(num > 0)
										{
											//批量新增用户抽奖明细
											for(int i =0;i<task.getAwardNum();i++)
											{
												auad = new ActivityUserAwardDetail(user.getUserId(),2,0);
												listUad.add(auad);
											}
											for(int i =0;i<task2.getAwardNum();i++)
											{
												auad = new ActivityUserAwardDetail(user.getUserId(),1,0);
												listUad.add(auad);
											}
											num = activityUserAwardDetailService.batchInsert(listUad);

											if(num <= 0)
											{
												throw new Exception();
											}

											Properties pro = PropertiesUtil.getProperties(Constants.WAP_URL_PATH,"utf-8");
											String lotteryContent = pro.getProperty(Constants.LOTTERY_CONTENT);
											sendMessage(user.getUserId(),Constants.LOTTERY_TITLE,String.format(lotteryContent,task.getAwardNum()));

											//修改用户数据状态
											argMap = new HashMap<String,Object>();
											argMap.put("brokerId", auser.getBrokerId());
											argMap.put("brokerUserId", auser.getBrokerUserId());
											argMap.put("taskId", 3);
											num = activityUserService.updateStatus(argMap);
											if(num <= 0)
											{
												throw new Exception();
											}
										}

									}
								}
							}
						}
					}
				}
			}
			return 1;
		} catch (Exception e) {
			log.error("comparisonData", e);
			throw new Exception();
		}
	}

	@Override
	public PageHolder<ActivityUser> findAllActivityUser(Map<String, Object> parameter, int pageIndex, int pageSize) {
		try {
			return activityUserService.findAllActivityUser(parameter, pageIndex, pageSize);
		} catch (Exception e) {
			log.error("findAllActivityUser", e);
			return new PageHolder<ActivityUser>();
		}
	}

	@Override
	public PageHolder<ActivityPrize> findAllActivityPrize(Map<String, Object> parameter, int pageIndex, int pageSize) {
		try {
			return activityPrizeService.findAllActivityPrize(parameter, pageIndex, pageSize);
		} catch (Exception e) {
			log.error("findAllActivityPrize", e);
			return new PageHolder<ActivityPrize>();
		}
	}

	@Override
	public PageHolder<ActivityUserAwardNum> findAllUserAwardNum(Map<String, Object> parameter, int pageIndex, int pageSize) {
		try {
			return activityUserAwardNumService.findAllUserAwardNum(parameter, pageIndex, pageSize);
		} catch (Exception e) {
			log.error("findAllUserAwardNum", e);
			return new PageHolder<ActivityUserAwardNum>();
		}
	}

	/**
	 * 
	 * @Title: getFalseData
	 * @Description:获取活动抽奖假数据
	 * @return    
	 * List<ActivityUserAwardRecord>    返回类型
	 * @throws
	 */
	private List<ActivityUserAwardRecord> getFalseData()
	{
		List<ActivityUserAwardRecord> list = new ArrayList<ActivityUserAwardRecord>();
		try {
			String encoding = "utf-8";
			InputStreamReader read = new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(Constants.ACTIVITY_DATA_INFO_PATH), encoding);
			BufferedReader bufferedReader = new BufferedReader(read);
			String lineTxt = null;
			String [] args;
			ActivityUserAwardRecord auar;
			while ((lineTxt = bufferedReader.readLine()) != null) {
				if(lineTxt != null && lineTxt.length()>0)
				{
					args = lineTxt.split(",");
					auar = new ActivityUserAwardRecord();
					auar.setNickName(args[1]);
					auar.setPic(args[2]);
					auar.setPrizeName(args[3]);
					list.add(auar);
				}
			}
			read.close();
			return list;
		} catch (Exception e) {
			log.error("getFalseData:读取文件内容出错");
			return list;
		}
	}

	@Override
	public int batchInsertActivityUser(List<ActivityUser> list) {
		return activityUserService.batchInsert(list);
	}

	@Override
	public int addActivityPrize(ActivityPrize ap) {
		return activityPrizeService.addActivityPrize(ap);
	}

	@Override
	public PageHolder<ActivityUserAwardRecord> findAllActivityUserAwardRecord(Map<String, Object> parameter, int pageIndex, int pageSize) {
		return activityUserAwardRecordService.findAllActivityUserAwardRecord(parameter, pageIndex, pageSize);
	}

	@Override
	public int delActivityPrize(int id) {
		return activityPrizeService.delActivityPrize(id);
	}

	@Override
	public int updateUserAwardRecordStatus(int pooId,int status) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("poolId", pooId);
		map.put("status", status);
		return activityUserAwardRecordService.updateStatus(map);
	}

}
