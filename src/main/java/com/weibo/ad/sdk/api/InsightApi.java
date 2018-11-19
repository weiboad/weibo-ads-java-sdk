package com.weibo.ad.sdk.api;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.weibo.ad.sdk.Api;
import com.weibo.ad.sdk.exception.ApiException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class InsightApi extends AbstractApi
{
    private static final String  URI_DEMOGRAPHY = "/insights/demography";
    private static final String  URI_EFFECT     = "/insights/effect";
    private static final String  URI_LAYER      = "/insights/layer";
    private static final String  URI_GRAPH      = "/insights/graph";

    public InsightApi(Api api) {
        super(api);
    }

    public HashMap<String, Object> demography(ArrayList<String> timeInterval,
            ArrayList<String> field, ArrayList<String> dimension,
            ArrayList<String> granularity,
            HashMap<String, Object> param,
            ArrayList<String> orderBy,
            String orderMode, int page, int rows) throws ApiException,IOException{

        HashMap<String, Object> data = getParams(timeInterval, field, dimension, granularity, param,
                orderBy, orderMode, page, rows);
        String url = URI_DEMOGRAPHY + "?data=" + JSON.toJSONString(data);
        String ret = api.getApiRequest().call(url);
        return JSON.parseObject(ret, new TypeReference<HashMap<String, Object>>(){});
    }

    public HashMap<String, Object> effect(ArrayList<String> timeInterval,
            ArrayList<String> field, ArrayList<String> dimension,
            ArrayList<String> granularity,
            HashMap<String, Object> param,
            ArrayList<String> orderBy,
            String orderMode, int page, int rows) throws  ApiException,IOException{


        HashMap<String, Object> data = getParams(timeInterval, field, dimension, granularity, param,
                orderBy, orderMode, page, rows);
        String url = URI_EFFECT + "?data=" + JSON.toJSONString(data);
        String ret = api.getApiRequest().call(url);
        return JSON.parseObject(ret, new TypeReference<HashMap<String, Object>>(){});
    }

    public HashMap<String, Object> graph(ArrayList<String> timeInterval,
            ArrayList<String> field, ArrayList<String> dimension,
            ArrayList<String> granularity,
            HashMap<String, Object> param,
            ArrayList<String> orderBy,
            String orderMode, int page, int rows) throws  ApiException,IOException{


        HashMap<String, Object> data = getParams(timeInterval, field, dimension, granularity, param,
                orderBy, orderMode, page, rows);
        String url = URI_GRAPH + "?data=" + JSON.toJSONString(data);
        String ret = api.getApiRequest().call(url);
        return JSON.parseObject(ret, new TypeReference<HashMap<String, Object>>(){});
    }

    public HashMap<String, Object> layer(ArrayList<String> timeInterval,
            ArrayList<String> field, ArrayList<String> dimension,
            ArrayList<String> granularity,
            HashMap<String, Object> param,
            ArrayList<String> orderBy,
            String orderMode, int page, int rows) throws  ApiException, IOException{


        HashMap<String, Object> data = getParams(timeInterval, field, dimension, granularity, param,
                orderBy, orderMode, page, rows);
        String url = URI_LAYER + "?data=" + JSON.toJSONString(data);
        String ret = api.getApiRequest().call(url);
        return JSON.parseObject(ret, new TypeReference<HashMap<String, Object>>(){});
    }

    private HashMap<String, Object> getParams(ArrayList<String> timeInterval,
            ArrayList<String> field, ArrayList<String> dimension,
            ArrayList<String> granularity,
            HashMap<String, Object> param,
            ArrayList<String> orderBy,
            String orderMode, int page, int rows) {
        HashMap<String, Object> data = new HashMap<>();
        data.put("time_interval", timeInterval);
        data.put("order_by", orderBy);
        data.put("granularity", granularity);
        data.put("dimension", dimension);
        data.put("page", page);
        data.put("rows", rows);
        data.put("field", field);
        data.put("param", param);
        data.put("order_mode", orderMode);
        return data;
    }
}
