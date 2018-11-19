package com.weibo.ad.sdk.entity;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Package: com.weibo.ad.sdk.entity
 *
 * @Author: yongqiang7@weibo.com
 * @Date: Creatd at 2018/2/6 下午5:55
 */
public class AdInfoEntity
{
    @JSONField(name = "ad_id")
    private int adId;

    @JSONField(name = "ad_name")
    private String adName;

    @JSONField(name = "campaign_id")
    private int campaignId;

    @JSONField(name = "campaign_name")
    private String campaignName;

    @JSONField(name = "guaranteed_delivery")
    private int guaranteedDelivery;

    private int objective;

    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public int getGuaranteedDelivery() {
        return guaranteedDelivery;
    }

    public void setGuaranteedDelivery(int guaranteedDelivery) {
        this.guaranteedDelivery = guaranteedDelivery;
    }

    public int getObjective() {
        return objective;
    }

    public void setObjective(int objective) {
        this.objective = objective;
    }
}
