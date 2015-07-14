package com.youguu.asteroid.ad.service;

import java.util.HashMap;
import java.util.List;

import com.youguu.asteroid.ad.pojo.AdWall;
import com.youguu.core.util.PageHolder;

public interface IAdWallService {
	/**
	 * 添加广告
	 * @param t
	 * @return
	 */
	public int addAdWall(AdWall t);
	
	/**
	 * 删除广告
	 * @param id
	 * @return
	 */
	public int deleteAdWall(int id);
	
	/**
	 * 修改广告
	 * @param t
	 * @return
	 */
	public int updateAdWall(AdWall t);
	
	/**
	 * 查询广告
	 * @param id
	 * @return
	 */
	public AdWall getAdWall(int id);
	
	/**
	 * 查询广告 分页
	 * @param hm
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public PageHolder<AdWall> queryAdWallList(HashMap<String, Object> hm,int pageIndex,int pageSize);
	
	/**
	 * 将广告按位置类型缓存到redis中
	 * @param positionType
	 * @return
	 */
	public boolean flushRedis(String positionType);
	
	/**
	 * 按照位置类型从redis中查询广告
	 * @param positionType
	 * @return
	 */
	public List<AdWall> queryAdWallFromRedis(String positionType);
}
