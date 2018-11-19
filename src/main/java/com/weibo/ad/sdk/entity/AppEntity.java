package com.weibo.ad.sdk.entity;


import com.alibaba.fastjson.annotation.JSONField;

public class AppEntity extends AbstractEntity
{

    @JSONField(name = "app_id")
    private Integer appId;

    @JSONField(name = "app_type")
    private Integer appType;

    private Integer status;

    private String description;

    private String name;

    @JSONField(name = "icon_url")
    private String iconUrl;

    @JSONField(name = "version_name")
    private String versionName;

    @JSONField(name = "market_name")
    private String marketName;

    private String category;

    @JSONField(name = "created_time")
    private Long createdTime;

    @JSONField(name = "itunes_url")
    private String itunesUrl;

    @JSONField(name = "itunes_id")
    private String itunesId;

    @JSONField(name = "bundle_id")
    private String bundleId;

    @JSONField(name = "package_name")
    private String  packageName;

    @JSONField(name = "download_count")
    private Integer downloadCount;

    private Integer size;

    private Integer score;

    private Integer likes;

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public Integer getAppType() {
        return appType;
    }

    public void setAppType(Integer appType) {
        this.appType = appType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }

    public String getItunesUrl() {
        return itunesUrl;
    }

    public void setItunesUrl(String itunesUrl) {
        this.itunesUrl = itunesUrl;
    }

    public String getItunesId() {
        return itunesId;
    }

    public void setItunesId(String itunesId) {
        this.itunesId = itunesId;
    }

    public String getBundleId() {
        return bundleId;
    }

    public void setBundleId(String bundleId) {
        this.bundleId = bundleId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Integer getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }
}