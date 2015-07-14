package com.youguu.asteroid.func.service;

import java.util.List;

public interface IFuncService {
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
