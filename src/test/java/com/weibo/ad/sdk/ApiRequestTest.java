package com.weibo.ad.sdk;

import static org.junit.Assert.*;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ApiRequestTest
{
    private static ApiRequest apiRequest;

    @BeforeClass
    public static void setApiRequest() {
        Api api =  new Api("app_id_test", "app_secret_test", "token_test");
        apiRequest = new ApiRequest(api);
    }


    @Test
    public void call() throws Exception {
        String url = "http://www.beckbi.cn/ping";

        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(1, TimeUnit.MILLISECONDS)
                .writeTimeout(1, TimeUnit.MILLISECONDS)
                .connectTimeout(1, TimeUnit.MILLISECONDS)
                .build();
        Request request = new Request.Builder()
                .url(url)
                .method("get", null)
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                String ret = response.body().string();
                System.out.println(ret);
            }
        }catch (SocketTimeoutException e){
            System.out.println("socket timeout");
        } finally {
            if(response != null) {
                response.body().close();
            }
            System.out.println("finally");
        }
    }

}