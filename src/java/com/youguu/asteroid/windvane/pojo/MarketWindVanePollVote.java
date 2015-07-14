package com.youguu.asteroid.windvane.pojo;

import java.io.Serializable;

/**
* @Title: MarketWindVanePollVote.java 
* @Package com.youguu.asteroid.windvane.pojo 
* @Description: 市场风向标投票统计
* @author 徐云杰
* @date 2014年12月1日 上午11:31:06 
* @version V1.0
 */
public class MarketWindVanePollVote implements Serializable {
	
	private static final long serialVersionUID = 1L;

	/**
	 * 投票时间
	 */
	private String date;
	
	/**
	 * 投票总数
	 */
	private int num;
	
	/**
	 * 投涨数
	 */
	private int up;
	
	/**
	 * 投跌数
	 */
	private int down;
	
	/**
	 * 投票结果。1：涨 2：跌
	 */
	private int result;

	public MarketWindVanePollVote() {
	}

	public MarketWindVanePollVote(String date, int num, int up, int down,
			int result) {
		this.date = date;
		this.num = num;
		this.up = up;
		this.down = down;
		this.result = result;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getUp() {
		return up;
	}

	public void setUp(int up) {
		this.up = up;
	}

	public int getDown() {
		return down;
	}

	public void setDown(int down) {
		this.down = down;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
}
