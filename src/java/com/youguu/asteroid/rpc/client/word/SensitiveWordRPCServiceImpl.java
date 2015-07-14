package com.youguu.asteroid.rpc.client.word;

import com.youguu.asteroid.rpc.common.ClassCast;
import com.youguu.asteroid.rpc.common.Constants;
import com.youguu.asteroid.rpc.thrift.gen.SensitiveWordThrift;
import com.youguu.asteroid.word.pojo.SensitiveWord;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.core.util.PageHolder;
import com.youguu.core.util.ParamUtil;
import org.apache.thrift.TException;

import java.nio.ByteBuffer;
import java.util.Set;
/**
 * 
 * @ClassName: SensitiveWordRPCServiceImpl
 * @Description: 敏感词service实现（rpc）
 * @author zhanglei
 * @date 2014年11月6日 下午2:44:43
 *
 */
public class SensitiveWordRPCServiceImpl implements ISensitiveWordRPCService {
	
	private static final Log logger = LogFactory.getLog(Constants.ASTEROIDRPC_CLIENT);
	
	private SensitiveWordClient getClient(){
		return new SensitiveWordClient();
	}
	
	

	@Override
	public int addSensitiveWord(String words) {
		try {
			return getClient().addSensitiveWord(words);
		} catch (TException e) {
			logger.error(e.getMessage(), e);
			return -1;
		}
	}

	@Override
	public int updateSensitiveWord(SensitiveWord word) {
		try {
			SensitiveWordThrift swt = ClassCast.pojoToThrift(word);
			return getClient().updateSensitiveWord(swt);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return -1;
		}
	}

	@Override
	public int deleteSensitiveWord(int id) {
		try {
			return getClient().deleteSensitiveWord(id);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return -1;
		}
	}

	@Override
	public SensitiveWord getSensitiveWord(int id) {
		try {
			SensitiveWordThrift swt = getClient().getSensitiveWord(id);
			return ClassCast.thriftToPojo(swt);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}


	@Override
	public PageHolder<SensitiveWord> querySensitiveWordList(String word,
			int pageIndex, int pageSize) {
		try {
			ByteBuffer buffer = getClient().querySensitiveWordList(word, pageIndex, pageSize);
			return (PageHolder<SensitiveWord>) ParamUtil.getFromByte(buffer);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}



	@Override
	public boolean isContainSensitiveWord(String text) {
		try {
			return getClient().isContainSensitiveWord(text);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return false;
		}
	}



	@Override
	public boolean refreshSensitiveWord() {
		try {
			return getClient().refreshSensitiveWord();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return false;
		}
	}



	@Override
	public Set<String> getMatchedWords(String text) {
		try {
			ByteBuffer buffer = getClient().getMatchedWords(text);
			return (Set<String>) ParamUtil.getFromByte(buffer);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public String getStringByImg(byte[] img) {
		try {
			return getClient().getStringByImg(ByteBuffer.wrap(img));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

}
