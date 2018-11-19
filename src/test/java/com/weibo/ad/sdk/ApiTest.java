package com.weibo.ad.sdk;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ApiTest
{

    private static Api api;

    @Before
    public void setApi() {
        api =  new Api("app_id_test", "app_secret_test", "token_test");
    }

    @Test
    public void getApiVersion() throws Exception {
        assertEquals(Api.API_VERSION, Api.getApiVersion());
    }

    @Test
    public void getToken() throws Exception {
        assertEquals("token_test", api.getToken());
    }

    @Test
    public void setToken() throws Exception {
        api.setToken("token_mock");
        assertEquals("token_mock", api.getToken());
    }

    @Test
    public void getAppId() throws Exception {
        assertEquals("app_id_test", api.getAppId());
    }

    @Test
    public void setAppId() throws Exception {
        api.setAppId("app_id_mock");
        assertEquals("app_id_mock", api.getAppId());
    }

    @Test
    public void getAppSecret() throws Exception {
        assertEquals("app_secret_test", api.getAppSecret());
    }

    @Test
    public void setAppSecret() throws Exception {
        api.setAppSecret("app_secret_mock");
        assertEquals("app_secret_mock", api.getAppSecret());
    }

    @Test
    public void getApiRequest() throws Exception {
        assertTrue(api.getApiRequest() instanceof  ApiRequest);
    }

}