package com.weibo.ad.sdk.entity;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.ArrayList;

public class SocialConnectionEntity
{
    @JSONField(name = "designated_account")
    private ArrayList<DesignatedAccountEntity> designatedAccount;

    @JSONField(name = "promote_fans")
    private Integer promoteFans;

    public ArrayList<DesignatedAccountEntity> getDesignatedAccount() {
        return designatedAccount;
    }

    public void setDesignatedAccount(ArrayList<DesignatedAccountEntity> designatedAccount) {
        this.designatedAccount = designatedAccount;
    }

    public Integer getPromoteFans() {
        return promoteFans;
    }

    public void setPromoteFans(Integer promoteFans) {
        this.promoteFans = promoteFans;
    }
}
