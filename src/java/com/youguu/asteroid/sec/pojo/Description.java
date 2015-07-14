package com.youguu.asteroid.sec.pojo;

import java.io.Serializable;

/**
 * 
* @ClassName: Description 
* @Description: TODO(证券公司描述类) 
* @author zhangkai 
* @date 2015年5月28日 上午9:56:27 
*
 */
public class Description implements Serializable{
	private String title;
	private String content;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	

}
