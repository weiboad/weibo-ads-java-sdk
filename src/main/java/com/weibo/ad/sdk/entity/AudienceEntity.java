package com.weibo.ad.sdk.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class AudienceEntity extends AbstractEntity
{
    private Integer id;

    @JSONField(name = "audiences_size")
    private Integer audiencesSize;

    @JSONField(name = "audiences_type")
    private Integer audiencesType;

    @JSONField(name = "customer_id")
    private Long customerId;

    @JSONField(name = "data_format")
    private Integer dataFormat;

    @JSONField(name = "data_source")
    private Integer dataSource;

    @JSONField(name = "dig_source_id")
    private Integer digSourceId;

    @JSONField(name = "is_delete_enable")
    private Integer isDeleteEnable;

    @JSONField(name = "is_dug")
    private Integer isDug;

    @JSONField(name = "is_using")
    private Integer isUsing;

    @JSONField(name = "look_alike_id")
    private Integer lookAlikeId;

    private String name;

    private String reason;

    private String summary;

    @JSONField(name = "configured_status")
    private Integer configuredStatus;

    @JSONField(name = "effective_status")
    private Integer effectiveStatus;

    @JSONField(name = "created_at")
    private String createdAt;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAudiencesSize() {
        return audiencesSize;
    }

    public void setAudiencesSize(Integer audiencesSize) {
        this.audiencesSize = audiencesSize;
    }

    public Integer getAudiencesType() {
        return audiencesType;
    }

    public void setAudiencesType(Integer audiencesType) {
        this.audiencesType = audiencesType;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Integer getDataFormat() {
        return dataFormat;
    }

    public void setDataFormat(Integer dataFormat) {
        this.dataFormat = dataFormat;
    }

    public Integer getDataSource() {
        return dataSource;
    }

    public void setDataSource(Integer dataSource) {
        this.dataSource = dataSource;
    }

    public Integer getDigSourceId() {
        return digSourceId;
    }

    public void setDigSourceId(Integer digSourceId) {
        this.digSourceId = digSourceId;
    }

    public Integer getIsDeleteEnable() {
        return isDeleteEnable;
    }

    public void setIsDeleteEnable(Integer isDeleteEnable) {
        this.isDeleteEnable = isDeleteEnable;
    }

    public Integer getIsDug() {
        return isDug;
    }

    public void setIsDug(Integer isDug) {
        this.isDug = isDug;
    }

    public Integer getIsUsing() {
        return isUsing;
    }

    public void setIsUsing(Integer isUsing) {
        this.isUsing = isUsing;
    }

    public Integer getLookAlikeId() {
        return lookAlikeId;
    }

    public void setLookAlikeId(Integer lookAlikeId) {
        this.lookAlikeId = lookAlikeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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
}
