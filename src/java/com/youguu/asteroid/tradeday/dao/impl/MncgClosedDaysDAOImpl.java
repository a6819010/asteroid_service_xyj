package com.youguu.asteroid.tradeday.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.youguu.asteroid.tradeday.dao.IMncgClosedDaysDAO;
import com.youguu.asteroid.tradeday.dao.TradeDaySqlDAO;
import com.youguu.asteroid.tradeday.pojo.MncgClosedDays;

/**
 * 
* @Title: TradeDayDAOImpl.java 
* @Package com.youguu.asteroid.tradeday.dao.impl 
* @Description: 交易日接口实现类
* @author 徐云杰
* @date 2014年11月27日 下午3:41:22 
* @version V1.0
 */
@Repository("mncgClosedDaysDAO")
public class MncgClosedDaysDAOImpl extends TradeDaySqlDAO<MncgClosedDays>  implements IMncgClosedDaysDAO{

	@Override
	public Set<String> getTradeDayList() {
		List<String> list = this.findBy("getTradeDayList", null);
		Set<String> set = new HashSet<String>(list);
		return set;
	}

	@Override
	public String getMaxTradeDay() {
		return this.getObject("getMaxTradeDay", null);
	}

}
