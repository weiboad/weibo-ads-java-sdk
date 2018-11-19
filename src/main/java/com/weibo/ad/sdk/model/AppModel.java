package com.weibo.ad.sdk.model;


import com.weibo.ad.sdk.entity.AppEntity;
import java.util.ArrayList;

public class AppModel extends AbstractModel
{
    private ArrayList<AppEntity> list;

    public ArrayList<AppEntity> getList() {
        return list;
    }

    public void setList(ArrayList<AppEntity> list) {
        this.list = list;
    }
}
