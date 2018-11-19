package com.weibo.ad.sdk.constant;


public class AccountStatusConstant
{
    /**
     * 未开户/聚财系统删户
     */
    public static final Integer  ENRICH_NOT_OPEN = 100;

    /**
     * 聚财系统用户资质审核未通过
     */
    public static final Integer  ENRICH_NOT_THROUGH = 101;

    /**
     * 聚财系统用户冻结
     */
    public static final Integer  ENRICH_STATUS_FREEZE = 201;

    /**
     * 聚财系统用户封杀
     */
    public static final Integer  ENRICH_STATUS_BAN = 202;

    /**
     * 聚财系统用户冻结封杀
     */
    public static final Integer  ENRICH_STATUS_FREEZE_AND_BAN = 203;

    /**
     * 未定义的错误态
     */
    public static final Integer  UNDEFINDE_ERROR = 2;

    /**
     * 用户正常
     */
    public static final Integer  USER_NORMAL = 1;

    /**
     * 用户删除
     */
    public static final Integer  USER_DELETE = -1;
}
