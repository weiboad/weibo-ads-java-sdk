package com.weibo.ad.sdk.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Package: com.weibo.ad.sdk.model
 *
 * @Author: yongqiang7@weibo.com
 * @Date: Creatd at 2018/2/9 下午2:34
 */
public class ExceptionModel
{

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public ErrorModel getMessage() {
        return message;
    }

    public void setMessage(ErrorModel message) {
        this.message = message;
    }

    @JSONField(name = "http_code")

    private int httpCode;

    private ErrorModel message;


}
