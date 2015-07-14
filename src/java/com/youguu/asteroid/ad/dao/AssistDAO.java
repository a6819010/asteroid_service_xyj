package com.youguu.asteroid.ad.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;

import com.youguu.core.dao.SqlDAO;

public class AssistDAO<T> extends SqlDAO<T> {
	public AssistDAO() {
		super();
		setUseSimpleName(true);
	}

	@Resource(name = "astAssistSessionFactory")
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

}
