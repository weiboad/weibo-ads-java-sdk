package com.weibo.ad.sdk.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class TopicEntity
{
    private String id;

    private String follow;

    private String topicName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFollow() {
        return follow;
    }

    public void setFollow(String follow) {
        this.follow = follow;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }
}
