package test.rpc;

import com.youguu.asteroid.rpc.client.AsteroidRPCClientFactory;
import com.youguu.asteroid.rpc.client.word.ISensitiveWordRPCService;
import com.youguu.asteroid.word.pojo.SensitiveWord;
import com.youguu.core.util.PageHolder;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.fail;

public class SensitiveWordRPCServiceTest {
	
	private ISensitiveWordRPCService service;
	
	@Before
	public void init(){
		service = AsteroidRPCClientFactory.getSensitiveWordRPCService();
	}

	@Test
	public void testAddSensitiveWord() {
		int i = service.addSensitiveWord("吹风");
		System.out.println(i);
	}

	@Test
	public void testUpdateSensitiveWord() {
		
		SensitiveWord word = new SensitiveWord();
		word.setId(10);
		word.setWord("林肯法球");
		word.setCreateTime(new Date());
		service.updateSensitiveWord(word );
	}

	@Test
	public void testDeleteSensitiveWord() {
		service.deleteSensitiveWord(128156);
	}

	@Test
	public void testGetSensitiveWord() {
		SensitiveWord sensitiveWord = service.getSensitiveWord(5);
		System.out.println(sensitiveWord);
	}

	@Test
	public void testGetTotalCount() {
		fail("Not yet implemented");
	}

	@Test
	public void testQuerySensitiveWordList() {
		PageHolder<SensitiveWord> ph = service.querySensitiveWordList("", 1, 5);
		for(SensitiveWord sw : ph){
			System.out.println(sw);
		}
	}
	
	@Test
	public void testIsContainSensitiveWord(){
		boolean r = service.isContainSensitiveWord("水森叶月");
		System.out.println(r);
	}
	
	@Test
	public void testRefreshSensitiveWord(){
		boolean r = service.refreshSensitiveWord();
		System.out.println(r);
	}
	
	@Test
	public void testGetMatchedWords(){
		Set<String> set = this.service.getMatchedWords("阿打发卡了啊啊啊阿斯顿发了法轮功阿斯蒂芬顺义阿斯蒂芬大大大");
		for (String string : set) {
			System.out.println(string);
		}
	}

	@Test
	public void testGetStringByImg() throws IOException {
		File file = new File("d:/1.jpg");
		FileInputStream inputFile = new FileInputStream(file);
		byte[] buffer = new byte[(int) file.length()];
		inputFile.read(buffer);
		inputFile.close();
		String stringByImg = this.service.getStringByImg(buffer);
		System.out.println(stringByImg);
	}

}
