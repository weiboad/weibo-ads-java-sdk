package com.weibo.ad.sdk.api;

import static org.junit.Assert.*;

import com.weibo.ad.sdk.Api;
import com.weibo.ad.sdk.ApiRequest;
import com.weibo.ad.sdk.entity.CampaignEntity;
import com.weibo.ad.sdk.model.AppCategoryModel;
import com.weibo.ad.sdk.model.AppModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class AppApiTest {

    private static Api api;
    private static ApiRequest apiRequest;

    @Before
    public void setUp() {
        apiRequest = EasyMock.createMock(ApiRequest.class);
        api = EasyMock.createMock(Api.class);
    }

    @Test
    public void lists() throws Exception {
        EasyMock.expect(apiRequest.call("/apps?page=1&page_size=10")).andReturn("{\"page\" : 1}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest);
        EasyMock.replay(api, apiRequest);
        AppApi appApi = new AppApi(api);
        AppModel appModel = appApi.lists("", 0, 1, 10);
        assertEquals(1, appModel.getPage().intValue());
        EasyMock.verify(api, apiRequest);
    }


    @Test
    public void upload() throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("type", String.valueOf(1));
        params.put("ios_url", "http://test");
        params.put("android_url", "");

        EasyMock.expect(apiRequest.call("/apps/upload", "POST", params)).andReturn("{\"errcode\" : 0}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest);
        EasyMock.replay(api, apiRequest);
        AppApi appApi = new AppApi(api);
        Map<String, String> ret = appApi.upload(1, "http://test", "");
        assertEquals("0", ret.get("errcode"));
        EasyMock.verify(api, apiRequest);

    }

}