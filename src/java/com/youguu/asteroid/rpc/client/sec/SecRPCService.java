package com.youguu.asteroid.rpc.client.sec;

import java.nio.ByteBuffer;
import java.util.Date;
import java.util.List;

import com.youguu.asteroid.sec.pojo.SecAccountRecord;
import com.youguu.asteroid.sec.pojo.SecAccountAndTrade;
import com.youguu.core.util.PageHolder;


public interface SecRPCService {
	
	public int addSecAccountAndTrade(SecAccountAndTrade secAccountAndTrade);

	public int delSecAccountAndTradeById(int id);
	
	public int updateSecAccountAndTrade(SecAccountAndTrade secAccountAndTrade);

	public SecAccountAndTrade getSecAccountAndTradeById(int id);

	public List<SecAccountAndTrade> getSecAccountAndTradeList(int osType,int type) ;

	public int addSecAccountRecord(SecAccountRecord secAccountRecord);

	public SecAccountRecord getSecAccountRecordById(int id);
	
	public List<SecAccountRecord> getSecAccountRecordList(String phone, int secNo,
			Date createtime) ;

	public PageHolder<SecAccountRecord> querySecAccountRecord(String phone, int secNo,
			Date createtime, int pageIndex, int pageSize) ;
}
