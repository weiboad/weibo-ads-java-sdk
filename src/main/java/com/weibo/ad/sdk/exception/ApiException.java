package com.weibo.ad.sdk.exception;


public class ApiException extends Exception
{

    private int httpCode;
    public ApiException(int httpCode, String message) {
        super(message);
        this.httpCode = httpCode;
    }
    public int getHttpCode() {
        return httpCode;
    }

    public String  getMessage() {
        return super.getMessage();
    }
}
