package com.sermo.xx.model;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

public class AdRule {
	
	/**
	 * ID
	 */
	private @Id String id;
	
	/**
	 * 广告主 id
	 */
	private String advertiserId;
	
	/**
	 * 广告主名称
	 */
	private String advertiserName;
	
	/**
	 * 广告 id
	 */
	private String adsId;
	
	
	/**
	 * 广告名称
	 */
	private String adsName;
	
	/**
	 * 渠道 id
	 */
	private String channelId;
	
	/**
	 * 渠道名称
	 */
	private String channelName;
	
	/**
	 * 类型
	 */
	private String settle;
	
	/**
	 * 单价/充值金额
	 */
	private double price;
	
	/**
	 * 优化比例
	 */
	private String optimalRatio;
	
	/**
	 * 开始时间 -
	 */
	@DateTimeFormat( pattern = "yyyy-MM-dd HH:mm" )
	private Date createTime; 
 
	/**
	 * 结束时间 -
	 */
	@DateTimeFormat( pattern = "yyyy-MM-dd" )
	private Date effectiveTime;
	
	/**
	 * 状态  0-创建 1-生效  2-禁用  
	 */
	private String status;

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAdvertiserId() {
		return advertiserId;
	}

	public void setAdvertiserId(String advertiserId) {
		this.advertiserId = advertiserId;
	}
	

	public String getAdsId() {
		return adsId;
	}

	public void setAdsId(String adsId) {
		this.adsId = adsId;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getOptimalRatio() {
		return optimalRatio;
	}

	public void setOptimalRatio(String optimalRatio) {
		this.optimalRatio = optimalRatio;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getEffectiveTime() {
		return effectiveTime;
	}

	public void setEffectiveTime(Date effectiveTime) {
		this.effectiveTime = effectiveTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAdvertiserName() {
		return advertiserName;
	}

	public void setAdvertiserName(String advertiserName) {
		this.advertiserName = advertiserName;
	}

	public String getAdsName() {
		return adsName;
	}

	public void setAdsName(String adsName) {
		this.adsName = adsName;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getSettle() {
		return settle;
	}

	public void setSettle(String settle) {
		this.settle = settle;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "AdRule [id=" + id + ", advertiserId=" + advertiserId + ", advertiserName=" + advertiserName + ", adsId="
				+ adsId + ", adsName=" + adsName + ", channelId=" + channelId + ", channelName=" + channelName
				+ ", settle=" + settle + ", price=" + price + ", optimalRatio=" + optimalRatio + ", createTime="
				+ createTime + ", effectiveTime=" + effectiveTime + ", status=" + status + "]";
	}

}
