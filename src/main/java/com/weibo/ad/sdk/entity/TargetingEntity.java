package com.weibo.ad.sdk.entity;


import com.alibaba.fastjson.annotation.JSONField;
import java.util.ArrayList;
import java.util.Collection;

public class TargetingEntity
{

    private Integer id;

    private String name;

    private ArrayList<String> $accurateInterests;

    @JSONField(name = "ad_id")
    private Integer adId;

    @JSONField(name = "customer_id")
    private Long customerId;

    @JSONField(name = "age_max")
    private Integer ageMax;

    @JSONField(name = "age_min")
    private Integer ageMin;

    @JSONField(name = "audience_id")
    private Integer audienceId;

    @JSONField(name = "audience_type")
    private Integer audienceType;

    private BehaviorEntity behaviors;

    @JSONField(name = "category_interests")
    private ArrayList<Integer> categoryInterests;

    private Integer genders;

    @JSONField(name = "geo_locations")
    private ArrayList<Integer> geoLocations;

    @JSONField(name = "is_template")
    private Integer isTemplate;

    @JSONField(name = "login_frequency")
    private ArrayList<Integer> loginFrequency;

    @JSONField(name = "social_connections")
    private ArrayList<SocialConnectionEntity> socialConnections;

    @JSONField(name = "user_device")
    private ArrayList<Integer> userDevice;

    @JSONField(name = "user_network")
    private ArrayList<Integer> userNetwork;

    @JSONField(name = "user_os")
    private ArrayList<Integer> userOs;

    @JSONField(name = "user_os_version")
    private Integer userOsVersion;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> get$accurateInterests() {
        return $accurateInterests;
    }

    public void set$accurateInterests(ArrayList<String> $accurateInterests) {
        this.$accurateInterests = $accurateInterests;
    }

    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Integer getAgeMax() {
        return ageMax;
    }

    public void setAgeMax(Integer ageMax) {
        this.ageMax = ageMax;
    }

    public Integer getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(Integer ageMin) {
        this.ageMin = ageMin;
    }

    public Integer getAudienceId() {
        return audienceId;
    }

    public void setAudienceId(Integer audienceId) {
        this.audienceId = audienceId;
    }

    public Integer getAudienceType() {
        return audienceType;
    }

    public void setAudienceType(Integer audienceType) {
        this.audienceType = audienceType;
    }

    public BehaviorEntity getBehaviors() {
        return behaviors;
    }

    public void setBehaviors(BehaviorEntity behaviors) {
        this.behaviors = behaviors;
    }

    public ArrayList<Integer> getCategoryInterests() {
        return categoryInterests;
    }

    public void setCategoryInterests(ArrayList<Integer> categoryInterests) {
        this.categoryInterests = categoryInterests;
    }

    public Integer getGenders() {
        return genders;
    }

    public void setGenders(Integer genders) {
        this.genders = genders;
    }

    public ArrayList<Integer> getGeoLocations() {
        return geoLocations;
    }

    public void setGeoLocations(ArrayList<Integer> geoLocations) {
        this.geoLocations = geoLocations;
    }

    public Integer getIsTemplate() {
        return isTemplate;
    }

    public void setIsTemplate(Integer isTemplate) {
        this.isTemplate = isTemplate;
    }

    public ArrayList<Integer> getLoginFrequency() {
        return loginFrequency;
    }

    public void setLoginFrequency(ArrayList<Integer> loginFrequency) {
        this.loginFrequency = loginFrequency;
    }

    public ArrayList<SocialConnectionEntity> getSocialConnections() {
        return socialConnections;
    }

    public void setSocialConnections(ArrayList<SocialConnectionEntity> socialConnections) {
        this.socialConnections = socialConnections;
    }

    public ArrayList<Integer> getUserDevice() {
        return userDevice;
    }

    public void setUserDevice(ArrayList<Integer> userDevice) {
        this.userDevice = userDevice;
    }

    public ArrayList<Integer> getUserNetwork() {
        return userNetwork;
    }

    public void setUserNetwork(ArrayList<Integer> userNetwork) {
        this.userNetwork = userNetwork;
    }

    public ArrayList<Integer> getUserOs() {
        return userOs;
    }

    public void setUserOs(ArrayList<Integer> userOs) {
        this.userOs = userOs;
    }

    public Integer getUserOsVersion() {
        return userOsVersion;
    }

    public void setUserOsVersion(Integer userOsVersion) {
        this.userOsVersion = userOsVersion;
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
