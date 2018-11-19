package com.weibo.ad.sdk.model;


import com.weibo.ad.sdk.entity.ADsEntity;
import java.util.ArrayList;

public class ADsModel extends AbstractModel
{
    private ArrayList<ADsEntity> list;

    public ArrayList<ADsEntity> getList() {
        return list;
    }

    public void setList(ArrayList<ADsEntity> list) {
        this.list = list;
    }
}
