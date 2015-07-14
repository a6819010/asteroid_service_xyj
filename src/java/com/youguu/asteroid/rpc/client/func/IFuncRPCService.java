package com.youguu.asteroid.rpc.client.func;

import java.util.List;

/**
* @Title: IFuncRPCService.java
* @Package com.youguu.asteroid.rpc.client.func
* @Description: ak控制应用功能
* @author zhaozhichao
* @date 2015年6月5日 下午4:02:49
* @version V1.0
 */
public interface IFuncRPCService {
	/**
	 * 
	* @Title: queryFunc
	* @Description: 根据ak查询方法
	* @param @param ak
	* @param @return    
	* @return List<Integer>    返回类型
	* @throws
	 */
	List<String> queryFunc(String ak);
}
