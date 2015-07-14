package com.youguu.asteroid.windvane.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.youguu.asteroid.windvane.dao.IMarketWindVanePollVoteDAO;
import com.youguu.asteroid.windvane.pojo.MarketWindVanePollVote;
import com.youguu.asteroid.windvane.service.IMarketWindVanePollVoteService;
import com.youguu.core.util.PageHolder;

/**
 * 
* @Title: MarketWindVanePollVoteServiceImpl.java 
* @Package com.youguu.asteroid.windvane.service.impl 
* @Description: T市场风向标投票统计Service接口实现类 
* @author 徐云杰
* @date 2014年12月1日 上午11:40:55 
* @version V1.0
 */
@Service("marketWindVanePollVoteService")
public class MarketWindVanePollVoteServiceImpl implements IMarketWindVanePollVoteService {

	@Resource
	private IMarketWindVanePollVoteDAO marketWindVanePollVoteDAO;
	
	@Override
	public int addMarketWindVanePollVote(
			MarketWindVanePollVote marketWindVanePollVote) {
		return marketWindVanePollVoteDAO.insert(marketWindVanePollVote);
	}

	@Override
	public int updateMarketWindVanePollVote(
			MarketWindVanePollVote marketWindVanePollVote) {
		return marketWindVanePollVoteDAO.update(marketWindVanePollVote);
	}

	@Override
	public int deleteMarketWindVanePollVote(String date) {
		return marketWindVanePollVoteDAO.delete(date);
	}

	@Override
	public MarketWindVanePollVote getMarketWindVanePollVote(String date) {
		return marketWindVanePollVoteDAO.selectMarketWindVanePollVote(date);
	}

	@Override
	public PageHolder<MarketWindVanePollVote> findAllMarketWindVanePollVote(
			Map<String, Object> parameter, int pageIndex, int pageSize) {
		return marketWindVanePollVoteDAO.findAllMarketWindVanePollVote(parameter, pageIndex, pageSize);
	}

	@Override
	public List<Double> getNDaysWindVane(int daynum) {
		List<MarketWindVanePollVote> list = marketWindVanePollVoteDAO.getNDaysWindVane(daynum);
		List<Double> listf = new ArrayList<Double>();
		if(list != null)
		{
			float up;
			float down;
			float arg;
			for(int i = list.size()-1;i>=0;i--)
			{
				up = list.get(i).getUp();
				down = list.get(i).getDown();
				arg = (float)Math.log(up/down);
				listf.add((double)(Math.round(arg*100))/100);
			}
		}
		return listf;
	}

	@Override
	public int updateResult(String date,int result) {
		return marketWindVanePollVoteDAO.updateResult(date,result);
	}

	@Override
	public List<String> getNDaysWindVaneTime(int daynum) {
		List<MarketWindVanePollVote> list = marketWindVanePollVoteDAO.getNDaysWindVane(daynum);
		List<String> listf = new ArrayList<String>();
		String date = "";
		if(list != null)
		{
			for(int i = list.size()-1;i>=0;i--)
			{
				date = list.get(i).getDate();
				date = date.replace("-", "/");
				date = date.substring(date.indexOf("/")+1);
				listf.add(date);
			}
		}
		return listf;
	}

}
