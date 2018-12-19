package com.weibo.ad.sdk.api;

import com.weibo.ad.sdk.Api;
import com.weibo.ad.sdk.ApiRequest;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

/**
 * Package: com.weibo.ad.sdk.api
 *
 * @Author: yongqiang7@weibo.com
 * @Date: Created at 2018/11/26 下午3:20
 */
public class DataApiTest {

    private static Api api;
    private static ApiRequest apiRequest;

    @Before
    public void setUp() {
        apiRequest = EasyMock.createMock(ApiRequest.class);
        api = EasyMock.createMock(Api.class);
    }

    @Test
    public void read() throws Exception {
        EasyMock.expect(apiRequest.call("/data/1?type=1")).andReturn("{\"id\" : 1}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest);
        EasyMock.replay(api, apiRequest);
        DataApi dataApi = new DataApi(api);
        String ad = dataApi.read(1, 1);
        EasyMock.verify(api, apiRequest);
    }
}
