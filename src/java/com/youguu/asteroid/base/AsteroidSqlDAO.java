package com.youguu.asteroid.base;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;

import com.youguu.core.dao.SqlDAO;
/**
 * 
 * @ClassName: AsteroidSqlDAO
 * @Description: 小行星相关基础Dao
 * @author zhanglei
 * @date 2014年12月5日 上午11:53:06
 *
 */
public class AsteroidSqlDAO<T> extends SqlDAO<T>{
	
	public AsteroidSqlDAO(){
		super();
		setUseSimpleName(true);
	}
	
	@Resource(name = "asteroidSessionFactory")
	@Override
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
}
