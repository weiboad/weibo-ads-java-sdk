package com.weibo.ad.sdk.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.weibo.ad.sdk.Api;
import com.weibo.ad.sdk.entity.CreativeEntity;
import com.weibo.ad.sdk.exception.ApiException;
import com.weibo.ad.sdk.model.CreativeModel;
import com.weibo.ad.sdk.model.FeedModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class CreativeApi extends AbstractApi
{
    private static final String URI_READING = "/creatives/%d";
    private static final String URI_LIST    = "/creatives";
    private static final String URI_CREATE  = "/creatives";
    private static final String URI_INDUSTRY   = "/creatives/industry";
    private static final String URI_HYPERLINK   = "/creatives/hyperlink";
    private static final String URI_UPDATE_STATUS   = "/creatives/status/%d";
    private static final String URI_UPDATE  = "/creatives/%d";
    private static final String URI_DELETE  = "/creatives/%d";
    private static final String URI_CREATE_TAG = "/tags";

    public CreativeApi(Api api) {
        super(api);
    }

    public CreativeEntity read(int id) throws ApiException,IOException {
        String data = api.getApiRequest().call(String.format(URI_READING, id));
        return JSON.parseObject(data, CreativeEntity.class);
    }


    public CreativeEntity create(CreativeEntity creative) throws  ApiException, IOException, IllegalAccessException {
        String data = api.getApiRequest().call(URI_CREATE, "POST", creative);
        return JSON.parseObject(data, CreativeEntity.class);
    }

    public CreativeModel lists(String name, int adId, int campaignId, int isIncludeAd, int isIncludeFeed, int status,
            int page, int pageSize) throws  ApiException, IOException {
        String scheme = URI_LIST .concat( "?page=" + page + "&page_size=" + pageSize);
        if (!name.equals("")) {
            scheme +="&name=" + name;
        }
        if (adId > 0) {
            scheme +="&ad_id=" + adId;
        }
        if (status != 0) {
            scheme +="&status=" + status;
        }
        if (campaignId > 0) {
            scheme +="&campaign_id=" + campaignId;
        }
        if (isIncludeAd > 0) {
            scheme +="&is_include_ad=" + isIncludeAd;
        }
        if (isIncludeFeed > 0) {
            scheme +="&is_include_feed=" + isIncludeFeed;
        }
        String data = api.getApiRequest().call(scheme);
        return JSON.parseObject(data, CreativeModel.class);
    }



    public  HashMap<String, String> update(int creativeId, String status) throws ApiException, IOException {
        Map<String, String> params = new HashMap<>();
        params.put("status", status);

        String data = api.getApiRequest().call(String.format(String.format(URI_UPDATE_STATUS, creativeId), creativeId), "PUT", params);
        return JSON.parseObject(data, new TypeReference<HashMap<String, String>>(){});
    }

    public CreativeEntity update(int creativeId, int monitorType, HashMap<String, String> monitor, int commentOpen,
            String name) throws ApiException, IOException{
        Map<String, String> params = new HashMap<>();
        params.put("monitor_type", String.valueOf(monitorType));
        params.put("monitor", JSON.toJSONString(monitor));
        params.put("comment_open", String.valueOf(commentOpen));
        params.put("name", name);
        String data = api.getApiRequest().call(String.format(URI_UPDATE, creativeId), "PUT", params);
        return JSON.parseObject(data, CreativeEntity.class);
    }

    public HashMap<String, String> delete(int id) throws ApiException,  IOException, IllegalAccessException{
        String scheme = String.format(URI_DELETE, id);
        String data = api.getApiRequest().call(scheme, "DELETE");
        return JSON.parseObject(data, new TypeReference<HashMap<String, String>>(){});
    }

    public HashMap<String, Object> createTag(ArrayList<String> photoUrl,
            ArrayList photoTags, ArrayList<String> tagDesc,
            String deepLink,
            int appId) throws ApiException, IOException {
        Map<String, String> params = new HashMap<>();
        params.put("photo_url", JSON.toJSONString(photoUrl));
        params.put("photo_tags", JSON.toJSONString(photoTags));
        params.put("tag_desc", JSON.toJSONString(tagDesc));
        params.put("deep_link", deepLink);
        params.put("app_id", String.valueOf(appId));
        String data = api.getApiRequest().call(URI_CREATE_TAG, "POST", params);
        return JSON.parseObject(data, new TypeReference<HashMap<String, Object>>(){});
    }


    public String getIndustry() throws ApiException, IOException {
        return  api.getApiRequest().call(URI_INDUSTRY);
    }

    public CreativeEntity createHyperlink(String url, String displayName) throws  ApiException, IOException,
            IllegalAccessException {
        Map<String, String> params = new HashMap<>();
        params.put("url", url);
        params.put("display_name", displayName);
        String data = api.getApiRequest().call(URI_HYPERLINK, "POST", params);
        return JSON.parseObject(data, CreativeEntity.class);
    }

}
