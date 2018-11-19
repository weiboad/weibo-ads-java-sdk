package com.weibo.ad.sdk.entity;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Package: com.weibo.ad.sdk.entity
 *
 * @Author: yongqiang7@weibo.com
 * @Date: Creatd at 2018/1/31 下午4:20
 */
public class AgentCustomerEntity extends AbstractEntity
{
    @JSONField(name = "advertiser_uid")
    private Long advertiserId;

    @JSONField(name = "advertiser_type")
    private int advertiserType;

    @JSONField(name = "advertiser_weibo_nickname")
    private String advertiserWeiboNickname;

    @JSONField(name = "agent_company")

    private String agentCompany;

    public Long getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(Long advertiserId) {
        this.advertiserId = advertiserId;
    }

    public int getAdvertiserType() {
        return advertiserType;
    }

    public void setAdvertiserType(int advertiserType) {
        this.advertiserType = advertiserType;
    }

    public String getAdvertiserWeiboNickname() {
        return advertiserWeiboNickname;
    }

    public void setAdvertiserWeiboNickname(String advertiserWeiboNickname) {
        this.advertiserWeiboNickname = advertiserWeiboNickname;
    }
    public String getAgentCompany() {
        return agentCompany;
    }

    public void setAgentCompany(String agentCompany) {
        this.agentCompany = agentCompany;
    }
}
