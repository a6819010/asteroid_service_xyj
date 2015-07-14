package com.youguu.asteroid.sec.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.youguu.asteroid.sec.dao.impl.SecAccountAndTradeDAOImpl;
import com.youguu.asteroid.sec.pojo.SecAccountAndTrade;
import com.youguu.asteroid.sec.service.SecAccountTradeService;

@Service("secAccountTradeService")
public class SecAccountTradeServiceImpl implements SecAccountTradeService {

	@Resource
	private SecAccountAndTradeDAOImpl secAccountAndTradeDAO;
	@Override
	public int add(SecAccountAndTrade accountAndTrade) {
		return secAccountAndTradeDAO.insert(accountAndTrade);
	}

	@Override
	public int delete(int id) {
		return secAccountAndTradeDAO.delete(id);
	}

	@Override
	public int update(SecAccountAndTrade accountAndTrade) {
		return secAccountAndTradeDAO.update(accountAndTrade);
	}

	@Override
	public List<SecAccountAndTrade> getList(int osType, int type) {
		Map<String,Object> map=new HashMap<String,Object>();
		if(osType!=0)
			map.put("osType", osType);
		if(type!=0)
			map.put("type", type);
		return secAccountAndTradeDAO.findBy("findByParams", map);
	}

	@Override
	public SecAccountAndTrade get(int id) {
		return secAccountAndTradeDAO.get(id);
	}


}
