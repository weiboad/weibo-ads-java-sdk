package com.weibo.ad.sdk.model;

import com.weibo.ad.sdk.entity.AgentCustomerEntity;
import java.util.ArrayList;

/**
 * Package: com.weibo.ad.sdk.model
 *
 * @Author: yongqiang7@weibo.com
 * @Date: Creatd at 2018/1/31 下午4:21
 */
public class AgentCustomerModel
{
    private ArrayList<AgentCustomerEntity> list;

    private int page;

    private int count;

    public ArrayList<AgentCustomerEntity> getList() {
        return list;
    }

    public void setList(ArrayList<AgentCustomerEntity> list) {
        this.list = list;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
