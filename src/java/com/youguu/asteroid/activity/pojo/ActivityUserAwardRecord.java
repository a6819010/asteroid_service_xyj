package com.youguu.asteroid.activity.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
* @Title: ActivityUserAwardRecord.java
* @Package com.youguu.asteroid.activity
* @Description: 用户获奖记录
* @author 徐云杰
* @date 2015年3月9日 上午11:42:02
* @version V1.0
 */
public class ActivityUserAwardRecord implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 奖池ID
	 */
	private int poolId;
	
	/**
	 * 用户ID
	 */
	private int userId;
	
	/**
	 * 奖品ID
	 */
	private int prizeId;
	
	/**
	 * 用户昵称
	 */
	private String nickName;
	
	/**
	 * 手机号
	 */
	private String phone;
	
	/**
	 * 发放状态： 0：未兑换  1：未发放  2：已发放
	 */
	private int awardStatus;
	
	/**
	 * 备注
	 */
	private String remark;
	
	/**
	 * 兑换码
	 */
	private String cdkey;
	
	/**
	 * 创建时间
	 */
	private Date ctime;
	
	/**
	 * 修改时间
	 */
	private Date mtime;
	
	/**
	 * 奖品名称
	 */
	private String prizeName;
	
	/**
	 * 创建时间字符串
	 */
	private String ctimeStr;
	
	/**
	 * 修改时间字符串
	 */
	private String mtimeStr;
	
	/**
	 * 头像
	 */
	private String pic;
	
	public ActivityUserAwardRecord() {
	}

	public ActivityUserAwardRecord(int poolId, int userId, int prizeId,
			String nickName, String phone, int awardStatus, String remark,
			String cdkey, Date ctime) {
		this.poolId = poolId;
		this.userId = userId;
		this.prizeId = prizeId;
		this.nickName = nickName;
		this.phone = phone;
		this.awardStatus = awardStatus;
		this.remark = remark;
		this.cdkey = cdkey;
		this.ctime = ctime;
	}

	public int getPoolId() {
		return poolId;
	}

	public void setPoolId(int poolId) {
		this.poolId = poolId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPrizeId() {
		return prizeId;
	}

	public void setPrizeId(int prizeId) {
		this.prizeId = prizeId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAwardStatus() {
		return awardStatus;
	}

	public void setAwardStatus(int awardStatus) {
		this.awardStatus = awardStatus;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCdkey() {
		return cdkey;
	}

	public void setCdkey(String cdkey) {
		this.cdkey = cdkey;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	public Date getMtime() {
		return mtime;
	}

	public void setMtime(Date mtime) {
		this.mtime = mtime;
	}

	public String getPrizeName() {
		return prizeName;
	}

	public void setPrizeName(String prizeName) {
		this.prizeName = prizeName;
	}

	public String getCtimeStr() {
		return ctimeStr;
	}

	public void setCtimeStr(String ctimeStr) {
		this.ctimeStr = ctimeStr;
	}

	public String getMtimeStr() {
		return mtimeStr;
	}

	public void setMtimeStr(String mtimeStr) {
		this.mtimeStr = mtimeStr;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

}
