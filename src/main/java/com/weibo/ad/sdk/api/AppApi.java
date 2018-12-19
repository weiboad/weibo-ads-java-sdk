package com.weibo.ad.sdk.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.weibo.ad.sdk.Api;
import com.weibo.ad.sdk.exception.ApiException;
import com.weibo.ad.sdk.model.AppCategoryModel;
import com.weibo.ad.sdk.model.AppModel;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AppApi extends AbstractApi {

    private static final String URI_LIST = "/apps";
    private static final String URI_UPLOAD = "/apps/upload";

    public AppApi(Api api) {
        super(api);
    }

    public AppModel lists(String name, int status, int page, int pageSize) throws ApiException, IOException {
        String scheme = URI_LIST.concat("?page=" + page + "&page_size=" + pageSize);
        if (!name.equals("")) {
            scheme += "&name=" + name;
        }
        if (status > 0) {
            scheme += "&status=" + status;
        }
        String data = api.getApiRequest().call(scheme);
        return JSON.parseObject(data, AppModel.class);
    }


    public Map<String, String> upload(int appType, String iosUrl, String androidUrl) throws ApiException, IOException {
        Map<String, String> params = new HashMap<>();
        params.put("ios_url", iosUrl);
        params.put("android_url", androidUrl);
        params.put("type", String.valueOf(appType));
        String data = api.getApiRequest().call(URI_UPLOAD, "POST", params);
        return JSON.parseObject(data, new TypeReference<HashMap<String, String>>() {
        });
    }

}