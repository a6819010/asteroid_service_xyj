package com.youguu.asteroid.activity.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;

import com.youguu.core.dao.SqlDAO;

public class ActivitySqlDAO<T> extends SqlDAO<T> {
	
	public ActivitySqlDAO() {
		super();
		setUseSimpleName(true);
	}

	@Resource(name = "activitySessionFactory")
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

}
