package com.weibo.ad.sdk.api;

import static org.junit.Assert.*;

import com.alibaba.fastjson.JSON;
import com.weibo.ad.sdk.Api;
import com.weibo.ad.sdk.ApiRequest;
import com.weibo.ad.sdk.constant.CreativeConfiguredStatusConstant;
import com.weibo.ad.sdk.entity.CreativeEntity;
import com.weibo.ad.sdk.model.CreativeModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;


public class CreativeApiTest
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
        EasyMock.expect(apiRequest.call("/creatives/info/1")).andReturn("{\"id\" : 1}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest);
        EasyMock.replay(api, apiRequest);
        CreativeApi creativeApi = new CreativeApi(api);
        CreativeEntity creative = creativeApi.read(1);
        assertEquals(Integer.valueOf(1), creative.getId());
        EasyMock.verify(api, apiRequest);
    }

    @Test
    public void create() throws Exception {
        CreativeEntity creativeEntity = new CreativeEntity();
        creativeEntity.setName("creative_title");

        EasyMock.expect(apiRequest.call("/creatives", "POST", creativeEntity)).andReturn("{\"id\":1, \"name\":\"creative_title\"}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest).times(1);
        EasyMock.replay(api, apiRequest);

        CreativeApi creativeApi = new CreativeApi(api);
        CreativeEntity creative = creativeApi.create(creativeEntity);
        assertEquals("creative_title", creative.getName());
        EasyMock.verify(api, apiRequest);
    }

    @Test
    public void lists() throws Exception {
        EasyMock.expect(apiRequest.call("/creatives/search?page=1&page_size=10&name=creative_title")).andReturn
                ("{\"list\":{\"id\" : 1}}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest);
        EasyMock.replay(api, apiRequest);
        CreativeApi creativeApi = new CreativeApi(api);
        CreativeModel creativeModel = creativeApi.lists("creative_title", -1, 0, 0,0, 0, 1, 10);
        assertEquals(Integer.valueOf(1), creativeModel.getList().get(0).getId());
        EasyMock.verify(api, apiRequest);
    }

    @Test
    public void update() throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("update_status", "1");
        params.put("status", CreativeConfiguredStatusConstant.PAUSE);
        EasyMock.expect(apiRequest.call("/creatives/1", "PUT", params)).andReturn("{\"id\":1, "
                + "\"name\":\"creative_title2\", \"configured_status\":0}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest).times(1);
        EasyMock.replay(api, apiRequest);

        CreativeApi creativeApi = new CreativeApi(api);
        Map<String, String> ret = creativeApi.update(1, CreativeConfiguredStatusConstant.PAUSE);
        assertEquals(Integer.valueOf(0), Integer.valueOf(ret.get("configured_status")));
        EasyMock.verify(api, apiRequest);
    }

    @Test
    public void update1() throws Exception {
        HashMap<String, String> monitor = new HashMap<>();
        monitor.put("third_party_show", "http://weibo.com");
        Map<String, String> params = new HashMap<>();
        params.put("monitor_type", "1");
        params.put("monitor", JSON.toJSONString(monitor));
        params.put("comment_open", "1");
        params.put("name", "");

        EasyMock.expect(apiRequest.call("/creatives/1", "PUT", params)).andReturn("{\"id\":1, "
                + "\"name\":\"creative_title2\", \"configured_status\":0}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest).times(1);
        EasyMock.replay(api, apiRequest);

        CreativeApi creativeApi = new CreativeApi(api);
        CreativeEntity creative = creativeApi.update(1, 1, monitor, 1, "");
        assertEquals("creative_title2", creative.getName());
        EasyMock.verify(api, apiRequest);
    }

    @Test
    public void delete() throws Exception {
        EasyMock.expect(apiRequest.call("/creatives/1", "DELETE")).andReturn("{\"success\":true}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest);
        EasyMock.replay(api, apiRequest);
        CreativeApi creativeApi = new CreativeApi(api);
        Map<String, String> ret = creativeApi.delete(1);
        assertTrue(Boolean.valueOf(ret.get("success")));
        assertEquals("true", ret.get("success"));
        EasyMock.verify(api, apiRequest);
    }

    @Test
    public void createTag() throws Exception {

        ArrayList<String> photoUrl = new ArrayList<>();
        photoUrl.add("http%3A%2F%2Fshorturl.biz.weibo.cn%2FRfsetev");
        ArrayList<String> photoTags = new ArrayList<>();
        photoUrl.add("tag1");
        photoUrl.add("tag2");
        ArrayList<String> tagDesc = new ArrayList<>();
        photoUrl.add("tag_des");

        Map<String, String> params = new HashMap<>();
        params.put("photo_url", JSON.toJSONString(photoUrl));
        params.put("photo_tags", JSON.toJSONString(photoTags));
        params.put("tag_desc", JSON.toJSONString(tagDesc));
        params.put("deep_link", "");
        params.put("app_id", String.valueOf(0));

        EasyMock.expect(apiRequest.call("/tags", "POST", params)).andReturn
                ("{\"tags\":{\"6648544ajw1fbthp8r3d5j21kw11x1kx\":{\"long_url\":\"http%3A%2F%2Fshorturl.biz.weibo"
                        + ".cn%2FRfsetev\"}}}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest);
        EasyMock.replay(api, apiRequest);
        CreativeApi creativeApi = new CreativeApi(api);
        Map<String, Object> ret = creativeApi.createTag(photoUrl, photoTags, tagDesc, "", 0);
        assertNotNull(ret.get("tags"));
    }

}