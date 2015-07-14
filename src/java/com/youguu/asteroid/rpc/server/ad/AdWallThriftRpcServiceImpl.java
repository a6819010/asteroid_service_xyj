package com.youguu.asteroid.rpc.server.ad;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import com.youguu.asteroid.ad.pojo.AdWall;
import com.youguu.asteroid.ad.service.IAdWallService;
import com.youguu.asteroid.rpc.common.ClassCast;
import com.youguu.asteroid.rpc.common.Constants;
import com.youguu.asteroid.rpc.thrift.gen.AdWallThrift;
import com.youguu.asteroid.rpc.thrift.gen.AdWallThriftRpcService.Iface;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.core.util.PageHolder;
import com.youguu.core.util.ParamUtil;
/**
 * 
 * @ClassName: AdWallThriftRpcServiceImpl
 * @Description: 模拟炒股广告墙rpc  server端service实现
 * @author zhanglei
 * @date 2014年12月4日 下午5:54:04
 *
 */
@Service("adWallThriftRpcService")
public class AdWallThriftRpcServiceImpl implements Iface {
	
	private static final Log logger = LogFactory.getLog(Constants.ASTEROIDRPC_SERVER);
	
	@Resource
	private IAdWallService adWallService;
	
	/**
	 * 添加广告
	 * @param t
	 * @return
	 */
	@Override
	public int addAdWall(AdWallThrift t) throws TException {
		try {
			AdWall adWall = ClassCast.thriftToPojo(t);
			return adWallService.addAdWall(adWall);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return 0;
		}
	}
	/**
	 * 删除广告
	 * @param id
	 * @return
	 */
	@Override
	public int deleteAdWall(int id) throws TException {
		try {
			return adWallService.deleteAdWall(id);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return 0;
		}
	}
	/**
	 * 修改广告
	 * @param t
	 * @return
	 */
	@Override
	public int updateAdWall(AdWallThrift t) throws TException {
		try {
			AdWall adWall = ClassCast.thriftToPojo(t);
			return adWallService.updateAdWall(adWall);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return 0;
		}
	}
	/**
	 * 查询广告
	 * @param id
	 * @return
	 */
	@Override
	public AdWallThrift getAdWall(int id) throws TException {
		try {
			AdWall adWall = adWallService.getAdWall(id);
			return ClassCast.pojoToThrift(adWall);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	/**
	 * 查询广告 分页
	 * @param hm
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@Override
	public ByteBuffer queryAdWallList(ByteBuffer hm, int pageIndex, int pageSize)
			throws TException {
		try {
			PageHolder<AdWall> pageHolder = adWallService.queryAdWallList((HashMap<String,Object>)ParamUtil.getFromByte(hm), pageIndex, pageSize);
			
			return ParamUtil.getFromByte(pageHolder);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}
	/**
	 * 将广告按位置类型缓存到redis中
	 * @param positionType
	 * @return
	 */
	@Override
	public boolean flushRedis(String positionType) throws TException {
		try {
			return adWallService.flushRedis(positionType);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return false;
		}
	}
	/**
	 * 按照位置类型从redis中查询广告
	 * @param positionType
	 * @return
	 */
	@Override
	public List<AdWallThrift> queryAdWallFromRedis(String positionType)
			throws TException {
		try {
			List<AdWall> list = adWallService.queryAdWallFromRedis(positionType);
			List<AdWallThrift> thriftList = new ArrayList<AdWallThrift>();
			if(list != null && list.size() > 0){
				for(AdWall aw : list){
					thriftList.add(ClassCast.pojoToThrift(aw));
				}
			}
			return thriftList;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

}
