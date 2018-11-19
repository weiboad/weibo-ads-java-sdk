package com.weibo.ad.sdk.constant;


public class CreativeStatusConstant
{

    /**
     * 审核中
     */
    public static final Integer PENDING_REVIEW = 0;

    /**
     * 正常
     */
    public static final Integer NORMAL = 1;

    /**
     * 异常 审核异常
     */
    public static final Integer UNUSUAL_GUARD = 2;

    /**
     * 异常 uid/mid异常
     */
    public static final Integer UNUSUAL_INFO = 3;

    /**
     * 暂停
     */
    public static final Integer PARSED = 4;

    /**
     * 异常
     */
    public static final Integer UNUSUAL = 5;

    /**
     * 异常 （自动）发布异常
     */
    public static final Integer UNUSUAL_PUBLISH = 6;

    /**
     * 待发布
     */
    public static final Integer PUBLISHING = 7;

    /**
     * 已删除
     */
    public static final Integer DELETED = 9;


}
