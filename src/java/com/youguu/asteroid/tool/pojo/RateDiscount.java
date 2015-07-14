package com.youguu.asteroid.tool.pojo;

import java.io.Serializable;

public class RateDiscount implements Serializable{

	private int id;
	private String discountLevel;
	private int rank;
	private double value;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDiscountLevel() {
		return discountLevel;
	}

	public void setDiscountLevel(String discountLevel) {
		this.discountLevel = discountLevel;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

}
