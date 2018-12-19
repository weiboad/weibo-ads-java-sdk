package com.weibo.ad.sdk.api;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.weibo.ad.sdk.Api;
import com.weibo.ad.sdk.entity.CampaignEntity;
import com.weibo.ad.sdk.exception.ApiException;
import com.weibo.ad.sdk.model.CampaignModel;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public class CampaignApi extends AbstractApi
{
    private static final String URI_READING = "/campaigns/%d";
    private static final String URI_LIST    = "/campaigns";
    private static final String URI_CREATE  = "/campaigns";
    private static final String URI_UPDATE  = "/campaigns/%d";
    private static final String URI_DELETE  = "/campaigns/%d";
    private static final String URI_UPDATE_STATUS  = "/campaigns/status/%d";

    public CampaignApi(Api api) {
        super(api);
    }

    public CampaignEntity read(int id) throws ApiException, IOException {
        String data = api.getApiRequest().call(String.format(URI_READING, id));
        return JSON.parseObject(data, CampaignEntity.class);
    }

    public CampaignModel lists(int id, int[] ids, String name, int objective, float lifetimeBudget,
            int guaranteedDelivery, int page, int pageSize) throws   ApiException, IOException{
        String scheme = URI_LIST .concat( "?page=" + page + "&page_size=" + pageSize);
        if (id > 0) {
            scheme +="&id=" + id;
        }
        if (ids != null && ids.length > 0) {
            scheme += "ids=" + ids;
        }
        if (!name.equals("")) {
            scheme +="&name=" + name;
        }
        if (objective > 0) {
            scheme +="&objective=" + objective;
        }
        if (lifetimeBudget >= 0) {
            scheme += "&lifetime_budget=" + lifetimeBudget;
        }
        if (guaranteedDelivery >= 0) {
            scheme += "&guaranteed_delivery=" + guaranteedDelivery;
        }
        String data = api.getApiRequest().call(scheme);
        return JSON.parseObject(data, CampaignModel.class);
    }

    public CampaignEntity create(CampaignEntity campaign) throws  ApiException, IOException, IllegalAccessException {
        if (campaign.getId() != null && campaign.getId() > 0) {
            return update(campaign);
        }
        String data = api.getApiRequest().call(URI_CREATE, "POST", campaign);
        return JSON.parseObject(data, CampaignEntity.class);
    }

    public CampaignModel update(int campaignId, int status) throws  ApiException, IOException {
        Map<String, String> params = new HashMap<>();
        params.put("status", String.valueOf(status));
        String data = api.getApiRequest().call(String.format(URI_UPDATE_STATUS, campaignId), "PUT", params);
        return JSON.parseObject(data, CampaignModel.class);
    }

    public CampaignEntity update(CampaignEntity campaign) throws  ApiException, IOException, IllegalAccessException{
        String data = api.getApiRequest().call(String.format(URI_UPDATE, campaign.getId()), "PUT", campaign);
        return JSON.parseObject(data, CampaignEntity.class);
    }


    public HashMap<String, String> delete(int id) throws  ApiException, IOException {
        String scheme = String.format(URI_DELETE, id);
        String data = api.getApiRequest().call(scheme, "DELETE");
        return JSON.parseObject(data, new TypeReference<HashMap<String, String>>(){});
}

}
