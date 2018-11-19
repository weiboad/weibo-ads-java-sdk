package com.weibo.ad.sdk.model;

import com.weibo.ad.sdk.entity.AudienceEntity;
import java.util.ArrayList;

public class AudienceModel extends AbstractModel
{
    private ArrayList<AudienceEntity> list;

    public ArrayList<AudienceEntity> getList() {
        return list;
    }

    public void setList(ArrayList<AudienceEntity> list) {
        this.list = list;
    }
}
