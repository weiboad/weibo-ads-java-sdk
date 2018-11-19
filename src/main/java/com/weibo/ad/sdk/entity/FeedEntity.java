package com.weibo.ad.sdk.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class FeedEntity extends AbstractEntity
{

    private Long id;

    private Long mid;

    @JSONField(name = "customer_id")
    private Long customerId;

    private String body;

    private String image;

    @JSONField(name = "publish_date")
    private String publishDate;

    @JSONField(name = "object_id")
    private String objectId;

    @JSONField(name = "short_url")
    private String shortUrl;

    private String object;

    @JSONField(name = "ad_only")
    private Integer adOnly;

    @JSONField(name = "comment_open")
    private Integer commentOpen;

    @JSONField(name = "configured_status")
    private Integer configuredStatus;

    @JSONField(name = "effective_status")
    private Integer effectiveStatus;

    @JSONField(name = "created_at")
    private String createdAt;

    @JSONField(name = "updated_at")
    private String updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Integer getAdOnly() {
        return adOnly;
    }

    public void setAdOnly(Integer adOnly) {
        this.adOnly = adOnly;
    }

    public Integer getCommentOpen() {
        return commentOpen;
    }

    public void setCommentOpen(Integer commentOpen) {
        this.commentOpen = commentOpen;
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
}
