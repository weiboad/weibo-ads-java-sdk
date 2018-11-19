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

public class AppApi extends AbstractApi
{
    private static final String URI_LIST      = "/app/list";
    private static final String URI_UPLOAD    = "/app";
    private static final String URI_ADD       = "/app/insert";
    private static final String URI_CATEGORY  = "/app/category";

    public AppApi(Api api) {
        super(api);
    }

    public AppModel lists(String name, int status, int page, int pageSize) throws ApiException,IOException {
        String scheme = URI_LIST .concat( "?page=" + page + "&page_size=" + pageSize);
        if (!name.equals("")) {
            scheme +="&name=" + name;
        }
        if (status > 0) {
            scheme +="&status=" + status;
        }
        String data = api.getApiRequest().call(scheme);
        return JSON.parseObject(data, AppModel.class);
    }

    public ArrayList<AppCategoryModel> category() throws  ApiException, IOException {
        String data = api.getApiRequest().call(URI_CATEGORY);
        return JSON.parseObject(data, new TypeReference<ArrayList<AppCategoryModel>>(){});
    }

    public Map<String, String> upload(int appType, String iosUrl, String androidUrl) throws  ApiException,IOException{
        Map<String, String> params = new HashMap<>();
        params.put("ios_url", iosUrl);
        params.put("android_url", androidUrl);
        params.put("app_type", String.valueOf(appType));
        String data = api.getApiRequest().call(URI_UPLOAD, "POST", params);
        return JSON.parseObject(data, new TypeReference<HashMap<String, String>>(){});
    }

    public Map<String, String> add(String name, String cate, String subCate, String developer, String packageName,
            String icon, String
            image,
            String description,
            String updateInfo) throws  ApiException, IOException {

        Map<String, String> params = new HashMap<>();
        params.put("'name'", name);
        params.put("'cate'", cate);
        params.put("'sub_ate'", subCate);
        params.put("developer", developer);
        params.put("package_name", packageName);
        params.put("icon", icon);
        params.put("image", image);
        params.put("description", description);
        params.put("update_info", updateInfo);
        String data = api.getApiRequest().call(URI_ADD, "POST", params);
        return JSON.parseObject(data, new TypeReference<HashMap<String, String>>(){});
    }
}

