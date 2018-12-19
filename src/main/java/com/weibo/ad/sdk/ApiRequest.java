package com.weibo.ad.sdk;

import com.weibo.ad.sdk.entity.AbstractEntity;
import com.weibo.ad.sdk.exception.ApiException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import com.weibo.ad.sdk.httpssl.SSLSocketClient;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class ApiRequest
{

    private static String BASE_URL = "https://api.biz.weibo.com";

    private Api api;

    private static int connectTimeout = 10;

    private static int readTimeout = 10;

    private static int writeTimeout = 10;

    private static OkHttpClient httpClient;


    public ApiRequest(Api api) {
        this.api = api;
    }

    public void setConnectTimeout(int timeout) {
        connectTimeout = timeout;
    }

    public void setReadTimeout(int timeout) {
        readTimeout = timeout;
    }

    public void setWriteTimeout(int timeout) {
        writeTimeout = timeout;
    }

    private static OkHttpClient getHttpClient() {
        if (httpClient != null) {
            return httpClient;
        }
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(readTimeout, TimeUnit.SECONDS)
                .writeTimeout(writeTimeout, TimeUnit.SECONDS)
                .connectTimeout(connectTimeout, TimeUnit.SECONDS)
                .sslSocketFactory(SSLSocketClient.getSSLSocketFactory())
                .hostnameVerifier(SSLSocketClient.getHostnameVerifier())
                .build();
       httpClient = client;
        return httpClient;
    }

    public String call(String scheme) throws  ApiException, IOException {
        return call(scheme, "GET");
    }



    public String call(String scheme, String method) throws ApiException, IOException {

        Response response = null;
        String ret;
        try {
            response = getHttpClient().newCall(buildCustRequest(buildUrl(scheme), method, null)).execute();
            if (response.isSuccessful()) {
                ret = response.body().string();
                return ret;
            } else {
                throw new ApiException(response.code(), response.body().string());
            }
        }finally{
            if(response != null) {
                response.body().close();
            }
        }
    }

    public String call(String scheme, String method, AbstractEntity entity) throws  ApiException, IOException,
            IllegalAccessException {
        RequestBody requestBody = Util.buildRequestBody(entity);
        return call(scheme, method, requestBody);
    }

    public String call(String scheme, String method, Map<String, String> map) throws  ApiException,IOException {
        FormBody.Builder builder = new FormBody.Builder();
        for(Entry<String, String> entry : map.entrySet()) {
            builder.add(entry.getKey(), entry.getValue());
        }
        RequestBody requestBody = builder.build();
        return call(scheme, method, requestBody);
    }

    public String call(String scheme, String method, RequestBody requestBody) throws ApiException, IOException {


        Response response = null;
        String ret;
        Request request = buildCustRequest(buildUrl(scheme), method, requestBody);
        //获取请求参数中的paramMap
        Map<String,Object> paramMap = new HashMap<>();
        if (request.body() instanceof FormBody) {
            FormBody body = (FormBody) request.body();
            for (int i = 0; i < body.size(); i++) {
                paramMap.put(body.encodedName(i),body.encodedValue(i));
            }
        }
        try {
            response = getHttpClient().newCall(request).execute();
            if (response.isSuccessful()) {
                ret = response.body().string();
                return ret;
            } else {
                throw new ApiException(response.code(), response.body().string());
            }
        }  finally {
            if(response != null) {
                response.body().close();
            }
        }
    }


    private Request buildCustRequest(String url, String method, RequestBody requestBody) {
        return new Request.Builder()
                .addHeader("Authorization", "Bearer " + api.getToken())
                .addHeader("Connection", "close")
                .addHeader("Host","api.biz.weibo.com")
                .addHeader("Accept", "application/json,application/text+gw2.0")
                .url(url)
                .method(method, requestBody)
                .build();
    }

    private String buildUrl(String scheme) {
        if(api.getBaseUrl() != null && api.getBaseUrl().contains("http")){
            BASE_URL = api.getBaseUrl();
        }
        StringBuilder stringBuilder = new StringBuilder(BASE_URL);
        stringBuilder.append(scheme);
        Long customerId = api.getCustomerId();
        if (customerId > 0) {
            if (scheme.contains("?")) {
                stringBuilder.append("&customer_id=").append(customerId);
            } else {
                stringBuilder.append("?customer_id=").append(customerId);
            }
        }
        Long operatorId = api.getOperatorId();
        if (operatorId > 0) {
            if (stringBuilder.toString().contains("?")) {
                stringBuilder.append("&operator_id=").append(operatorId);
            } else {
                stringBuilder.append("?operator_id=").append(operatorId);
            }
        }
        return stringBuilder.toString();
    }

}
