package com.youguu.asteroid.rpc.client.ad;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.thrift.TException;

import com.youguu.asteroid.ad.pojo.AdWall;
import com.youguu.asteroid.rpc.common.ClassCast;
import com.youguu.asteroid.rpc.common.Constants;
import com.youguu.asteroid.rpc.thrift.gen.AdWallThrift;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.core.util.PageHolder;
import com.youguu.core.util.ParamUtil;
/**
 * 
 * @ClassName: IAdWallRPCService
 * @Description: 模拟炒股广告墙接口实现（RPC）
 * @author zhanglei
 * @date 2014年12月5日 上午9:19:54
 *
 */
public class AdWallRPCServiceImpl implements IAdWallRPCService {

	private static final Log logger = LogFactory.getLog(Constants.ASTEROIDRPC_CLIENT);
	
	private AdWallClient getClient(){
		return new AdWallClient();
	}
	
	/**
	 * 添加广告
	 * @param t
	 * @return
	 */
	@Override
	public int addAdWall(AdWall t) {
		try {
			AdWallThrift at = ClassCast.pojoToThrift(t);
			return getClient().addAdWall(at);
		} catch (TException e) {
			logger.error(e.getMessage(), e);
			return -1;
		}
	}
	/**
	 * 删除广告
	 * @param id
	 * @return
	 */
	@Override
	public int deleteAdWall(int id) {
		try {
			return getClient().deleteAdWall(id);
		} catch (TException e) {
			logger.error(e.getMessage(), e);
			return -1;
		}
	}
	/**
	 * 修改广告
	 * @param t
	 * @return
	 */
	@Override
	public int updateAdWall(AdWall t) {
		try {
			AdWallThrift at = ClassCast.pojoToThrift(t);
			return getClient().updateAdWall(at);
		} catch (TException e) {
			logger.error(e.getMessage(), e);
			return -1;
		}
	}
	
	/**
	 * 查询广告
	 * @param id
	 * @return
	 */
	@Override
	public AdWall getAdWall(int id) {
		try {
			AdWallThrift awt = getClient().getAdWall(id);
			return ClassCast.thriftToPojo(awt);
		} catch (TException e) {
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
	public PageHolder<AdWall> queryAdWallList(HashMap<String, Object> hm,
			int pageIndex, int pageSize) {
		try {
			ByteBuffer buffer = getClient().queryAdWallList(ParamUtil.getFromByte(hm), pageIndex, pageSize);
			return (PageHolder<AdWall>) ParamUtil.getFromByte(buffer);
		} catch (TException e) {
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
	public boolean flushRedis(String positionType) {
		try {
			return getClient().flushRedis(positionType);
		} catch (TException e) {
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
	public List<AdWall> queryAdWallFromRedis(String positionType) {
		try {
			List<AdWallThrift> list = getClient().queryAdWallFromRedis(positionType);
			List<AdWall> pojoList = new ArrayList<AdWall>();
			if(list != null && list.size() > 0){
				for(AdWallThrift awt : list){
					pojoList.add(ClassCast.thriftToPojo(awt));
				}
			}
			return pojoList;
		} catch (TException e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

}
