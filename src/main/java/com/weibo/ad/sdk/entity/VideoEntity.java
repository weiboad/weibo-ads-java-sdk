package com.weibo.ad.sdk.entity;


import com.alibaba.fastjson.annotation.JSONField;

public class VideoEntity
{
    private Integer id;

    private Long uid;

    private String fid;

    private String name;

    private String length;

    private String md5;

    @JSONField(name = "short_url")
    private String shortUrl;

    @JSONField(name = "uploaded_status")
    private String uploadedStatus;

    @JSONField(name = "transcoded_status")
    private String transcodedStatus;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getUploadedStatus() {
        return uploadedStatus;
    }

    public void setUploadedStatus(String uploadedStatus) {
        this.uploadedStatus = uploadedStatus;
    }

    public String getTranscodedStatus() {
        return transcodedStatus;
    }

    public void setTranscodedStatus(String transcodedStatus) {
        this.transcodedStatus = transcodedStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
