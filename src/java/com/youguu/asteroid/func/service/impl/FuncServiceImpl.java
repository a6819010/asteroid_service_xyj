package com.youguu.asteroid.func.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.stereotype.Service;

import com.youguu.asteroid.func.service.IFuncService;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.core.pojo.AK;
import com.youguu.core.util.PropertiesUtil;
/**
 * 
 * @ClassName: FuncServiceImpl
 * @Description: 根据ak查询数据
 * 配置文件格式
 * 第一行：全部功能列表
 * all=1,2,3
 * 每一行
 * os_version_name=1,2,3
 * 如：
 * 1_5.1.2=1,2,3
 * 
 * OS_APPLE:1
 * OS_ANDROID:3
 * @author wangdong
 * @date 2015年6月4日 下午7:29:36
 *
 */
@Service("funcService")
public class FuncServiceImpl implements IFuncService {
	
	Log logger = LogFactory.getLog(FuncServiceImpl.class);
	
	
	private final static String CONFIGPATH = "properties/func_config.properties";
	
	/**
	 * 默认全部功能的key
	 */
	private final static String ALL = "all";
	@Override
	public List<String> queryFunc(String ak) {
		try {
			AK ak_pojo = new AK(ak);
			Properties p = PropertiesUtil.getProperties(CONFIGPATH);
			String key = String.format("%s_%s", ak_pojo.getOs(),ak_pojo.getVersion_name());
			String funcs = p.getProperty(key);
			if(funcs==null){
				funcs = p.getProperty(ALL);
			}
			if(funcs!=null){
				String funcArray[] = funcs.split(",");
				List<String> result = new ArrayList<>();
				for(String func:funcArray){
					result.add(func);
				}
				return result;
			}
			
		} catch (IOException e) {
			logger.error("查询当前版本支持的功能异常", e);
		}
		return new ArrayList<>();
	}

}
