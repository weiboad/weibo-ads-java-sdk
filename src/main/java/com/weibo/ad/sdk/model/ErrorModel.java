package com.weibo.ad.sdk.model;

/**
 * Package: com.weibo.ad.sdk.model
 *
 * @Author: yongqiang7@weibo.com
 * @Date: Creatd at 2018/2/9 下午2:31
 */
public class ErrorModel
{
    private Error error;

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public  static  class Error
    {
        private String type;

        private String message;

        private int code;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }
}

