package com.youguu.asteroid.rpc.server.activity;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import com.youguu.asteroid.activity.pojo.ActivityPrize;
import com.youguu.asteroid.activity.pojo.ActivityUser;
import com.youguu.asteroid.activity.pojo.VoPrizeInfo;
import com.youguu.asteroid.activity.service.IDisposeActivityService;
import com.youguu.asteroid.rpc.common.Constants;
import com.youguu.asteroid.rpc.thrift.gen.ActivityLotteryThriftRpcService.Iface;
import com.youguu.asteroid.rpc.thrift.gen.ActivityPrizeThrift;
import com.youguu.asteroid.rpc.thrift.gen.ActivityUserThrift;
import com.youguu.asteroid.rpc.thrift.gen.VoPrizeInfoThrift;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.core.util.ClassCast;
import com.youguu.core.util.ParamUtil;
import com.youguu.member.common.pojo.ByteUtil;

/**
 * 
* @Title: ActivityLotteryThriftRpcServiceImpl.java
* @Package com.youguu.asteroid.rpc.server.activity
* @Description: 活动抽奖RPC服务端实现类
* @author 徐云杰
* @date 2015年3月12日 上午11:23:00
* @version V1.0
 */
@Service("activityLotteryThriftRpcService")
public class ActivityLotteryThriftRpcServiceImpl implements Iface{
	
	private static final Log log = LogFactory.getLog(Constants.ASTEROIDRPC_SERVER);
	
	@Resource
	private IDisposeActivityService disposeActivityService;

	@Override
	public ByteBuffer findUserAwardInfo(int userId)throws TException {
		try {
			return ParamUtil.getFromByte(disposeActivityService.findUserAwardInfo(userId));
		} catch (Exception e) {
			log.error("findUserAwardInfo", e);
			return null;
		}
	}

	@Override
	public ByteBuffer findUserAwardRecord(int userId) throws TException {
		try {
			return ParamUtil.getFromByte(disposeActivityService.findUserAwardRecord(userId));
		} catch (Exception e) {
			log.error("findUserAwardRecord", e);
			return null;
		}
	}

	@Override
	public ByteBuffer clickLottery(int userId) throws TException {
		try {
			return ParamUtil.getFromByte(disposeActivityService.clickLottery(userId));
		} catch (Exception e) {
			log.error("clickLottery", e);
			return null;
		}
	}

	@Override
	public ByteBuffer getAward(int poolId, String phone, int userId)throws TException {
		try {
			return ParamUtil.getFromByte(disposeActivityService.getAward(poolId, phone, userId));
		} catch (Exception e) {
			log.error("getAward", e);
			return null;
		}
	}

	@Override
	public int createPrizePool(List<VoPrizeInfoThrift> listData, int batchNum)throws TException {
		try {
			List<VoPrizeInfo> list = new ArrayList<VoPrizeInfo>();
			if(listData != null && listData.size()>0)
			{
				for(VoPrizeInfoThrift vt:listData)
				{
					list.add(ClassCast.cast(vt, VoPrizeInfo.class));
				}
			}
			return disposeActivityService.createPrizePool(list, batchNum);
		} catch (Exception e) {
			log.error("createPrizePool", e);
			return 0;
		}
	}

	@Override
	public int createBigPrize(VoPrizeInfoThrift vpi) throws TException {
		try {
			return disposeActivityService.createBigPrize(ClassCast.cast(vpi, VoPrizeInfo.class));
		} catch (Exception e) {
			log.error("createBigPrize", e);
			return 0;
		}
	}

	@Override
	public int comparisonData() throws TException {
		try {
			return disposeActivityService.comparisonData();
		} catch (Exception e) {
			log.error("comparisonData", e);
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ByteBuffer findAllActivityUser(ByteBuffer parameter, int pageIndex,int pageSize) throws TException {
		try {
			return ByteUtil.getByteBuffer(disposeActivityService.findAllActivityUser((Map<String, Object>)ParamUtil.getFromByte(parameter), pageIndex, pageSize));
		} catch (Exception e) {
			log.error("findAllActivityUser", e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ByteBuffer findAllActivityPrize(ByteBuffer parameter, int pageIndex,int pageSize) throws TException {
		try {
			return ByteUtil.getByteBuffer(disposeActivityService.findAllActivityPrize((Map<String, Object>)ParamUtil.getFromByte(parameter), pageIndex, pageSize));
		} catch (Exception e) {
			log.error("findAllActivityPrize", e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ByteBuffer findAllUserAwardNum(ByteBuffer parameter, int pageIndex,int pageSize) throws TException {
		try {
			return ByteUtil.getByteBuffer(disposeActivityService.findAllUserAwardNum((Map<String, Object>)ParamUtil.getFromByte(parameter), pageIndex, pageSize));
		} catch (Exception e) {
			log.error("findAllActivityPrize", e);
			return null;
		}
	}

	@Override
	public int batchInsertActivityUser(List<ActivityUserThrift> listData) throws TException {
		try {
			if(listData != null && listData.size()>0)
			{
				List<ActivityUser> list = new ArrayList<ActivityUser>();
				for(ActivityUserThrift aut:listData)
				{
					list.add(ClassCast.cast(aut, ActivityUser.class));
				}
				return disposeActivityService.batchInsertActivityUser(list);
			}
			return 0;
		} catch (Exception e) {
			log.error("batchInsertActivityUser", e);
			return 0;
		}
	}

	@Override
	public int addActivityPrize(ActivityPrizeThrift ap) throws TException {
		try {
			return disposeActivityService.addActivityPrize(ClassCast.cast(ap, ActivityPrize.class));
		} catch (Exception e) {
			log.error("addActivityPrize", e);
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ByteBuffer findAllActivityUserAwardRecord(ByteBuffer parameter,int pageIndex, int pageSize) throws TException {
		try {
			return ByteUtil.getByteBuffer(disposeActivityService.findAllActivityUserAwardRecord((Map<String, Object>)ParamUtil.getFromByte(parameter), pageIndex, pageSize));
		} catch (IOException e) {
			log.error("findAllActivityUserAwardRecord", e);
			return null;
		}
	}

	@Override
	public int delActivityPrize(int id) throws TException {
		try {
			return disposeActivityService.delActivityPrize(id);
		} catch (Exception e) {
			log.error("delActivityPrize", e);
			return 0;
		}
	}

	@Override
	public int updateUserAwardRecordStatus(int pooId, int status)throws TException {
		try {
			return disposeActivityService.updateUserAwardRecordStatus(pooId, status);
		} catch (Exception e) {
			log.error("updateUserAwardRecordStatus", e);
			return 0;
		}
	}

}
