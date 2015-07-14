package com.youguu.asteroid.wxgift.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.youguu.asteroid.wxgift.dao.OpenlogDAO;
import com.youguu.asteroid.wxgift.dao.WxgiftSqlDAO;
import com.youguu.asteroid.wxgift.pojo.Openlog;
@Repository("openlogDAO")
public class OpenlogDAOImpl extends WxgiftSqlDAO<Openlog> implements OpenlogDAO {

	@Override
	public Openlog getOpenlog(String openid, String hopenid) {
		Map<String, String>  map = new HashMap<String, String>();
		map.put("openid", openid);
		map.put("hopenid", hopenid);
		return this.findUniqueBy("getOpenlog", map);
	}

	@Override
	public int saveOpenlog(String openid, String hopenid, int num) {
		Openlog ol = new Openlog();
		ol.setOpenid(openid);
		ol.setHopenid(hopenid);
		ol.setNum(num);
		return this.insert(ol);
	}

}
