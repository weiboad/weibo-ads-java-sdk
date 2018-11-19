package com.weibo.ad.sdk.api;


import com.weibo.ad.sdk.Api;

public abstract class AbstractApi
{
    protected Api api;

    public AbstractApi(Api api) {
        this.api = api;
    }

}
