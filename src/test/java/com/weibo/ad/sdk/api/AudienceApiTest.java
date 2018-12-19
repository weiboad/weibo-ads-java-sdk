package com.weibo.ad.sdk.api;

import static org.junit.Assert.*;

import com.alibaba.fastjson.JSON;
import com.weibo.ad.sdk.Api;
import com.weibo.ad.sdk.ApiRequest;
import com.weibo.ad.sdk.entity.AudienceEntity;
import com.weibo.ad.sdk.model.AudienceModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;


public class AudienceApiTest
{
    private static Api api;
    private static ApiRequest apiRequest;

    @Before
    public void setUp() {
        apiRequest = EasyMock.createMock(ApiRequest.class);
        api = EasyMock.createMock(Api.class);
    }

    @Test
    public void read() throws Exception {
        EasyMock.expect(apiRequest.call("/audiences/1")).andReturn("{\"id\" : 1}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest);
        EasyMock.replay(api, apiRequest);
        AudienceApi audienceApi = new AudienceApi(api);
        AudienceEntity audience = audienceApi.read(1);
        assertEquals(Integer.valueOf(1), audience.getId());
        EasyMock.verify(api, apiRequest);
    }

    @Test
    public void lists() throws Exception {
        EasyMock.expect(apiRequest.call("/audiences?page=1&page_size=10&name=audience_title")).andReturn
                ("{\"list\" : "
                        + "{\"id\" : 1}}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest);
        EasyMock.replay(api, apiRequest);
        AudienceApi audienceApi = new AudienceApi(api);
        AudienceModel audienceModel = audienceApi.lists("audience_title", -1, -1,  1, 10);
        assertEquals(Integer.valueOf(1), audienceModel.getList().get(0).getId());
        EasyMock.verify(api, apiRequest);
    }


}