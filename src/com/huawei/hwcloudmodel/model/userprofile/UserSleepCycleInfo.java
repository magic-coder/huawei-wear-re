package com.huawei.hwcloudmodel.model.userprofile;

import java.io.Serializable;

public class UserSleepCycleInfo implements Serializable {
    private static final long serialVersionUID = -3185409940237567052L;
    private Integer cycleEnd;
    private Integer cycleStart;

    public Integer getCycleStart() {
        return this.cycleStart;
    }

    public void setCycleStart(Integer num) {
        this.cycleStart = num;
    }

    public Integer getCycleEnd() {
        return this.cycleEnd;
    }

    public void setCycleEnd(Integer num) {
        this.cycleEnd = num;
    }

    public String toString() {
        return "UserSleepCycleInfo{cycleStart=" + this.cycleStart + ", cycleEnd=" + this.cycleEnd + '}';
    }
}
