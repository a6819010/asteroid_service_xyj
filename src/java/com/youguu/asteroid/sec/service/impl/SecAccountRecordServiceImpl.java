package com.youguu.asteroid.sec.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.youguu.asteroid.sec.dao.impl.SecAccountRecordDAOImpl;
import com.youguu.asteroid.sec.pojo.SecAccountRecord;
import com.youguu.asteroid.sec.service.SecAccountRecordService;
import com.youguu.core.util.PageHolder;

@Service("secAccountRecordService")
public class SecAccountRecordServiceImpl implements SecAccountRecordService {

	@Resource
	private SecAccountRecordDAOImpl secAccountRecordDAO;
	@Override
	public int add(SecAccountRecord s) {
		return secAccountRecordDAO.insert(s);
	}

	@Override
	public SecAccountRecord get(int id) {
		return secAccountRecordDAO.get(id);
	}

	@Override
	public PageHolder<SecAccountRecord> querySecAccountRecord(String phone,int secNo, Date createtime, int pageIndex, int pageSize) {
		HashMap<String,Object> map=new HashMap<String,Object>();
		if(phone!=null&&!phone.equals(""))
			map.put("phone", phone);
		if(secNo!=0)
			map.put("secNo", secNo);
		if(createtime!=null)
			map.put("createtime", createtime);
		return secAccountRecordDAO.querySecAccountRecord(map, pageIndex, pageSize);
	}

	@Override
	public List<SecAccountRecord> getList(String phone, int secNo,
			Date createtime) {
		HashMap<String,Object> map=new HashMap<String,Object>();
		if(phone!=null&&!phone.equals(""))
			map.put("phone", phone);
		if(secNo!=0)
			map.put("secNo", secNo);
		if(createtime!=null)
			map.put("createtime", createtime);
		return secAccountRecordDAO.findBy("findByParams", map);
	}


}
