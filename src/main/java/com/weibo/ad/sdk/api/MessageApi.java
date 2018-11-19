package com.weibo.ad.sdk.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.weibo.ad.sdk.Api;
import com.weibo.ad.sdk.entity.ADsEntity;
import com.weibo.ad.sdk.exception.ApiException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Package: com.weibo.ad.sdk.api
 *
 * @Author: yongqiang7@weibo.com
 * @Date: Creatd at 2018/4/8 下午3:45
 */
public class MessageApi extends AbstractApi
{
    private static final String URI_LIST     = "/messages";
    private static final String URI_COUNT    = "/messages/count";
    private static final String URI_READ     = "/messages/read/%d";
    private static final String URI_READ_ALL     = "/messages/read";

    public MessageApi(Api api) {
        super(api);
    }

    public String lists(int type, String keyword, String startTime, String endTime, int page, int pageSize) throws
            ApiException,
            IOException {
        String scheme = URI_LIST .concat( "?page=" + page + "&page_size=" + pageSize + "&start_time=" + startTime +
                "&end_time=" + endTime + "&type=" + type + "&keyword=" + keyword);
        return  api.getApiRequest().call(scheme);
    }

    public String count(String startTime) throws  ApiException, IOException {
        String scheme = URI_COUNT .concat( "?start_time=" + startTime);
        return  api.getApiRequest().call(scheme);
    }

    public String read(int id) throws  ApiException, IOException {
        Map<String, String> params = new HashMap<>();
        return api.getApiRequest().call(String.format(URI_READ, id), "PUT", params);
    }

    public String readAll() throws  ApiException, IOException {
        Map<String, String> params = new HashMap<>();
        return api.getApiRequest().call(URI_READ_ALL, "PUT", params);
    }
}
