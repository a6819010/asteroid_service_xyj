package com.youguu.asteroid.sec.dao.impl;

import org.springframework.stereotype.Repository;

import com.youguu.asteroid.base.AsteroidSqlDAO;
import com.youguu.asteroid.sec.dao.SecAccountAndTradeDAO;
import com.youguu.asteroid.sec.pojo.SecAccountAndTrade;

@Repository("secAccountAndTradeDAO")
public class SecAccountAndTradeDAOImpl extends AsteroidSqlDAO<SecAccountAndTrade> implements SecAccountAndTradeDAO {

}
