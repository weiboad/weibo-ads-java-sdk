package com.weibo.ad.sdk.model;

import com.weibo.ad.sdk.entity.CampaignEntity;
import java.util.ArrayList;

public class CampaignModel extends AbstractModel
{
    private ArrayList<CampaignEntity> list;

    public ArrayList<CampaignEntity> getList() {
        return list;
    }

    public void setList(ArrayList<CampaignEntity> list) {
        this.list = list;
    }
}
