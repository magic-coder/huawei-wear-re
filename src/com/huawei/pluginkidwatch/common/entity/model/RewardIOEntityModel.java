package com.huawei.pluginkidwatch.common.entity.model;

public class RewardIOEntityModel extends BaseEntityModel {
    private static final long serialVersionUID = 9077384547756030938L;
    public int count = 0;
    public String deviceCode;
    public int rewardType = 1;

    public String toString() {
        return "  deviceCode = " + this.deviceCode + "  rewardType = " + this.rewardType + "  count = " + this.count;
    }

    public void judgeRewardDevcieType() {
    }

    public void sumRewardCount() {
    }

    public void queryRewardTypeByDeviceCode() {
    }
}
