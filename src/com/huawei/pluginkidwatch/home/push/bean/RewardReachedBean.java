package com.huawei.pluginkidwatch.home.push.bean;

public class RewardReachedBean extends KOnePushBeanBase {
    public DataReward data = new DataReward();

    public class DataReward {
        public String count = "";
        public String rewardInfo = "";

        public String toString() {
            return "   rewardInfo:" + this.rewardInfo + " count:" + this.count;
        }
    }

    public String toString() {
        return "  deviceCode:" + this.deviceCode + " name:" + this.name + " time:" + this.time;
    }
}
