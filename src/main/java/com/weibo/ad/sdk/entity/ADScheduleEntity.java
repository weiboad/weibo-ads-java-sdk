package com.weibo.ad.sdk.entity;


import com.alibaba.fastjson.annotation.JSONField;

public class ADScheduleEntity extends AbstractEntity
{
    @JSONField(name = "ad_id")
    private Integer adId;

    @JSONField(name = "start_time")
    private String startTime;

    @JSONField(name = "stop_time")
    private String stopTime;

    @JSONField(name = "daily_start_time")
    private Integer dailyStartTime;

    @JSONField(name = "daily_stop_time")
    private Integer dailyStopTime;

    private Integer impression;

    private Float money;

    @JSONField(name = "configured_status")
    private Integer configuredStatus;

    @JSONField(name = "effective_status")
    private Integer effectiveStatus;

    @JSONField(name = "created_at")
    private String createdAt;

    @JSONField(name = "updated_at")
    private String updatedAt;


    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

    public Integer getDailyStartTime() {
        return dailyStartTime;
    }

    public void setDailyStartTime(Integer dailyStartTime) {
        this.dailyStartTime = dailyStartTime;
    }

    public Integer getDailyStopTime() {
        return dailyStopTime;
    }

    public void setDailyStopTime(Integer dailyStopTime) {
        this.dailyStopTime = dailyStopTime;
    }

    public Integer getImpression() {
        return impression;
    }

    public void setImpression(Integer impression) {
        this.impression = impression;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
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
