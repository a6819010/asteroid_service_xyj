package com.youguu.asteroid.ad.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.youguu.asteroid.ad.dao.AdWallDAO;
import com.youguu.asteroid.ad.pojo.AdWall;
import com.youguu.asteroid.ad.service.IAdWallService;
import com.youguu.core.util.PageHolder;
import com.youguu.core.util.RedisUtil;
import com.youguu.core.util.redis.RedisPool;

@Service("adWallService")
public class AdWallServiceImpl implements IAdWallService {

	public static final String AD_REDIS_KEY = "mncg:ad";
	
	@Resource
	private AdWallDAO adWallDAO;
	
	@Override
	public int addAdWall(AdWall t) {
		int result = adWallDAO.insert(t);
		if(result>0){
			flushRedis(t.getPositionType());
		}
		return result;
	}

	@Override
	public int deleteAdWall(int id) {
		AdWall t = getAdWall(id);
		int result = adWallDAO.delete(id);
		if(result>0){
			flushRedis(t.getPositionType());
		}
		return result;
	}

	@Override
	public int updateAdWall(AdWall t) {
		int result = adWallDAO.update(t);
		if(result>0){
			flushRedis(t.getPositionType());
		}
		return result;
	}

	@Override
	public AdWall getAdWall(int id) {
		return adWallDAO.get(id);
	}

	@Override
	public PageHolder<AdWall> queryAdWallList(HashMap<String, Object> hm,
			int pageIndex, int pageSize) {
		return adWallDAO.pagedQuery("findByParams", hm, pageIndex, pageSize);
	}

	@Override
	public boolean flushRedis(String positionType) {
		RedisPool redisPool = null;
		try {
			redisPool = RedisUtil.getRedisPool("user");
			
			boolean flag = redisPool.exists(AD_REDIS_KEY+":"+positionType);
			if(flag){
				redisPool.del(AD_REDIS_KEY+":"+positionType);
			}
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("positionType", positionType);
			map.put("cols", "rank asc");
			PageHolder<AdWall> pageHolder = queryAdWallList(map, 1, 100);
			redisPool.rpush(AD_REDIS_KEY+":"+positionType, pageHolder.getList());
			return true;
		} catch (Exception e) {
			//ingnore
		}
		return false;
	}

	@Override
	public List<AdWall> queryAdWallFromRedis(String positionType) {
		RedisPool redisPool = null;
		List<AdWall> filterList = new ArrayList<>();
		try {
			redisPool = RedisUtil.getRedisPool("user");
			List<AdWall> list = redisPool.lrange(AD_REDIS_KEY+":"+positionType, AdWall.class, 0, -1);
			for(AdWall ad : list){
				if(new Date().getTime()>=ad.getBeginDate().getTime() && ad.getEndDate().getTime()>=new Date().getTime()){
					filterList.add(ad);
				}
			}
			return filterList;
		} catch (Exception e) {
			//ingnore
		}
		return null;
	}

}
