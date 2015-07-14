package com.youguu.asteroid.wxgift.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.youguu.asteroid.wxgift.dao.AllocateDAO;
import com.youguu.asteroid.wxgift.dao.UserInfoDAO;
import com.youguu.asteroid.wxgift.pojo.Allocate;
import com.youguu.asteroid.wxgift.pojo.Openlog;
import com.youguu.asteroid.wxgift.pojo.UserInfo;
import com.youguu.asteroid.wxgift.service.IWxgiftService;
import com.youguu.asteroid.wxgift.util.GiftType;

@Service("wxgiftService")
public class WxgiftServiceImpl implements IWxgiftService{
	private static int maxuser = 10;
	
	@Resource
	private AllocateDAO allocateDAO;
	
	@Resource
	private UserInfoDAO userInfoDAO;
	
	@Resource
	private com.youguu.asteroid.wxgift.dao.OpenlogDAO openlogDAO;
	
	
	@Override
	public JSONObject queryStatus(String openid, String hopenid) {
		JSONObject result = new JSONObject();
		int notnum = maxuser;
		//查询用户是否有红包记录
		UserInfo ui = userInfoDAO.getUserInfo(openid);
		if(ui!=null){
			result.put("num", ui.getNum());
			notnum = maxuser - ui.getNum() < 0 ? 0 : (maxuser - ui.getNum());
			if(ui.getNum() >= maxuser && ui.getType() == 0){//为用户分奖
				allocate(ui.getNum(),ui.getType(),openid);
				ui = userInfoDAO.getUserInfo(openid);
			}
			
			
			if(ui.getNum() < maxuser){//任务不足  还可以刮
				if(!openid.equals(hopenid)){
					//判断用户是否已经挂过
					Openlog ol = openlogDAO.getOpenlog(openid, hopenid);
					if(ol!=null){//已经拆过
						result.put("userStatus", 1);
					}else{
						result.put("userStatus", 2);
					}
				}
				result.put("sta", 1);
			}else{//用户的红包已经打开
				
				if(ui.getType()==0){ //今日奖品已经分配完
					result.put("sta", 4);
				}else{
					result.put("type", ui.getType());
					result.put("des", GiftType.getDes(ui.getType()));
					if(openid.equals(hopenid)){
						result.put("cdkey", ui.getCdkey());
					}
					System.out.println("phone:" + ui.getPhone());
					if(!GiftType.isProp(ui.getType()) && (ui.getPhone()==null || "".equals(ui.getPhone()))){//需要录入手机号
						result.put("sta", 2);
					}else{
						result.put("sta", 3);
					}
				}
				
			}
		}else{//还没有用户协助拆红包
			result.put("sta", 1);
			result.put("userStatus", 2);
			result.put("num", 0);
		}
		
		result.put("notnum", notnum);
		
		//if openid!=hopenid 查询当前用户是否已经帮忙拆红包
		
		return result;
	}

	@Override
	public int open(String openid, String hopenid) {
		if(!openid.equals(hopenid)){
			UserInfo ui = userInfoDAO.getUserInfo(openid);
			if(ui!=null){
				if(ui.getNum() < maxuser){//任务不足  还可以刮
					Openlog ol = openlogDAO.getOpenlog(openid, hopenid);
					if(ol!=null){
						return -1; //已经拆过
					}else{
						//TODO 保存拆包数据
						int num = ui.getNum() + 1;
						int result = openlogDAO.saveOpenlog(openid, hopenid, num);
						result = userInfoDAO.incOpenNum(openid,1);
						allocate(num,ui.getType(),openid);
						return 1;
					}
				}else{
					return -2; //红包已经拆满
				}
			}else{
				//记录用户数据
				//TODO 保存拆包数据
				int result = openlogDAO.saveOpenlog(openid, hopenid, 1);
				result = userInfoDAO.saveUserInfo(openid);
				return 1;
			}
		}else{
			return -3; //自己不能为自己拆红包
		}
		
		
	}

	@Override
	public int phone(String openid, String phone) {
		int result = userInfoDAO.updateUserPhone(openid, phone);
		return result;
	}
	
	
	private void allocate(int num , int type , String openid){
		//分配奖品 -- 满足条件进行奖品分配
		if(num >= maxuser && type==0 ){
			synchronized (WxgiftServiceImpl.class) {
				UserInfo ui = userInfoDAO.getUserInfo(openid);
				if(ui.getNum() >= maxuser && ui.getType() ==0){
					Allocate a = allocateDAO.getNextAllocate();
					if(a!=null){
						allocateDAO.sucAllocateStatus(a.getId(),openid);
						userInfoDAO.updateAllocate(openid, a.getType(), a.getCdkey());
					}
					
				}
			}
		}
	}

}
