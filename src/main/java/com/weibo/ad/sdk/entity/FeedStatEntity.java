package com.weibo.ad.sdk.entity;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Package: com.weibo.ad.sdk.entity
 *
 * @Author: yongqiang7@weibo.com
 * @Date: Creatd at 2018/2/5 下午1:42
 */
public class FeedStatEntity extends AbstractEntity
{

    private FeedEntity feed;
    private WeiboEntity weibo;

    @JSONField(name = "effective_status")
    private int effectiveStatus;

    public FeedEntity getFeed() {
        return feed;
    }

    public void setFeed(FeedEntity feed) {
        this.feed = feed;
    }

    public int getEffectiveStatus() {
        return effectiveStatus;
    }

    public void setEffectiveStatus(int effectiveStatus) {
        this.effectiveStatus = effectiveStatus;
    }

    public String getAd_rate() {
        return ad_rate;
    }

    public void setAd_rate(String ad_rate) {
        this.ad_rate = ad_rate;
    }

    public int getFeedStyle() {
        return feedStyle;
    }

    public void setFeedStyle(int feedStyle) {
        this.feedStyle = feedStyle;
    }

    public int getAdStyle() {
        return adStyle;
    }

    public void setAdStyle(int adStyle) {
        this.adStyle = adStyle;
    }

    @JSONField(name = "ad_rate")
    private String ad_rate;

    @JSONField(name = "feed_style")
    private int feedStyle;

    @JSONField(name = "ad_style")
    private int adStyle;


    public WeiboEntity getWeibo() {
        return weibo;
    }

    public void setWeibo(WeiboEntity weibo) {
        this.weibo = weibo;
    }
}
