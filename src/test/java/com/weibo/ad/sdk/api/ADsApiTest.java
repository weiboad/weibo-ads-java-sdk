package com.weibo.ad.sdk.api;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import com.weibo.ad.sdk.Api;
import com.weibo.ad.sdk.ApiRequest;
import com.weibo.ad.sdk.constant.ConfiguredStatusConstant;
import com.weibo.ad.sdk.entity.ADsEntity;
import com.weibo.ad.sdk.entity.DesignatedAccountEntity;
import com.weibo.ad.sdk.entity.TopicEntity;
import com.weibo.ad.sdk.model.ADsModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class ADsApiTest
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
        EasyMock.expect(apiRequest.call("/ads/1")).andReturn("{\"id\" : 1}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest);
        EasyMock.replay(api, apiRequest);
        ADsApi aDsApi = new ADsApi(api);
        ADsEntity ad = aDsApi.read(1);
        assertEquals(Integer.valueOf(1), ad.getId());
        EasyMock.verify(api, apiRequest);
    }

    @Test
    public void lists() throws Exception {
        EasyMock.expect(apiRequest.call("/ads?page=1&page_size=10&name=ad_title")).andReturn
                ("{\"list\" : "
                + "{\"id\" : 1}}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest);
        EasyMock.replay(api, apiRequest);
        ADsApi aDsApi = new ADsApi(api);
        ADsModel aDsModel = aDsApi.lists("ad_title", 0, 0, null, 0, null, null, -1, null, 1, 10);
        assertEquals(Integer.valueOf(1), aDsModel.getList().get(0).getId());
        EasyMock.verify(api, apiRequest);
    }

    @Test
    public void create() throws Exception {
        ADsEntity adEntity = new ADsEntity();
        adEntity.setName("ad_title");
        EasyMock.expect(apiRequest.call("/ads", "POST", adEntity)).andReturn("{\"id\":1, \"name\":\"ad_title\"}");
        EasyMock.expect(apiRequest.call("/ads/1", "PUT", adEntity)).andReturn("{\"id\":1, \"name\":\"ad_title\"}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest).times(2);
        EasyMock.replay(api, apiRequest);

        ADsApi aDsApi = new ADsApi(api);
        ADsEntity ad = aDsApi.create(adEntity);
        assertEquals("ad_title", ad.getName());

        adEntity.setId(1);
        ad = aDsApi.create(adEntity);
        assertEquals(Integer.valueOf(1), ad.getId());

        EasyMock.verify(api, apiRequest);
    }

    @Test
    public void update() throws Exception {
        ADsEntity adEntity = new ADsEntity();
        adEntity.setName("ad_title2");
        adEntity.setId(1);

        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(1));

        EasyMock.expect(apiRequest.call("/ads/1", "PUT", adEntity)).andReturn("{\"id\":1, \"name\":\"ad_title2\"}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest).times(1);
        EasyMock.replay(api, apiRequest);

        ADsApi aDsApi = new ADsApi(api);
        ADsEntity ad = aDsApi.update(adEntity);
        assertEquals("ad_title2", ad.getName());
        EasyMock.verify(api, apiRequest);
    }


    @Test
    public void delete() throws Exception {
        EasyMock.expect(apiRequest.call("/ads/1", "DELETE")).andReturn("{\"success\":true}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest);
        EasyMock.replay(api, apiRequest);
        ADsApi aDsApi = new ADsApi(api);
        Map<String, String> ret = aDsApi.delete(1);
        assertTrue(Boolean.valueOf(ret.get("success")));
        assertEquals("true", ret.get("success"));
        EasyMock.verify(api, apiRequest);
    }

    @Test
    public void topic() throws Exception {
        EasyMock.expect(apiRequest.call("/ads/topic-search")).andReturn("{\"list\":[{\"follow\":123,\"id\":\"id111\","
                + "\"topic_name\":\"王源\"}]}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest);
        EasyMock.replay(api, apiRequest);
        ADsApi aDsApi = new ADsApi(api);
        HashMap<String, ArrayList<TopicEntity>> topicData = aDsApi.topic("");
        ArrayList<TopicEntity> topics = topicData.get("list");
        assertNotNull(topics.get(0).getTopicName());
        EasyMock.verify(api, apiRequest);
    }

    @Test
    public void mid() throws Exception {
        EasyMock.expect(apiRequest.call("/ads/mid?url=http://weibo.com/1656783065/F6AOUl7pA?from=page_1005051656783065_profile&wvr=6&mod=weibotime&type=comment#_rnd1500261404282")).andReturn("{\"list\":[{\"mid\":\"4079855484080351\","
                + "\"url\":\"http://weibo.com/1656783065/F6AOUl7pA?from=page_1005051656783065_profile&wvr=6&mod=weibotime&type=comment#_rnd1500261404282\"}]}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest);
        EasyMock.replay(api, apiRequest);
        ADsApi aDsApi = new ADsApi(api);
        HashMap<String, ArrayList<Object>> urlData = aDsApi.mid("http://weibo"
                + ".com/1656783065/F6AOUl7pA?from=page_1005051656783065_profile&wvr=6&mod=weibotime&type=comment#_rnd1500261404282");
        assertNotNull(urlData.get("list").get(0));
        EasyMock.verify(api, apiRequest);
    }

    @Test
    public void designatedAccount() throws Exception {
        EasyMock.expect(apiRequest.call("/ads/designated-account?keyword=test&objective=88010001")).andReturn
                ("{\"list\":[{\"profile_image_url\":\"http://test.com/1.jpg\"}]}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest);
        EasyMock.replay(api, apiRequest);
        ADsApi aDsApi = new ADsApi(api);
        Map<String, ArrayList<DesignatedAccountEntity>> da = aDsApi.designatedAccount("test", 88010001);
        ArrayList<DesignatedAccountEntity> accounts = da.get("list");
        assertNotNull(accounts.get(0).getProfileImageUrl());
        EasyMock.verify(api, apiRequest);
    }

    @Test
    public void targetMap() throws Exception {
        String url = "/ads/targetmap";
        EasyMock.expect(apiRequest.call(url)).andReturn
                ("{\"interests_normal\":[{\"name\":\"金融\"}]}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest);
        EasyMock.replay(api, apiRequest);
        ADsApi aDsApi = new ADsApi(api);
        Map<String, Object> ret = aDsApi.targetMap();
        assertNotNull(ret.get("interests_normal"));
        EasyMock.verify(api, apiRequest);
    }

    @Test
    public void guarantee() throws Exception {
        String url = "/ads/guarantee?targeting={\"age_min\":8,\"genders\":401,\"age_max\":80}";
        EasyMock.expect(apiRequest.call(url)).andReturn
                ("{\"list\":[{\"2017-05-11\":[10 ,10 ,10]}]}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest);
        EasyMock.replay(api, apiRequest);
        ADsApi aDsApi = new ADsApi(api);
        Map<String, Object> ret = aDsApi.guarantee(8, 80, 401, null, null, null);
        assertNotNull(ret.get("list"));
        EasyMock.verify(api, apiRequest);
    }

    @Test
    public void guaranteePrice() throws Exception {
        String url = "/ads/guarantee/price?targeting={\"age_min\":8,\"genders\":401,\"age_max\":80}";
        EasyMock.expect(apiRequest.call(url)).andReturn
                ("{\"list\":{\"2017-05-11\":500}}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest);
        EasyMock.replay(api, apiRequest);
        ADsApi aDsApi = new ADsApi(api);
        Map<String, Object> ret = aDsApi.guaranteePrice(8, 80, 401, null, null, null);
        assertNotNull(ret.get("list"));
        EasyMock.verify(api, apiRequest);
    }

    @Test
    public void guaranteePriceRelease() throws Exception {
        String url = "/ads/guarantee/price-release?id=1&release_list=[1,2,3]";
        EasyMock.expect(apiRequest.call(url)).andReturn
                ("{\"list\":{\"2017-05-11\":{\"fine\":00}}}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest);
        EasyMock.replay(api, apiRequest);
        ADsApi aDsApi = new ADsApi(api);
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        Map<String, Object> ret = aDsApi.guaranteePriceRelease(1, ids);
        assertNotNull(ret.get("list"));
        EasyMock.verify(api, apiRequest);
    }

}