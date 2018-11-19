package com.weibo.ad.sdk.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class DesignatedAccountEntity
{
    @JSONField(name = "followers_count")
    private Integer followersCount;

    private Long id;

    private String name;

    private String location;

    @JSONField(name = "profile_image_url")
    private String profileImageUrl;

    public Integer getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }
}
