package com.youguu.asteroid.sec.service;

import java.util.List;

import com.youguu.asteroid.sec.pojo.SecAccountAndTrade;

public interface SecAccountTradeService {
	
	public int add(SecAccountAndTrade accountAndTrade);
	
	public int delete(int id);
	
	public int update(SecAccountAndTrade accountAndTrade);
	
	public List<SecAccountAndTrade> getList(int osType,int type);
	
	public SecAccountAndTrade get(int id);

}
