package com.weibo.ad.sdk.entity;


import com.alibaba.fastjson.annotation.JSONField;

public class CampaignEntity extends AbstractEntity
{
    private Integer id;

    @JSONField(name = "customer_id")
    private Long customerId;

    private String name;

    private Integer objective;

    @JSONField(name = "app_id")
    private Integer appId;

    @JSONField(name = "app_type")
    private Integer appType;

    @JSONField(name = "lifetime_budget")
    private Float lifetimeBudget;

    @JSONField(name = "guaranteed_delivery")
    private Integer guaranteedDelivery;

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

    public Integer getObjective() {
        return objective;
    }

    public void setObjective(Integer objective) {
        this.objective = objective;
    }

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

    public Float getLifetimeBudget() {
        return lifetimeBudget;
    }

    public void setLifetimeBudget(Float lifetimeBudget) {
        this.lifetimeBudget = lifetimeBudget;
    }

    public Integer getGuaranteedDelivery() {
        return guaranteedDelivery;
    }

    public void setGuaranteedDelivery(Integer guaranteedDelivery) {
        this.guaranteedDelivery = guaranteedDelivery;
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
