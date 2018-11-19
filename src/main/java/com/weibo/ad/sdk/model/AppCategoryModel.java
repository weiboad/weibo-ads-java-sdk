package com.weibo.ad.sdk.model;


import com.weibo.ad.sdk.entity.AppCategoryEntity;
import java.util.ArrayList;

public class AppCategoryModel
{

    private Integer id;

    private String value;

    private ArrayList<AppCategoryEntity> items;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ArrayList<AppCategoryEntity> getItems() {
        return items;
    }

    public void setItems(ArrayList<AppCategoryEntity> items) {
        this.items = items;
    }
}
