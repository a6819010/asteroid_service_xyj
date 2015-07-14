package com.youguu.asteroid.windvane.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;

import com.youguu.core.dao.SqlDAO;

public class WindVaneSqlDAO<T> extends SqlDAO<T> {
	public WindVaneSqlDAO() {
		super();
		setUseSimpleName(true);
	}

	@Resource(name = "windSessionFactory")
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
