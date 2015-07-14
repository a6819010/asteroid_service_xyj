package com.youguu.asteroid.windvane.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.youguu.asteroid.windvane.dao.IMarketWindVanePollVoteDAO;
import com.youguu.asteroid.windvane.dao.WindVaneSqlDAO;
import com.youguu.asteroid.windvane.pojo.MarketWindVanePollVote;
import com.youguu.core.util.PageHolder;

/**
* @Title: MarketWindVanePollVoteDAOImpl.java 
* @Package com.youguu.asteroid.windvane.dao.impl 
* @Description: 市场风向标投票统计DAO接口实现类
* @author 徐云杰
* @date 2014年12月1日 上午11:38:03 
* @version V1.0
 */
@Repository("marketWindVanePollVoteDAO")
public class MarketWindVanePollVoteDAOImpl extends WindVaneSqlDAO<MarketWindVanePollVote> implements
		IMarketWindVanePollVoteDAO {

	@Override
	public int insert(MarketWindVanePollVote o) {
		return super.insert(o);
	}
	
	@Override
	public int update(MarketWindVanePollVote o) {
		return super.update(o);
	}
	
	@Override
	public int delete(String date) {
		return super.delete(date);
	}

	@Override
	public MarketWindVanePollVote selectMarketWindVanePollVote(String date) {
		return super.get(date);
	}

	@Override
	public PageHolder<MarketWindVanePollVote> findAllMarketWindVanePollVote(
			Map<String, Object> parameter, int pageIndex, int pageSize) {
		return super.pagedQuery("findAllMarketWindVanePollVote", parameter, pageIndex, pageSize);
	}

	@Override
	public List<MarketWindVanePollVote> getNDaysWindVane(int daynum) {
		return super.findBy("getNDaysWindVane", daynum);
	}

	@Override
	public int updateResult(String date,int result) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("date", date);
		map.put("result", result);
		return super.updateBy("updateResult", map);
	}

}
