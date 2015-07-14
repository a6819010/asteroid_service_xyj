package com.youguu.asteroid.wxgift.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;

import com.youguu.core.dao.SqlDAO;

public class WxgiftSqlDAO<T> extends SqlDAO<T> {
	public WxgiftSqlDAO() {
		super();
		setUseSimpleName(true);
	}

	@Resource(name = "wxgiftSessionFactory")
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
