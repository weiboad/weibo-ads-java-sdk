package com.weibo.ad.sdk.entity;


import com.alibaba.fastjson.annotation.JSONField;
import java.util.ArrayList;

public class ADsEntity extends AbstractEntity
{

    private Integer id;

    @JSONField(name = "bid_amount")
    private Float bidAmount;

    @JSONField(name = "billing_type")
    private Integer billingType;

    @JSONField(name = "campaign_id")
    private Integer campaignId;

    private CampaignEntity campaign;

    @JSONField(name = "configured_status")
    private Integer configuredStatus;

    @JSONField(name = "effective_status")
    private Integer effectiveStatus;

    private ArrayList<CreativeEntity> creative;

    @JSONField(name = "customer_id")
    private Long customerId;

    @JSONField(name = "daily_budget")
    private Float dailyBudget;

    private ArrayList<ADScheduleEntity> deliverySchedule;

    @JSONField(name = "delivery_speed")
    private Integer deliverySpeed;

    @JSONField(name = "delivery_type")
    private Integer deliveryType;

    @JSONField(name = "guaranteed_delivery")
    private Integer guaranteedDelivery;

    @JSONField(name = "is_autobid")
    private Integer isAutobid;

    private String  name;

    private Integer objective;

    @JSONField(name = "optimization_goal")
    private Integer optimizationGoal;

    @JSONField(name = "reverse_daily_budget")
    private Float reverseDailyBudget;

    private TargetingEntity targeting;

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

    public Float getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(Float bidAmount) {
        this.bidAmount = bidAmount;
    }

    public Integer getBillingType() {
        return billingType;
    }

    public void setBillingType(Integer billingType) {
        this.billingType = billingType;
    }

    public Integer getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Integer campaignId) {
        this.campaignId = campaignId;
    }

    public CampaignEntity getCampaign() {
        return campaign;
    }

    public void setCampaign(CampaignEntity campaign) {
        this.campaign = campaign;
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

    public ArrayList<CreativeEntity> getCreative() {
        return creative;
    }

    public void setCreative(ArrayList<CreativeEntity> creative) {
        this.creative = creative;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Float getDailyBudget() {
        return dailyBudget;
    }

    public void setDailyBudget(Float dailyBudget) {
        this.dailyBudget = dailyBudget;
    }

    public ArrayList<ADScheduleEntity> getDeliverySchedule() {
        return deliverySchedule;
    }

    public void setDeliverySchedule(ArrayList<ADScheduleEntity> deliverySchedule) {
        this.deliverySchedule = deliverySchedule;
    }

    public Integer getDeliverySpeed() {
        return deliverySpeed;
    }

    public void setDeliverySpeed(Integer deliverySpeed) {
        this.deliverySpeed = deliverySpeed;
    }

    public Integer getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(Integer deliveryType) {
        this.deliveryType = deliveryType;
    }

    public Integer getGuaranteedDelivery() {
        return guaranteedDelivery;
    }

    public void setGuaranteedDelivery(Integer guaranteedDelivery) {
        this.guaranteedDelivery = guaranteedDelivery;
    }

    public Integer getIsAutobid() {
        return isAutobid;
    }

    public void setIsAutobid(Integer isAutobid) {
        this.isAutobid = isAutobid;
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

    public Integer getOptimizationGoal() {
        return optimizationGoal;
    }

    public void setOptimizationGoal(Integer optimizationGoal) {
        this.optimizationGoal = optimizationGoal;
    }

    public Float getReverseDailyBudget() {
        return reverseDailyBudget;
    }

    public void setReverseDailyBudget(Float reverseDailyBudget) {
        this.reverseDailyBudget = reverseDailyBudget;
    }

    public TargetingEntity getTargeting() {
        return targeting;
    }

    public void setTargeting(TargetingEntity targeting) {
        this.targeting = targeting;
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
