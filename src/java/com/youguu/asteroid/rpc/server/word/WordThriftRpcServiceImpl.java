package com.youguu.asteroid.rpc.server.word;

import com.youguu.asteroid.convert.service.IConvertService;
import com.youguu.asteroid.rpc.common.ClassCast;
import com.youguu.asteroid.rpc.common.Constants;
import com.youguu.asteroid.rpc.thrift.gen.SensitiveWordThrift;
import com.youguu.asteroid.rpc.thrift.gen.WordThriftRpcService.Iface;
import com.youguu.asteroid.word.pojo.SensitiveWord;
import com.youguu.asteroid.word.service.impl.SensitiveWordServiceImpl;
import com.youguu.core.logging.Log;
import com.youguu.core.logging.LogFactory;
import com.youguu.core.util.PageHolder;
import com.youguu.core.util.ParamUtil;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.nio.ByteBuffer;
import java.util.Set;

/**
 * 
 * @ClassName: WordThriftRpcServiceImpl
 * @Description: 敏感词rpc server端service实现
 * @author zhanglei
 * @date 2014年11月6日 上午10:40:27
 *
 */
@Service("wordThriftRpcService")
public class WordThriftRpcServiceImpl implements Iface {
	
	private static final Log logger = LogFactory.getLog(Constants.ASTEROIDRPC_SERVER);
	
	@Resource
	private SensitiveWordServiceImpl sensitiveWordService;

	@Resource
	private IConvertService convertService;

	/**
	 * 添加敏感词
	 */
	@Override
	public int addSensitiveWord(String words) throws TException {
		try {
			return sensitiveWordService.addSensitiveWord(words);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return 0;
		}
	}

	/**
	 * 修改敏感词
	 */
	@Override
	public int updateSensitiveWord(SensitiveWordThrift word) throws TException {
		try {
			SensitiveWord sw = ClassCast.thriftToPojo(word);
			return sensitiveWordService.updateSensitiveWord(sw);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return 0;
		}
	}

	/**
	 * 删除敏感词
	 */
	@Override
	public int deleteSensitiveWord(int id) throws TException {
		try {
			return sensitiveWordService.deleteSensitiveWord(id);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return 0;
		}
	}

	/**
	 * 获取敏感词
	 */
	@Override
	public SensitiveWordThrift getSensitiveWord(int id) throws TException {
		SensitiveWord sw = sensitiveWordService.getSensitiveWord(id);
		SensitiveWordThrift swt = ClassCast.pojoToThrift(sw);
		return swt;
	}

	/**
	 * 查询敏感词
	 */
	@Override
	public ByteBuffer querySensitiveWordList(String word, int pageIndex,
			int pageSize) throws TException {
		PageHolder<SensitiveWord> pageHolder = sensitiveWordService.querySensitiveWordList(word, pageIndex, pageSize);
		return ParamUtil.getFromByte(pageHolder);
	}

	/**
	 * 判断文本是否包含敏感词
	 */
	@Override
	public boolean isContainSensitiveWord(String text) throws TException {
		return sensitiveWordService.isContainSensitiveWord(text);
	}

	/**
	 * 重载敏感词库
	 */
	@Override
	public boolean refreshSensitiveWord() throws TException {
		try {
			sensitiveWordService.refreshSensitiveWord();
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return false;
	}

	@Override
	public ByteBuffer getMatchedWords(String text) throws TException {
		try {
			Set<String> set = this.sensitiveWordService.getMatchedWords(text);
			return ParamUtil.getFromByte(set);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

	@Override
	public String getStringByImg(ByteBuffer img) throws TException {
		try {
			byte[] bytes = new byte[img.remaining()];
			img.get(bytes, 0, bytes.length);
			return this.convertService.getStringByImg(bytes);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}

}
