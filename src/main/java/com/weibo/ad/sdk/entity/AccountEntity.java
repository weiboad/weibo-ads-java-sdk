package com.weibo.ad.sdk.entity;


import com.alibaba.fastjson.annotation.JSONField;

public class AccountEntity
{


    private Integer id;

    @JSONField(name = "enrich_type")
    private Integer enrichType;

    @JSONField(name = "customer_id")
    private Long customerId;

    private String name;

    @JSONField(name = "spend_cap")
    private Float spendCap;

    @JSONField(name = "reverse_spend_cap")
    private Float reverseSpendCap;

    @JSONField(name = "configured_status")
    private Integer configuredStatus;

    @JSONField(name = "effective_status")
    private Integer effectiveStatus;

    @JSONField(name = "disable_reason")
    private String disableReason;

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

    public Integer getEnrichType() {
        return enrichType;
    }

    public void setEnrichType(Integer enrichType) {
        this.enrichType = enrichType;
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

    public Float getSpendCap() {
        return spendCap;
    }

    public void setSpendCap(Float spendCap) {
        this.spendCap = spendCap;
    }

    public Float getReverseSpendCap() {
        return reverseSpendCap;
    }

    public void setReverseSpendCap(Float reverseSpendCap) {
        this.reverseSpendCap = reverseSpendCap;
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

    public String getDisableReason() {
        return disableReason;
    }

    public void setDisableReason(String disableReason) {
        this.disableReason = disableReason;
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
