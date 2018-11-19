package com.weibo.ad.sdk.constant;


public class AdStatusConstant
{

    /**
     * 删除、结束状态
     */
    public static final Integer DELETE_STATUS = -1;

    /**
     * 默认状态
     */
    public static final Integer DEFAULT_STATUS = 0;

    /**
     * 待投放
     */
    public static final Integer WAIT_DELIVER_STATUS = 1;

    /**
     * 投放中
     */
    public static final Integer DELIVERING_STATUS = 2;

    /**
     * 用户暂停
     */
    public static final Integer PAUSE_STATUS = 3;

    /**
     * 账户异常
     */
    public static final Integer ACCOUNT_ABNORMAL_STATUS = 5;

    /**
     * 系列暂停
     */
    public static final Integer CAMPAIGN_PAUSE_STATUS = 6;

    /**
     * 余额不足
     */
    public static final Integer ACCOUNT_BALANCE_LACK_STATUS = 7;

    /**
     * 到达账户日限额
     */
    public static final Integer REACH_ACCOUNT_SPEND_CAP_STATUS = 8;

    /**
     * 到达系列预算
     */
    public static final Integer REACH_CAMPAIGN_LIFETIME_BUDGET_STATUS = 9;

    /**
     * 到达计划日限额
     */
    public static final Integer REACH_AD_DAILY_BUDGET_STATUS = 10;

    /**
     * 无可用创意
     */
    public static final Integer CREATIVE_NOT_EXIST_STATUS = 11;

}
