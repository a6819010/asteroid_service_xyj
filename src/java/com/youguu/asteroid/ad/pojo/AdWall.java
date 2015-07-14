package com.youguu.asteroid.ad.pojo;

import java.util.Date;

/**
 * @ClassName: AdWall
 * @Description: 模拟炒股广告墙
 * @author shilei
 * @date 2014年6月11日 下午2:41:27
 *
 */
public class AdWall {

	private int id;				//广告ID
	private String title;		//广告标题
	private String forwardUrl;	//点击广告跳转链接
	private Date beginDate;		//投放开始日期
	private Date endDate;		//投放结束日期
	private String adImage;		//广告图
	private String positionType;//广告位置类型。2401:banner,2402:弹窗
	private String contentType;	//广告内容类型。2501:图片，2502:文字
	private String content;		//广告文字内容
	private Date createTime;	//创建时间
	private int rank;			//排序
	
	/**
	 * 广告类型
	 */
	public static final String WALL = "2401";
	
	public static final String POP = "2402";
	
	public static final String LOADING = "2403";
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getForwardUrl() {
		return forwardUrl;
	}

	public void setForwardUrl(String forwardUrl) {
		this.forwardUrl = forwardUrl;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getAdImage() {
		return adImage;
	}

	public void setAdImage(String adImage) {
		this.adImage = adImage;
	}

	public String getPositionType() {
		return positionType;
	}

	public void setPositionType(String positionType) {
		this.positionType = positionType;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "AdWall [id=" + id + ", title=" + title + ", forwardUrl="
				+ forwardUrl + ", beginDate=" + beginDate + ", endDate="
				+ endDate + ", adImage=" + adImage + ", positionType="
				+ positionType + ", contentType=" + contentType + ", content="
				+ content + ", createTime=" + createTime + ", rank=" + rank
				+ "]";
	}

}
