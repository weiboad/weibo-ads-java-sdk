package com.weibo.ad.sdk.entity;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.ArrayList;

public class BehaviorEntity
{
    @JSONField(name = "topic_interaction")
    private ArrayList<TopicEntity> topicInteraction;

    @JSONField(name = "feed_interaction")
    private ArrayList<FeedInteractionEntity> feedInteraction;

    @JSONField(name = "life_events")
    private ArrayList<Integer> lifeEvents;

    @JSONField(name = "native_propagation")
    private ArrayList<String> nativePropagation;

    public ArrayList<TopicEntity> getTopicInteraction() {
        return topicInteraction;
    }

    public void setTopicInteraction(ArrayList<TopicEntity> topicInteraction) {
        this.topicInteraction = topicInteraction;
    }

    public ArrayList<FeedInteractionEntity> getFeedInteraction() {
        return feedInteraction;
    }

    public void setFeedInteraction(ArrayList<FeedInteractionEntity> feedInteraction) {
        this.feedInteraction = feedInteraction;
    }

    public ArrayList<Integer> getLifeEvents() {
        return lifeEvents;
    }

    public void setLifeEvents(ArrayList<Integer> lifeEvents) {
        this.lifeEvents = lifeEvents;
    }

    public ArrayList<String> getNativePropagation() {
        return nativePropagation;
    }

    public void setNativePropagation(ArrayList<String> nativePropagation) {
        this.nativePropagation = nativePropagation;
    }
}
