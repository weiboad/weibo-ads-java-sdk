package com.weibo.ad.sdk.model;


import com.weibo.ad.sdk.entity.CreativeEntity;
import java.util.ArrayList;

public class CreativeModel extends AbstractModel
{
    private ArrayList<CreativeEntity> list;

    public ArrayList<CreativeEntity> getList() {
        return list;
    }

    public void setList(ArrayList<CreativeEntity> list) {
        this.list = list;
    }
}
