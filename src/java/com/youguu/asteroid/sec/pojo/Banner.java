package com.youguu.asteroid.sec.pojo;

import java.io.Serializable;
/**
 * 
* @ClassName: Banner 
* @Description: TODO（广告类) 
* @author zhangkai
* @date 2015年5月27日 下午5:25:29 
*
 */
public class Banner implements Serializable {
	private String img;
	private String url;
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	

}
