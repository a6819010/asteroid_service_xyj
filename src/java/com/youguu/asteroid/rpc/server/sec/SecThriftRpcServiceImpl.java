package com.youguu.asteroid.rpc.server.sec;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import com.youguu.asteroid.rpc.thrift.gen.SecAccountAndTradeThrift;
import com.youguu.asteroid.rpc.thrift.gen.SecAccountRecordThrift;
import com.youguu.asteroid.rpc.thrift.gen.SecThriftRpcService;
import com.youguu.asteroid.sec.pojo.SecAccountAndTrade;
import com.youguu.asteroid.sec.pojo.SecAccountRecord;
import com.youguu.asteroid.sec.service.SecAccountRecordService;
import com.youguu.asteroid.sec.service.SecAccountTradeService;
import com.youguu.core.util.ClassCast;
import com.youguu.core.util.PageHolder;
import com.youguu.core.util.ParamUtil;

@Service("secThriftRpcService")
public class SecThriftRpcServiceImpl implements SecThriftRpcService.Iface {

	@Resource
	SecAccountTradeService secAccountTradeService;
	@Resource
	SecAccountRecordService secAccountRecordService;
	@Override
	public int addSecAccountAndTrade(SecAccountAndTradeThrift secAccountAndTradeThrift) throws TException {
		return secAccountTradeService.add(ClassCast.cast(secAccountAndTradeThrift, SecAccountAndTrade.class));
	}

	@Override
	public int delSecAccountAndTradeById(int id) throws TException {
		return secAccountTradeService.delete(id);
	}
	
	@Override
	public int updateSecAccountAndTrade(
			SecAccountAndTradeThrift secAccountAndTradeThrift)
			throws TException {
		return secAccountTradeService.update(ClassCast.cast(secAccountAndTradeThrift, SecAccountAndTrade.class));
	}

	@Override
	public SecAccountAndTradeThrift getSecAccountAndTradeById(int id) throws TException {
		return ClassCast.cast(secAccountTradeService.get(id),SecAccountAndTradeThrift.class);
	}

	@Override
	public List<SecAccountAndTradeThrift> getSecAccountAndTradeList(int osType,int type) throws TException {
		List<SecAccountAndTradeThrift> result=new ArrayList<SecAccountAndTradeThrift>();
		List<SecAccountAndTrade> list=secAccountTradeService.getList(osType, type);
		if(list!=null && list.size()>0){
			for (SecAccountAndTrade secAccountAndTrade : list) {
				SecAccountAndTradeThrift secAccountAndTradeThrift=ClassCast.cast(secAccountAndTrade,SecAccountAndTradeThrift.class);
				result.add(secAccountAndTradeThrift);
			}
		}
		return result;
	}

	@Override
	public int addSecAccountRecord(SecAccountRecordThrift secAccountRecordThrift)
			throws TException {
		return secAccountRecordService.add(ClassCast.cast(secAccountRecordThrift, SecAccountRecord.class));
	}

	@Override
	public SecAccountRecordThrift getSecAccountRecordById(int id)
			throws TException {
		return ClassCast.cast(secAccountRecordService.get(id),SecAccountRecordThrift.class);
	}

	@Override
	public ByteBuffer querySecAccountRecord(String phone, int secNo,
			long createtime, int pageIndex, int pageSize) throws TException {
		Date create=new Date(createtime);
		PageHolder<SecAccountRecord> pageHodler = secAccountRecordService.querySecAccountRecord(phone, secNo, create, pageIndex, pageSize);
		return ParamUtil.getFromByte(pageHodler);
	}

	@Override
	public List<SecAccountRecordThrift> getSecAccountRecordThriftList(
			String phone, int secNo, long createtime) throws TException {
		List<SecAccountRecordThrift> result=new ArrayList<SecAccountRecordThrift>();
		List<SecAccountRecord> list=secAccountRecordService.getList( phone, secNo, new Date( createtime));
		if(list!=null && list.size()>0){
			for (SecAccountRecord secAccountRecord : list) {
				SecAccountRecordThrift secAccountRecordThrift=ClassCast.cast(secAccountRecord,SecAccountRecordThrift.class);
				result.add(secAccountRecordThrift);
			}
		}
		return result;
	}

}
