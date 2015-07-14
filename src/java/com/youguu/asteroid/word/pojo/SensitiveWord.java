package com.youguu.asteroid.word.pojo;

import java.io.Serializable;
import java.util.Date;

public class SensitiveWord implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String word;
	private Date createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "SensitiveWord [id=" + id + ", word=" + word + ", createTime="
				+ createTime + "]";
	}

}
