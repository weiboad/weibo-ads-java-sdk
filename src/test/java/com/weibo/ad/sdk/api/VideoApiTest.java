package com.weibo.ad.sdk.api;

import static org.junit.Assert.*;

import com.weibo.ad.sdk.Api;
import com.weibo.ad.sdk.ApiRequest;
import com.weibo.ad.sdk.entity.VideoEntity;
import com.weibo.ad.sdk.model.VideoModel;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;


public class VideoApiTest
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
        EasyMock.expect(apiRequest.call("/video?id=1&is_md5=0")).andReturn("{\"id\" : 1}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest);
        EasyMock.replay(api, apiRequest);
        VideoApi videoApi = new VideoApi(api);
        VideoEntity campaign = videoApi.read(1, 0);
        assertEquals(Integer.valueOf(1), campaign.getId());
        EasyMock.verify(api, apiRequest);
    }

    @Test
    public void lists() throws Exception {
        EasyMock.expect(apiRequest.call("/video/list?page=1&page_size=10")).andReturn
                ("{\"list\":{\"id\" : 1}}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest);
        EasyMock.replay(api, apiRequest);
        VideoApi videoApi = new VideoApi(api);
        VideoModel videoModel = videoApi.lists(1, 10);
        assertEquals(Integer.valueOf(1), videoModel.getList().get(0).getId());
        EasyMock.verify(api, apiRequest);
    }

}