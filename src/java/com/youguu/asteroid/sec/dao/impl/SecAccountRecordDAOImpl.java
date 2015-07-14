package com.youguu.asteroid.sec.dao.impl;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.youguu.asteroid.base.AsteroidSqlDAO;
import com.youguu.asteroid.sec.dao.SecAccountRecordDAO;
import com.youguu.asteroid.sec.pojo.SecAccountRecord;
import com.youguu.core.util.PageHolder;

@Repository("secAccountRecordDAO")
public class SecAccountRecordDAOImpl extends AsteroidSqlDAO<SecAccountRecord> implements SecAccountRecordDAO {
	
	public PageHolder<SecAccountRecord> querySecAccountRecord(HashMap<String,Object> map,int pageIndex, int pageSize){
		return this.pagedQuery("findByParams", map, pageIndex, pageSize);
	}

}
