package com.weibo.ad.sdk.api;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.weibo.ad.sdk.Api;
import com.weibo.ad.sdk.Util;
import com.weibo.ad.sdk.entity.ADsEntity;
import com.weibo.ad.sdk.entity.DesignatedAccountEntity;
import com.weibo.ad.sdk.entity.TopicEntity;
import com.weibo.ad.sdk.exception.ApiException;
import com.weibo.ad.sdk.model.ADsModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.RequestBody;

public class ADsApi extends AbstractApi
{
    private static final String URI_READING = "/ads/info/%d";
    private static final String URI_LIST    = "/ads/search";
    private static final String URI_CREATE  = "/ads";
    private static final String URI_UPDATE  = "/ads/%d";
    private static final String URI_DELETE  = "/ads/%d";
    private static final String URI_TOPIC   = "/ads/topic";
    private static final String URI_DESIGNATED_ACCOUNT   = "/ads/designated-account";
    private static final String URI_MID     = "/ads/mid";
    private static final String URI_UPDATE_STATUS  = "/ads/updatestatus";
    private static final String URI_TARGET_MAP        = "/ads/targetmap";
    private static final String URI_GUARANTEE         = "/ads/guarantee";
    private static final String URI_GUARANTEE_PRICE   = "/ads/guarantee/price";
    private static final String URI_GUARANTEE_PRICE_RELEASE  = "/ads/guarantee/price-release";

    public ADsApi(Api api) {
        super(api);
    }

    public ADsEntity read(int id) throws ApiException,IOException {
        String data = api.getApiRequest().call(String.format(URI_READING, id));
        return JSON.parseObject(data, ADsEntity.class);
    }

    public ADsModel lists(String name, int campaignId, int objective, float lifetimBudget,
            int guaranteedDelivery, String status, int page, int pageSize) throws  ApiException, IOException{
        String scheme = URI_LIST .concat( "?page=" + page + "&page_size=" + pageSize);
        if (!name.equals("")) {
            scheme +="&name=" + name;
        }
        if (objective > 0) {
            scheme +="&objective=" + objective;
        }
        if (campaignId > 0) {
            scheme +="&campaign_id=" + campaignId;
        }
        if (status != "0") {
            scheme +="&effective_status=" + status;
        }
        if (lifetimBudget > 0) {
            scheme += "&lifetime_budget=" + lifetimBudget;
        }
        if (guaranteedDelivery >= 0) {
            Boolean st = true;
            if (guaranteedDelivery == 0) {
                 st = false;
            }
            scheme += "&guaranteed_delivery=" + st;
        }
        String data = api.getApiRequest().call(scheme);
        return JSON.parseObject(data, ADsModel.class);
    }




    public ADsEntity create(ADsEntity ad) throws  ApiException, IOException, IllegalAccessException {
        if (ad.getId() != null && ad.getId() > 0) {
            return update(ad);
        }
        String data = api.getApiRequest().call(URI_CREATE, "POST", ad);
        return JSON.parseObject(data, ADsEntity.class);
    }

    public ADsEntity update(ADsEntity ad) throws  ApiException, IOException, IllegalAccessException {
        String data = api.getApiRequest().call(String.format(URI_UPDATE, ad.getId()), "PUT", ad);
        return JSON.parseObject(data, ADsEntity.class);
    }

    public ADsModel update(int adId, int status) throws  ApiException, IOException , IllegalAccessException{
        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(adId));
        params.put("configured_status", String.valueOf(status));
        String data = api.getApiRequest().call(URI_UPDATE_STATUS, "POST", params);
        return JSON.parseObject(data, ADsModel.class);
    }

    public HashMap<String, String> delete(int id) throws  ApiException, IOException {
        String scheme = String.format(URI_DELETE, id);
        String data = api.getApiRequest().call(scheme, "DELETE");
        return JSON.parseObject(data, new TypeReference<HashMap<String, String>>(){});
    }

    public  HashMap<String, ArrayList<TopicEntity>> topic(String keyword) throws  ApiException, IOException {
        String scheme = URI_TOPIC;
        if (keyword != "") {
            scheme += "?keyword=" + keyword;
        }
        String data = api.getApiRequest().call(scheme);
        return JSON.parseObject(data, new TypeReference<HashMap<String, ArrayList<TopicEntity>>>(){});
    }

    public HashMap<String, ArrayList<Object>> mid(String url) throws  ApiException, IOException {
        String scheme = URI_MID + "?url=" + url;
        String data = api.getApiRequest().call(scheme);
        return JSON.parseObject(data, new TypeReference<HashMap<String, ArrayList<Object>>>(){});
    }

    public HashMap<String, ArrayList<DesignatedAccountEntity>> designatedAccount(String keyword) throws
            ApiException, IOException {
        String scheme = URI_DESIGNATED_ACCOUNT;
        if (keyword != "") {
            scheme += "?keyword=" + keyword;
        }
        String data = api.getApiRequest().call(scheme);
        return JSON.parseObject(data, new TypeReference<HashMap<String, ArrayList<DesignatedAccountEntity>>>(){});
    }

    public HashMap<String, Object> targetMap() throws  ApiException, IOException {
        String data = api.getApiRequest().call(URI_TARGET_MAP);
        return JSON.parseObject(data, new TypeReference<HashMap<String, Object>>(){});
    }

    public HashMap<String, Object> guarantee(int ageMin, int ageMax, int gender, ArrayList<Integer> geoLocations,
            ArrayList<Integer> interests, ArrayList<Integer> os) throws  ApiException, IOException {
        String url = URI_GUARANTEE + "?targeting=" + buildGuaranteePriceParams(ageMin, ageMax, gender, geoLocations,
                interests, os);
        String ret = api.getApiRequest().call(url);
        return JSON.parseObject(ret, new TypeReference<HashMap<String, Object>>(){});
    }

    public HashMap<String, Object> guaranteePrice(int ageMin, int ageMax, int gender, ArrayList<Integer> geoLocations,
            ArrayList<Integer> interests, ArrayList<Integer> os) throws  ApiException, IOException {

        String url = URI_GUARANTEE_PRICE + "?targeting=" + buildGuaranteePriceParams(ageMin, ageMax, gender, geoLocations,
                interests, os);
        String ret = api.getApiRequest().call(url);
        return JSON.parseObject(ret, new TypeReference<HashMap<String, Object>>(){});
    }

    public HashMap<String, Object> guaranteePriceRelease(int id, ArrayList<Integer> releaseList) throws
            ApiException, IOException {

        String url = String.format("%s?id=%s&release_list=%s", URI_GUARANTEE_PRICE_RELEASE, id, JSON.toJSONString
                (releaseList));

        String ret = api.getApiRequest().call(url);
        return JSON.parseObject(ret, new TypeReference<HashMap<String, Object>>(){});
    }

    private String buildGuaranteePriceParams(int ageMin, int ageMax, int gender, ArrayList<Integer> geoLocations,
            ArrayList<Integer> interests, ArrayList<Integer> os) {
        HashMap<String, Object> data = new HashMap<>();
        data.put("age_min", ageMin);
        data.put("age_max", ageMax);
        data.put("genders", gender);
        data.put("geo_locations", geoLocations);
        data.put("category_interests", interests);
        data.put("user_os", os);
        return JSON.toJSONString(data);
    }
}
