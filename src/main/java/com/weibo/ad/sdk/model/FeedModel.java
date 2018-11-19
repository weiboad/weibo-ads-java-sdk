package com.weibo.ad.sdk.model;

import com.weibo.ad.sdk.entity.FeedStatEntity;
import java.util.ArrayList;

/**
 * Package: com.weibo.ad.sdk.model
 *
 * @Author: yongqiang7@weibo.com
 * @Date: Creatd at 2018/2/5 下午1:19
 */
public class FeedModel extends AbstractModel
{

    private ArrayList<FeedStatEntity> list;

    public ArrayList<FeedStatEntity> getList() {
        return list;
    }

    public void setList(ArrayList<FeedStatEntity> list) {
        this.list = list;
    }
}
