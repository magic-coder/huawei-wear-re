package com.huawei.datatype;

import com.huawei.hihealth.HiUserInfo;

public class FitnessUserInfo {
    private int height = HiUserInfo.HEIGHT_DEFAULT;
    private long time = 0;
    private int weight = 60;

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int i) {
        this.weight = i;
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
    }
}
