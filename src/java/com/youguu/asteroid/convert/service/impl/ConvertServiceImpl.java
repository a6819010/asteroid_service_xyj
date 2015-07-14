package com.youguu.asteroid.convert.service.impl;

import com.youguu.asteroid.convert.service.IConvertService;
import com.youguu.asteroid.convert.util.BdApiUtil;
import org.springframework.stereotype.Service;

/**
 * Created by lqipr on 2015/7/14.
 */
@Service("convertService")
public class ConvertServiceImpl implements IConvertService {
    
    @Override
    public String getStringByImg(byte[] img) {
        return BdApiUtil.getStringByImg(img);
    }
}
