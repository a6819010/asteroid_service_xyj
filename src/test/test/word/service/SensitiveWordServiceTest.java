package test.word.service;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.youguu.asteroid.base.ContextLoader;
import com.youguu.asteroid.word.pojo.SensitiveWord;
import com.youguu.asteroid.word.service.ISensitiveWordService;
import com.youguu.asteroid.word.service.impl.SensitiveWordServiceImpl;
import com.youguu.core.util.PageHolder;

public class SensitiveWordServiceTest {
	
	private ISensitiveWordService service;
	
	@Before
	public void init(){
		ApplicationContext cxt = new AnnotationConfigApplicationContext(ContextLoader.class);
		service = cxt.getBean(SensitiveWordServiceImpl.class);
	}

	@Test
	public void testAddSensitiveWord() {
		int result = service.addSensitiveWord("特瑞公司的反弹");
		System.out.println(result);
	}

	@Test
	public void testUpdateSensitiveWord() {
		SensitiveWord word = new SensitiveWord();
		word.setId(4);
		word.setWord("标准三");
		word.setCreateTime(new Date());
		service.updateSensitiveWord(word);
	}

	@Test
	public void testDeleteSensitiveWord() {
		service.deleteSensitiveWord(128157);
	}

	@Test
	public void testGetSensitiveWord() {
		SensitiveWord word = service.getSensitiveWord(4);
		System.out.println(word);
	}

	@Test
	public void testGetTotalCount() {
		int totalCount = service.getTotalCount();
		System.out.println(totalCount);
	}

	@Test
	public void testQuerySensitiveWordList() {
		PageHolder<SensitiveWord> ph = service.querySensitiveWordList("", 1, 5);
		for(SensitiveWord w : ph){
			System.out.println(w);
		}
	}

	@Test
	public void testFlushFile() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetMatchedWords(){
		Set<String> matchedWords = this.service.getMatchedWords("啊啊TMT大大大考虑敌法诶顺义拉斯蒂芬啊啊啊啊法轮功");
		for (String string : matchedWords) {
			System.out.println(string);
		}
	}
	
	@Test
	public void testIsContainsWords(){
		boolean flag = this.service.isContainSensitiveWord("阿隆索的法律上飞机TMT拉斯老地方");
		System.out.println(flag);
	}

}
