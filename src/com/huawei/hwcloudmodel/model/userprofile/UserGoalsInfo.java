package com.huawei.hwcloudmodel.model.userprofile;

import java.io.Serializable;

public class UserGoalsInfo implements Serializable {
    private static final long serialVersionUID = -3185409940237567052L;
    private Integer goalPeriod;
    private Integer goalType;
    private String goalValue;

    public Integer getGoalType() {
        return this.goalType;
    }

    public void setGoalType(Integer num) {
        this.goalType = num;
    }

    public Integer getGoalPeriod() {
        return this.goalPeriod;
    }

    public void setGoalPeriod(Integer num) {
        this.goalPeriod = num;
    }

    public String getGoalValue() {
        return this.goalValue;
    }

    public void setGoalValue(String str) {
        this.goalValue = str;
    }

    public String toString() {
        return "UserGoalsInfo{goalType=" + this.goalType + ", goalPeriod=" + this.goalPeriod + ", goalValue='" + this.goalValue + '\'' + '}';
    }
}
