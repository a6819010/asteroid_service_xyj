package com.youguu.asteroid.sec.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.youguu.asteroid.sec.pojo.SecAccountRecord;
import com.youguu.core.util.PageHolder;

public interface SecAccountRecordService {
	
	public int add(SecAccountRecord s);
	
	public SecAccountRecord get(int id);
	
	public List<SecAccountRecord> getList(String phone,int secNo,Date createtime);
	
	public PageHolder<SecAccountRecord> querySecAccountRecord(String phone,int secNo,Date createtime, int pageIndex, int pageSize);

}
