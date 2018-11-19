package com.weibo.ad.sdk.api;

import static org.junit.Assert.*;

import com.weibo.ad.sdk.Api;
import com.weibo.ad.sdk.ApiRequest;
import com.weibo.ad.sdk.entity.ImageEntity;
import com.weibo.ad.sdk.model.ImageModel;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;


public class ImageApiTest
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
        EasyMock.expect(apiRequest.call("/image?pic_id=e06601f1jw1faie2emzv6j21dg0rads7"))
                .andReturn("{\"id\" :1, \"pic_id\" :\"e06601f1jw1faie2emzv6j21dg0rads7\"}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest);
        EasyMock.replay(api, apiRequest);
        ImageApi imageApi = new ImageApi(api);
        ImageEntity image = imageApi.read("e06601f1jw1faie2emzv6j21dg0rads7");
        assertEquals("e06601f1jw1faie2emzv6j21dg0rads7", image.getPicId());
        EasyMock.verify(api, apiRequest);
    }

    @Test
    public void lists() throws Exception {
        EasyMock.expect(apiRequest.call("/image/list?page=1&page_size=10")).andReturn
                ("{\"list\":{\"id\" : 1}}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest);
        EasyMock.replay(api, apiRequest);
        ImageApi imageApi = new ImageApi(api);
        ImageModel imageModel = imageApi.lists(1, 10);
        assertEquals(Integer.valueOf(1), imageModel.getList().get(0).getId());
        EasyMock.verify(api, apiRequest);
    }
}