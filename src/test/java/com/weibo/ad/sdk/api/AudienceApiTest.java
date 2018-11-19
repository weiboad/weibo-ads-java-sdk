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
        EasyMock.expect(apiRequest.call("/audiences/info/1")).andReturn("{\"id\" : 1}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest);
        EasyMock.replay(api, apiRequest);
        AudienceApi audienceApi = new AudienceApi(api);
        AudienceEntity audience = audienceApi.read(1);
        assertEquals(Integer.valueOf(1), audience.getId());
        EasyMock.verify(api, apiRequest);
    }

    @Test
    public void lists() throws Exception {
        EasyMock.expect(apiRequest.call("/audiences/list?page=1&page_size=10&name=audience_title")).andReturn
                ("{\"list\" : "
                        + "{\"id\" : 1}}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest);
        EasyMock.replay(api, apiRequest);
        AudienceApi audienceApi = new AudienceApi(api);
        AudienceModel audienceModel = audienceApi.lists("audience_title", -1, -1,  1, 10);
        assertEquals(Integer.valueOf(1), audienceModel.getList().get(0).getId());
        EasyMock.verify(api, apiRequest);
    }

    @Test
    public void create2() throws Exception {

        Map<String, String> params = new HashMap<>();
        params.put("name", "audience_title");
        params.put("data_format", String.valueOf(0));
        params.put("data_source", String.valueOf(1));
        params.put("file_id", "123");
        params.put("package_id", String.valueOf(0));
        params.put("is_md5", String.valueOf(0));


        EasyMock.expect(apiRequest.call("/audiences", "POST", params)).andReturn("{\"id\":1, \"name\":\"audience_title\"}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest).times(1);
        EasyMock.replay(api, apiRequest);

        AudienceApi audienceApi = new AudienceApi(api);

        AudienceEntity audience = audienceApi.create("audience_title", "123",0, 0, 0 );
        assertEquals("audience_title", audience.getName());


        EasyMock.verify(api, apiRequest);
    }

    @Test
    public void create() throws Exception {

        Map<String, String> params = new HashMap<>();
        params.put("name", "audience_title");
        params.put("data_format", String.valueOf(0));
        params.put("data_source", String.valueOf(0));
        params.put("file_id", "123");
        params.put("is_md5", String.valueOf(0));

        EasyMock.expect(apiRequest.call("/audiences", "POST", params)).andReturn("{\"id\":1, \"name\":\"audience_title\"}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest).times(1);
        EasyMock.replay(api, apiRequest);

        AudienceApi audienceApi = new AudienceApi(api);
        AudienceEntity audience = audienceApi.create("audience_title", 0, "123", 0, 0 );
        assertEquals("audience_title", audience.getName());

        EasyMock.verify(api, apiRequest);
    }


    @Test
    public void create3() throws Exception {

        ArrayList<String> mids = new ArrayList<>();
        mids.add("111");
        mids.add("222");
        Map<String, String> params = new HashMap<>();
        params.put("name", "audience_title");
        params.put("data_format", String.valueOf(0));
        params.put("data_source", String.valueOf(2));
        params.put("file_id", "123");
        params.put("mids", JSON.toJSONString(mids));
        params.put("is_md5", String.valueOf(0));

        EasyMock.expect(apiRequest.call("/audiences", "POST", params)).andReturn("{\"id\":1, \"name\":\"audience_title\"}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest).times(1);
        EasyMock.replay(api, apiRequest);

        AudienceApi audienceApi = new AudienceApi(api);

        AudienceEntity audience = audienceApi.create("audience_title", "123",0, 0, mids);
        assertEquals("audience_title", audience.getName());

        EasyMock.verify(api, apiRequest);
    }



    @Test
    public void delete() throws Exception {
        EasyMock.expect(apiRequest.call("/audiences?id=1", "DELETE")).andReturn("{\"success\":true}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest);
        EasyMock.replay(api, apiRequest);
        AudienceApi audienceApi = new AudienceApi(api);
        Map<String, String> ret = audienceApi.delete(1);
        assertTrue(Boolean.valueOf(ret.get("success")));
        assertEquals("true", ret.get("success"));
        EasyMock.verify(api, apiRequest);
    }

    @Test
    public void setCoverage() throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(1));
        params.put("look_alike_id", String.valueOf(2));
        params.put("audiences_size", String.valueOf(123));
        params.put("name", "package_name");

        EasyMock.expect(apiRequest.call("/audiences/set_coverage", "POST", params)).andReturn("{\"id\":1, "
                + "\"look_alike_id\":\"1\"}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest).times(1);
        EasyMock.replay(api, apiRequest);

        AudienceApi audienceApi = new AudienceApi(api);

        AudienceEntity audience = audienceApi.setCoverage(1, 2, "package_name", 123);
        assertEquals(Integer.valueOf(1), audience.getLookAlikeId());

        EasyMock.verify(api, apiRequest);
    }

}