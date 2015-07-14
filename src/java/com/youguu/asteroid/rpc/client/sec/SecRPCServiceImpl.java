package com.youguu.asteroid.rpc.client.sec;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.thrift.TException;

import com.youguu.asteroid.rpc.common.Constants;
import com.youguu.asteroid.rpc.thrift.gen.SecAccountRecordThrift;
import com.youguu.asteroid.rpc.thrift.gen.SecAccountAndTradeThrift;
import com.youguu.asteroid.sec.pojo.SecAccountRecord;
import com.youguu.asteroid.sec.pojo.SecAccountAndTrade;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.core.util.ClassCast;
import com.youguu.core.util.PageHolder;
import com.youguu.core.util.ParamUtil;

public class SecRPCServiceImpl implements SecRPCService {
	private static final Log logger = LogFactory.getLog(Constants.ASTEROIDRPC_CLIENT);

	private SecClient getClient(){
		return new SecClient();
	}
	@Override
	public int addSecAccountAndTrade(SecAccountAndTrade secAccountAndTrade) {
		try {
			return getClient().addSecAccountAndTrade(ClassCast.cast(secAccountAndTrade, SecAccountAndTradeThrift.class));
		} catch (TException e) {
			logger.error(e);
			return 0;
		}
	}

	@Override
	public int delSecAccountAndTradeById(int id) {
		try {
			return getClient().delSecAccountAndTradeById(id);
		} catch (TException e) {
			logger.error(e);
			return 0;
		}
	}

	@Override
	public int updateSecAccountAndTrade(SecAccountAndTrade secAccountAndTrade) {
		try {
			return getClient().updateSecAccountAndTrade(ClassCast.cast(secAccountAndTrade, SecAccountAndTradeThrift.class));
		} catch (TException e) {
			logger.error(e);
			return 0;
		}
	}
	
	@Override
	public SecAccountAndTrade getSecAccountAndTradeById(int id) {
		try {
			return ClassCast.cast(getClient().getSecAccountAndTradeById(id),SecAccountAndTrade.class);
		} catch (TException e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public List<SecAccountAndTrade> getSecAccountAndTradeList(int osType,int type) {
		try {
			List<SecAccountAndTrade> result=new ArrayList<SecAccountAndTrade>();
			List<SecAccountAndTradeThrift> list=getClient().getSecAccountAndTradeList(osType, type);
			if(list!=null&&list.size()>0){
				for (SecAccountAndTradeThrift secAccountAndTradeThrift : list) {
					result.add(ClassCast.cast(secAccountAndTradeThrift, SecAccountAndTrade.class));
				}
			}
			return result;
		} catch (TException e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public int addSecAccountRecord(SecAccountRecord secAccountRecord) {
		try {
			return getClient().addSecAccountRecord(ClassCast.cast(secAccountRecord, SecAccountRecordThrift.class));
		} catch (TException e) {
			logger.error(e);
			return 0;
		}
	}

	@Override
	public SecAccountRecord getSecAccountRecordById(int id) {
		try {
			return ClassCast.cast(getClient().getSecAccountRecordById(id),SecAccountRecord.class);
		} catch (TException e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public PageHolder<SecAccountRecord> querySecAccountRecord(String phone, int secNo,
			Date createtime, int pageIndex, int pageSize) {
		try {
			ByteBuffer bb = getClient().querySecAccountRecord(phone, secNo, createtime.getTime(), pageIndex, pageSize);
			return (PageHolder<SecAccountRecord>) ParamUtil.getFromByte(bb);
		} catch (TException e) {
			logger.error(e);
			return null;
		}
	}

	@Override
	public List<SecAccountRecord> getSecAccountRecordList(String phone,
			int secNo, Date createtime) {
		try {
			List<SecAccountRecord> result=new ArrayList<SecAccountRecord>();
			List<SecAccountRecordThrift> list=getClient().getSecAccountRecordThriftList(phone, secNo, createtime.getTime());
			if(list!=null&&list.size()>0){
				for (SecAccountRecordThrift secAccountRecordThrift : list) {
					result.add(ClassCast.cast(secAccountRecordThrift, SecAccountRecord.class));
				}
			}
			return result;
		} catch (TException e) {
			logger.error(e);
			return null;
		}
	}

}
