package com.weibo.ad.sdk.entity;

import com.alibaba.fastjson.annotation.JSONField;

public class ImageEntity
{
    private Integer id;

    private String name;

    private Long uid;

    @JSONField(name = "pic_id")
    private String picId;

    private String status;

    @JSONField(name = "original_pic_url")
    private String originalPicUrl;

    @JSONField(name = "bmiddle_pic_url")
    private String bmiddlePicUrl;

    @JSONField(name = "thumbnail_pic_url")
    private String thumbnailPicUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getPicId() {
        return picId;
    }

    public void setPicId(String picId) {
        this.picId = picId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOriginalPicUrl() {
        return originalPicUrl;
    }

    public void setOriginalPicUrl(String originalPicUrl) {
        this.originalPicUrl = originalPicUrl;
    }

    public String getBmiddlePicUrl() {
        return bmiddlePicUrl;
    }

    public void setBmiddlePicUrl(String bmiddlePicUrl) {
        this.bmiddlePicUrl = bmiddlePicUrl;
    }

    public String getThumbnailPicUrl() {
        return thumbnailPicUrl;
    }

    public void setThumbnailPicUrl(String thumbnailPicUrl) {
        this.thumbnailPicUrl = thumbnailPicUrl;
    }
}
