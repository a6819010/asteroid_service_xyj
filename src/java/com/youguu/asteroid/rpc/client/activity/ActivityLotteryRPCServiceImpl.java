package com.youguu.asteroid.rpc.client.activity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import com.youguu.asteroid.activity.pojo.ActivityPrize;
import com.youguu.asteroid.activity.pojo.ActivityUser;
import com.youguu.asteroid.activity.pojo.ActivityUserAwardNum;
import com.youguu.asteroid.activity.pojo.ActivityUserAwardRecord;
import com.youguu.asteroid.activity.pojo.VoPrizeInfo;
import com.youguu.asteroid.rpc.common.Constants;
import com.youguu.asteroid.rpc.thrift.gen.ActivityPrizeThrift;
import com.youguu.asteroid.rpc.thrift.gen.ActivityUserThrift;
import com.youguu.asteroid.rpc.thrift.gen.VoPrizeInfoThrift;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.core.util.ClassCast;
import com.youguu.core.util.PageHolder;
import com.youguu.core.util.ParamUtil;
import com.youguu.member.common.pojo.ByteUtil;

/**
 * 
* @Title: ActivityLotteryRPCServiceImpl.java
* @Package com.youguu.asteroid.rpc.client.activity
* @Description: 活动抽奖客户端服务接口实现类
* @author 徐云杰
* @date 2015年3月12日 下午2:04:49
* @version V1.0
 */
@Service("activityLotteryRPCService")
public class ActivityLotteryRPCServiceImpl implements IActivityLotteryRPCService {

	private static final Log log = LogFactory.getLog(Constants.ASTEROIDRPC_CLIENT);

	private ActivityLotteryClient getClient(){
		return new ActivityLotteryClient();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> findUserAwardInfo(int userId) {
		try {
			return (Map<String, Object>)ParamUtil.getFromByte(getClient().findUserAwardInfo(userId));
		} catch (TException e) {
			log.error("findUserAwardInfo", e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> findUserAwardRecord(int userId) {
		try {
			return (Map<String, Object>)ParamUtil.getFromByte(getClient().findUserAwardRecord(userId));
		} catch (TException e) {
			log.error("findUserAwardRecord", e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> clickLottery(int userId) {
		try {
			return (Map<String, Object>)ParamUtil.getFromByte(getClient().clickLottery(userId));
		} catch (TException e) {
			log.error("clickLottery", e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getAward(int poolId, String phone, int userId) {
		try {
			return (Map<String, Object>)ParamUtil.getFromByte(getClient().getAward(poolId, phone, userId));
		} catch (TException e) {
			log.error("getAward", e);
			return null;
		}
	}

	@Override
	public int createPrizePool(List<VoPrizeInfo> list, int batchNum) {
		try {
			List<VoPrizeInfoThrift> listT = new ArrayList<VoPrizeInfoThrift>();
			if(list != null && list.size()>0)
			{
				for(VoPrizeInfo vpi : list)
				{
					listT.add(ClassCast.cast(vpi, VoPrizeInfoThrift.class));
				}
				return getClient().createPrizePool(listT, batchNum);
			}
			return 0;
		} catch (TException e) {
			log.error("createPrizePool", e);
			return 0;
		}
	}

	@Override
	public int createBigPrize(VoPrizeInfo vpi) {
		try {
			return getClient().createBigPrize(ClassCast.cast(vpi, VoPrizeInfoThrift.class));
		} catch (TException e) {
			log.error("createBigPrize", e);
			return 0;
		}
	}

	@Override
	public int comparisonData() {
		try {
			return getClient().comparisonData();
		} catch (TException e) {
			log.error("comparisonData", e);
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageHolder<ActivityUser> findAllActivityUser(Map<String, Object> parameter, int pageIndex, int pageSize) {
		try {
			return (PageHolder<ActivityUser>)ByteUtil.getObject(getClient().findAllActivityUser(ParamUtil.getFromByte(parameter), pageIndex, pageSize));
		} catch (ClassNotFoundException e) {
			log.error("findAllActivityUser", e);
			return null;
		} catch (IOException e) {
			log.error("findAllActivityUser", e);
			return null;
		} catch (TException e) {
			log.error("findAllActivityUser", e);
			return null;
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageHolder<ActivityPrize> findAllActivityPrize(Map<String, Object> parameter, int pageIndex, int pageSize) {
		try {
			return (PageHolder<ActivityPrize>)ByteUtil.getObject(getClient().findAllActivityPrize(ParamUtil.getFromByte(parameter), pageIndex, pageSize));
		} catch (ClassNotFoundException e) {
			log.error("findAllActivityPrize", e);
			return null;
		} catch (IOException e) {
			log.error("findAllActivityPrize", e);
			return null;
		} catch (TException e) {
			log.error("findAllActivityPrize", e);
			return null;
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageHolder<ActivityUserAwardNum> findAllUserAwardNum(Map<String, Object> parameter, int pageIndex, int pageSize) {
		try {
			return (PageHolder<ActivityUserAwardNum>)ByteUtil.getObject(getClient().findAllUserAwardNum(ParamUtil.getFromByte(parameter), pageIndex, pageSize));
		} catch (ClassNotFoundException e) {
			log.error("findAllUserAwardNum", e);
			return null;
		} catch (IOException e) {
			log.error("findAllUserAwardNum", e);
			return null;
		} catch (TException e) {
			log.error("findAllUserAwardNum", e);
			return null;
		}
		
	}

	@Override
	public int batchInsertActivityUser(List<ActivityUser> list) {
		try {
			if(list != null && list.size()>0)
			{
				List<ActivityUserThrift> listT = new ArrayList<ActivityUserThrift>();
				for(ActivityUser au : list)
				{
					listT.add(ClassCast.cast(au, ActivityUserThrift.class));
				}
				return getClient().batchInsertActivityUser(listT);
			}
			return 0;
		} catch (TException e) {
			log.error("batchInsertActivityUser", e);
			return 0;
		}
	}

	@Override
	public int addActivityPrize(ActivityPrize ap) {
		try {
			return getClient().addActivityPrize(ClassCast.cast(ap, ActivityPrizeThrift.class));
		} catch (TException e) {
			log.error("addActivityPrize", e);
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageHolder<ActivityUserAwardRecord> findAllActivityUserAwardRecord(Map<String, Object> parameter, int pageIndex, int pageSize) {
		try {
			return (PageHolder<ActivityUserAwardRecord>)ByteUtil.getObject(getClient().findAllActivityUserAwardRecord(ParamUtil.getFromByte(parameter), pageIndex, pageSize));
		} catch (ClassNotFoundException e) {
			log.error("findAllUserAwardNum", e);
			return null;
		} catch (IOException e) {
			log.error("findAllUserAwardNum", e);
			return null;
		} catch (TException e) {
			log.error("findAllUserAwardNum", e);
			return null;
		}
		
	}

	@Override
	public int delActivityPrize(int id) {
		try {
			return getClient().delActivityPrize(id);
		} catch (TException e) {
			log.error("delActivityPrize", e);
			return 0;
		}
	}

	@Override
	public int updateUserAwardRecordStatus(int pooId, int status) {
		try {
			return getClient().updateUserAwardRecordStatus(pooId, status);
		} catch (TException e) {
			log.error("updateUserAwardRecordStatus", e);
			return 0;
		}
	}

}
