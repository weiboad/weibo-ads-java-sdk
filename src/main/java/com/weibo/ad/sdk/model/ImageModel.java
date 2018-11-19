package com.weibo.ad.sdk.model;


import com.weibo.ad.sdk.entity.ImageEntity;
import java.util.ArrayList;

public class ImageModel extends AbstractModel
{
    private ArrayList<ImageEntity> list;

    public ArrayList<ImageEntity> getList() {
        return list;
    }

    public void setList(ArrayList<ImageEntity> list) {
        this.list = list;
    }
}
