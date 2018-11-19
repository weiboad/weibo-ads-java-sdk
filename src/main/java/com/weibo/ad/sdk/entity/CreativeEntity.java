package com.weibo.ad.sdk.entity;


import com.alibaba.fastjson.annotation.JSONField;

public class CreativeEntity extends AbstractEntity
{
    private Integer id;

    private String weibo;

    @JSONField(name = "customer_id")
    private Long customerId;

    private String name;

    @JSONField(name = "ad_id")
    private Integer adId;

    @JSONField(name = "ad_style")
    private Integer adStyle;

    private String feed;

    @JSONField(name = "ad_info")
    private AdInfoEntity adInfo;

    @JSONField(name = "creative_type")
    private Integer creativeType;

    @JSONField(name = "app_id")
    private Integer appId;

    @JSONField(name = "feed_source")
    private Integer feedSource;

    @JSONField(name = "feed_style")
    private Integer feedStyle;

    @JSONField(name = "publish_type")
    private Integer publishType;

    @JSONField(name = "publish_date_time")
    private String publishDatetime;

    @JSONField(name = "feed_license_id")
    private Integer feedLicenseId;

    @JSONField(name = "monitor_type")
    private Integer monitorType;

    private String monitor;

    private String reason;

    @JSONField(name = "is_recycled")
    private Integer isRecycled;

    @JSONField(name = "recycle_datetime")
    private String recycleDatetime;

    @JSONField(name = "configured_status")
    private Integer configuredStatus;

    @JSONField(name = "effective_status")
    private Integer effectiveStatus;

    @JSONField(name = "created_at")
    private String createdAt;

    @JSONField(name = "updated_at")
    private String updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public Integer getAdStyle() {
        return adStyle;
    }

    public void setAdStyle(Integer adStyle) {
        this.adStyle = adStyle;
    }

    public String getFeed() {
        return feed;
    }

    public void setFeed(String feed) {
        this.feed = feed;
    }

    public Integer getCreativeType() {
        return creativeType;
    }

    public void setCreativeType(Integer creativeType) {
        this.creativeType = creativeType;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public Integer getFeedSource() {
        return feedSource;
    }

    public void setFeedSource(Integer feedSource) {
        this.feedSource = feedSource;
    }

    public Integer getFeedStyle() {
        return feedStyle;
    }

    public void setFeedStyle(Integer feedStyle) {
        this.feedStyle = feedStyle;
    }

    public Integer getPublishType() {
        return publishType;
    }

    public void setPublishType(Integer publishType) {
        this.publishType = publishType;
    }

    public String getPublishDatetime() {
        return publishDatetime;
    }

    public void setPublishDatetime(String publishDatetime) {
        this.publishDatetime = publishDatetime;
    }

    public Integer getFeedLicenseId() {
        return feedLicenseId;
    }

    public void setFeedLicenseId(Integer feedLicenseId) {
        this.feedLicenseId = feedLicenseId;
    }

    public Integer getMonitorType() {
        return monitorType;
    }

    public void setMonitorType(Integer monitorType) {
        this.monitorType = monitorType;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getIsRecycled() {
        return isRecycled;
    }

    public void setIsRecycled(Integer isRecycled) {
        this.isRecycled = isRecycled;
    }

    public String getRecycleDatetime() {
        return recycleDatetime;
    }

    public void setRecycleDatetime(String recycleDatetime) {
        this.recycleDatetime = recycleDatetime;
    }

    public Integer getConfiguredStatus() {
        return configuredStatus;
    }

    public void setConfiguredStatus(Integer configuredStatus) {
        this.configuredStatus = configuredStatus;
    }

    public Integer getEffectiveStatus() {
        return effectiveStatus;
    }

    public void setEffectiveStatus(Integer effectiveStatus) {
        this.effectiveStatus = effectiveStatus;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public AdInfoEntity getAdInfo() {
        return adInfo;
    }

    public void setAdInfo(AdInfoEntity adInfo) {
        this.adInfo = adInfo;
    }

    public String getWeibo() {
        return weibo;
    }

    public void setWeibo(String weibo) {
        this.weibo = weibo;
    }
}
