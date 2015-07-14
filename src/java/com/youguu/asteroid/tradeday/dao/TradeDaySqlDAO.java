package com.youguu.asteroid.tradeday.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;

import com.youguu.core.dao.SqlDAO;

public class TradeDaySqlDAO<T> extends SqlDAO<T> {
	public TradeDaySqlDAO() {
		super();
		setUseSimpleName(true);
	}

	@Resource(name = "ruleSessionFactory")
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
