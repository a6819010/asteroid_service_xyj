package com.youguu.asteroid.tool.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: TaxBase
 * @Description: 工资纳税起征基数
 * @author shilei
 * @date 2014年11月26日 上午9:39:59
 *
 */
public class TaxBase implements Serializable{

	private int id;
	private int taxBase;
	private Date createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTaxBase() {
		return taxBase;
	}

	public void setTaxBase(int taxBase) {
		this.taxBase = taxBase;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
