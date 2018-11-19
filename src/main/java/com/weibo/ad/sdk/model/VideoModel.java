package com.weibo.ad.sdk.model;

import com.weibo.ad.sdk.entity.VideoEntity;
import java.util.ArrayList;

public class VideoModel extends AbstractModel
{
    private ArrayList<VideoEntity> list;

    public ArrayList<VideoEntity> getList() {
        return list;
    }

    public void setList(ArrayList<VideoEntity> list) {
        this.list = list;
    }
}
