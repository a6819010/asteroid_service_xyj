package com.youguu.asteroid.fund.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;

import com.youguu.core.dao.SqlDAO;

/**
* @Title: FundSqlDAO.java
* @Package com.youguu.asteroid.fund
* @Description: fundSessionFactory
* @author zhaozhichao
* @date 2015年5月25日 下午4:35:19
* @version V1.0
 */
public class FundSqlDAO<T> extends SqlDAO<T>{
	public FundSqlDAO(){
		super();
		setUseSimpleName(true);
	}
	
	@Resource(name = "fundSessionFactory")
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
