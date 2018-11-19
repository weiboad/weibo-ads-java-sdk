package com.weibo.ad.sdk.api;

import static org.junit.Assert.*;

import com.weibo.ad.sdk.Api;
import com.weibo.ad.sdk.ApiRequest;
import com.weibo.ad.sdk.entity.AccountEntity;
import org.easymock.EasyMock;
import org.junit.Test;

public class AccountApiTest {


    @Test
    public void read() throws Exception {
        ApiRequest apiRequest = EasyMock.createMock(ApiRequest.class);
        Api api = EasyMock.createMock(Api.class);
        EasyMock.expect(apiRequest.call("/account")).andReturn("{\"id\" : 1}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest);
        EasyMock.replay(api, apiRequest);
        AccountApi accountApi = new AccountApi(api);
        AccountEntity account = accountApi.read();
        assertEquals(Integer.valueOf(1), account.getId());
        EasyMock.verify(api, apiRequest);
    }
}