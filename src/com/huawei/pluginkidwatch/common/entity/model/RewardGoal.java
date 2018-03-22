package com.huawei.pluginkidwatch.common.entity.model;

import com.huawei.pluginkidwatch.common.lib.utils.C1489i;

public class RewardGoal {
    private int goal;
    private String reward;

    public void setGoal(int i) {
        this.goal = ((Integer) C1489i.m6887a(Integer.valueOf(i))).intValue();
    }

    public void setReward(String str) {
        this.reward = (String) C1489i.m6887a(str);
    }

    public int getGoal() {
        return ((Integer) C1489i.m6887a(Integer.valueOf(this.goal))).intValue();
    }

    public String getReward() {
        return (String) C1489i.m6887a(this.reward);
    }

    public String toString() {
        return "" + " goal=" + getGoal() + " reward=" + getReward();
    }
}
