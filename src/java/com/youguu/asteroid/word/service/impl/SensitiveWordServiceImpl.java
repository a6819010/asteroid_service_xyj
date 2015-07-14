package com.youguu.asteroid.word.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.youguu.asteroid.util.KeyWordFilter;
import com.youguu.asteroid.word.dao.SensitiveWordDAO;
import com.youguu.asteroid.word.pojo.SensitiveWord;
import com.youguu.asteroid.word.service.ISensitiveWordService;
import com.youguu.core.util.PageHolder;
/**
 * 
 * @ClassName: ISensitiveWordService
 * @Description: 敏感词service借口实现
 * @author zhanglei
 * @date 2014年11月11日 下午2:27:10
 *
 */
@Service("sensitiveWordService")
public class SensitiveWordServiceImpl implements ISensitiveWordService {
	
	private  KeyWordFilter filter = new KeyWordFilter();

	@Resource
	private SensitiveWordDAO sensitiveWordDAO;

	@Override
	public int addSensitiveWord(String words) {
		String[] wordArray = words.split(",");
		List<String> list = new ArrayList<>();
		if(null!=wordArray && wordArray.length>0){
			for(int i = 0 ; i < wordArray.length; i ++){
				list.add(wordArray[i]);
			}
		}
		int result = sensitiveWordDAO.batchInsert(list, "add");
		
		return result;
	}

	@Override
	public int getTotalCount() {
		return sensitiveWordDAO.findUniqueBy("findByParams_count", null);
	}

	@Override
	public int updateSensitiveWord(SensitiveWord word) {
		int result = sensitiveWordDAO.update(word);
		return result;
	}


	@Override
	public int deleteSensitiveWord(int id) {
		int result = sensitiveWordDAO.delete(id);
		
		return result;
	}

	@Override
	public SensitiveWord getSensitiveWord(int id) {
		return sensitiveWordDAO.get(id);
	}

	@Override
	public PageHolder<SensitiveWord> querySensitiveWordList(String word,
			int pageIndex, int pageSize) {
		Map<String, Object> map = new HashMap<>();
		map.put("word",word);
		return sensitiveWordDAO.pagedQuery("findByParams", map, pageIndex, pageSize);
	}
	

	@Override
	public boolean isContainSensitiveWord(String text) {
		return this.filter.isContainKeyWords(text);
	}
	

	@PostConstruct//利用钩子函数使启动rpc服务时加载敏感词
	@Override
	public void refreshSensitiveWord() {
		KeyWordFilter filter_temp = new KeyWordFilter();
		
		
		
		int pageIndex = 1;
		int pageSize = 1000;
		int totalCount = 0;
	
		do{
			PageHolder<SensitiveWord> pageHolder = querySensitiveWordList(null, pageIndex, pageSize);
			totalCount = pageHolder.size();
			List<String> list = new ArrayList<String>();
			for(SensitiveWord sw : pageHolder){
				list.add(sw.getWord().toLowerCase());
			}
			filter_temp.addKeywords(list);
			
			pageIndex ++;
		}while(totalCount>= pageSize);
		
		
		//数据复制
		KeyWordFilter filter_temp2 = filter;
		filter = filter_temp;
		filter_temp2.clearKeywords();
		filter_temp2 = null;
		filter_temp = null;
	}

	@Override
	public Set<String> getMatchedWords(String text) {
		return  this.filter.getTxtKeyWords(text);
	}
}
