package com.youguu.asteroid.word.service;

import java.util.Set;

import com.youguu.asteroid.word.pojo.SensitiveWord;
import com.youguu.core.util.PageHolder;
/**
 * 
 * @ClassName: ISensitiveWordService
 * @Description: 敏感词service借口
 * @author zhanglei
 * @date 2014年11月11日 下午2:27:10
 *
 */
public interface ISensitiveWordService {

	/**
	* @Title: addSensitiveWord
	* @Description: 添加敏感词
	* @param words 多敏感词时逗号分隔
	* @return int    返回类型
	* @throws
	 */
	int addSensitiveWord(String words);
	/**
	 * 
	* @Title: updateSensitiveWord
	* @Description: 更新敏感词
	* @param  word
	* @return int    返回类型
	* @throws
	 */
	int updateSensitiveWord(SensitiveWord word);
	/**
	 * 
	* @Title: deleteSensitiveWord
	* @Description: 删除敏感词
	* @param id
	* @return int    返回类型
	* @throws
	 */
	int deleteSensitiveWord(int id);
	/**
	 * 
	* @Title: getSensitiveWord
	* @Description: 获取敏感词
	* @param  id
	* @return SensitiveWord    返回类型
	* @throws
	 */
	SensitiveWord getSensitiveWord(int id);
	/**
	 * 
	* @Title: getTotalCount
	* @Description: 获取敏感词总记录数
	* @return int    返回类型
	* @throws
	 */
	int getTotalCount();
	/**
	 * 
	* @Title: querySensitiveWordList
	* @Description: 分页查询敏感词
	* @param word
	* @param pageIndex
	* @param pageSize
	* @return PageHolder<SensitiveWord>    返回类型
	* @throws
	 */
	PageHolder<SensitiveWord> querySensitiveWordList(String word, int pageIndex, int pageSize);
	

	/**
	 * 
	* @Title: isContainSensitiveWord
	* @Description: 判断文本是否含有敏感词
	* @param @param text
	* @param @return    
	* @return boolean    返回类型
	* @throws
	 */
	boolean isContainSensitiveWord(String text);
	/**
	 * 
	* @Title: refreshSensitiveWord
	* @Description: 刷新敏感词缓存
	* @param @return    
	* @return void    返回类型
	* @throws
	 */
	void refreshSensitiveWord();
	/**
	 * 
	* @Title: getMatchedWords
	* @Description: 获取文本中的敏感词
	* @param text
	* @return    
	* List<String>    返回类型
	* @throws
	 */
	Set<String> getMatchedWords(String text);
}
