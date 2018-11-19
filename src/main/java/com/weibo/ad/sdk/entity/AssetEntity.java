package com.weibo.ad.sdk.entity;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Package: com.weibo.ad.sdk.entity
 *
 * @Author: yongqiang7@weibo.com
 * @Date: Creatd at 2018/1/31 下午8:37
 */
public class AssetEntity extends AbstractEntity
{

    @JSONField(name = "balance")
    private String balance;


    @JSONField(name = "real_time_consume")
    private String realTimeConsume ;

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getRealTimeConsume() {
        return realTimeConsume;
    }

    public void setRealTimeConsume(String realTimeConsume) {
        this.realTimeConsume = realTimeConsume;
    }
}
