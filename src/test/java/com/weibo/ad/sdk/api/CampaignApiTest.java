package com.weibo.ad.sdk.api;

import static org.junit.Assert.*;

import com.weibo.ad.sdk.Api;
import com.weibo.ad.sdk.ApiRequest;
import com.weibo.ad.sdk.constant.ConfiguredStatusConstant;
import com.weibo.ad.sdk.entity.CampaignEntity;
import com.weibo.ad.sdk.model.CampaignModel;
import java.util.HashMap;
import java.util.Map;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class CampaignApiTest
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
        EasyMock.expect(apiRequest.call("/campaigns/1")).andReturn("{\"id\" : 1}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest);
        EasyMock.replay(api, apiRequest);
        CampaignApi campaignApi = new CampaignApi(api);
        CampaignEntity campaign = campaignApi.read(1);
        assertEquals(Integer.valueOf(1), campaign.getId());
        EasyMock.verify(api, apiRequest);
    }
    @Test
    public void lists() throws Exception {
        EasyMock.expect(apiRequest.call("/campaigns?page=1&page_size=10&name=campaign_title")).andReturn
                ("{\"list\":{\"id\" : 1}}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest);
        EasyMock.replay(api, apiRequest);
        CampaignApi campaignApi = new CampaignApi(api);
        CampaignModel campaignModel = campaignApi.lists(0, null, "campaign_title", -1, -1,  -1, 1, 10);
        assertEquals(Integer.valueOf(1), campaignModel.getList().get(0).getId());
        EasyMock.verify(api, apiRequest);
    }

    @Test
    public void create() throws Exception {
        CampaignEntity campaignEntity = new CampaignEntity();
        campaignEntity.setName("campaign_title");

        EasyMock.expect(apiRequest.call("/campaigns", "POST", campaignEntity)).andReturn("{\"id\":1, \"name\":\"campaign_title\"}");
        EasyMock.expect(apiRequest.call("/campaigns/1", "PUT", campaignEntity)).andReturn("{\"id\":1, "
                + "\"name\":\"campaign_title\"}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest).times(2);
        EasyMock.replay(api, apiRequest);

        CampaignApi campaignApi = new CampaignApi(api);
        CampaignEntity campaign = campaignApi.create(campaignEntity);
        assertEquals("campaign_title", campaign.getName());

        campaignEntity.setId(1);
        campaign = campaignApi.create(campaignEntity);
        assertEquals(Integer.valueOf(1), campaign.getId());

        EasyMock.verify(api, apiRequest);
    }

    @Test
    public void update() throws Exception {
        CampaignEntity campaignEntity = new CampaignEntity();
        campaignEntity.setName("campaign_title2");
        campaignEntity.setId(1);

        EasyMock.expect(apiRequest.call("/campaigns/1", "PUT", campaignEntity)).andReturn("{\"id\":1, "
                + "\"name\":\"campaign_title2\"}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest).times(1);
        EasyMock.replay(api, apiRequest);

        CampaignApi campaignApi = new CampaignApi(api);
        CampaignEntity campaign = campaignApi.update(campaignEntity);
        assertEquals("campaign_title2", campaign.getName());
        EasyMock.verify(api, apiRequest);
    }

    @Test
    public void updateStatus() throws Exception {

        Map<String, String> params = new HashMap<>();
        params.put("status", "0");
        EasyMock.expect(apiRequest.call("/campaigns/status/1", "PUT", params)).andReturn("{\"list\":[{\"id\":1, "
                + "\"name\":\"campaign_title2\", \"configured_status\":0}]}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest).times(1);
        EasyMock.replay(api, apiRequest);

        CampaignApi campaignApi = new CampaignApi(api);
        CampaignModel campaign = campaignApi.update(1, ConfiguredStatusConstant.PAUSE);
        assertEquals(ConfiguredStatusConstant.PAUSE, campaign.getList().get(0).getConfiguredStatus());
        EasyMock.verify(api, apiRequest);
    }

    @Test
    public void delete() throws Exception {
        EasyMock.expect(apiRequest.call("/campaigns/1", "DELETE")).andReturn("{\"success\":true}");
        EasyMock.expect(api.getApiRequest()).andReturn(apiRequest);
        EasyMock.replay(api, apiRequest);
        CampaignApi campaignApi = new CampaignApi(api);
        Map<String, String> ret = campaignApi.delete(1);
        assertTrue(Boolean.valueOf(ret.get("success")));
        assertEquals("true", ret.get("success"));
        EasyMock.verify(api, apiRequest);
    }

}