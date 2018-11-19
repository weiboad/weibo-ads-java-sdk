package com.weibo.ad.sdk.api;


import com.alibaba.fastjson.JSON;
import com.weibo.ad.sdk.Api;
import com.weibo.ad.sdk.entity.AccountEntity;
import com.weibo.ad.sdk.entity.AssetEntity;
import com.weibo.ad.sdk.exception.ApiException;
import com.weibo.ad.sdk.model.AgentCustomerModel;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AccountApi extends AbstractApi
{
    private static final String URI_READING = "/account";
    private static final String URI_AGENT_CUSTOMER =
            "/account/agent-customers?page=%s&page_size=%s&customer_name=%s&uid=%d";
    private static final String URI_ASSET = "/account/asset";
    private static final String URI_BUDGET = "/account/budget";

    public AccountApi(Api api) {
        super(api);
    }

    public AccountEntity read() throws ApiException,IOException {
        String data = api.getApiRequest().call(URI_READING);
        return JSON.parseObject(data, AccountEntity.class);
    }

    public AgentCustomerModel getAgentCustomers(int page, int pageSize, String customerName, long uid) throws
            ApiException,IOException {
        String data = api.getApiRequest().call(String.format(URI_AGENT_CUSTOMER, page, pageSize, customerName, uid));
        return JSON.parseObject(data, AgentCustomerModel.class);
    }

    public AssetEntity getAsset() throws  ApiException,IOException {
        String data = api.getApiRequest().call(URI_ASSET);
        return JSON.parseObject(data, AssetEntity.class);
    }

    public AccountEntity updateBudget(float spendCap) throws  ApiException,IOException {
        Map<String, String> params = new HashMap<>();
        params.put("spend_cap", String.valueOf(spendCap));
        String data = api.getApiRequest().call(URI_BUDGET, "PUT", params);
        return JSON.parseObject(data, AccountEntity.class);
    }


}
