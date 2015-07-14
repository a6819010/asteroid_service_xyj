package com.youguu.asteroid.bank.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;

import com.youguu.core.dao.SqlDAO;

public class BankSqlDAO<T> extends SqlDAO<T>{
	public BankSqlDAO(){
		super();
		setUseSimpleName(true);
	}
	
	@Resource(name = "bankSessionFactory")
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
