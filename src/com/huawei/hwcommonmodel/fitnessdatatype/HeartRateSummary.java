package com.huawei.hwcommonmodel.fitnessdatatype;

public class HeartRateSummary {
    private int avgRestHR = 0;
    private int lastHR = 0;
    private int maxHR = 0;
    private int minHR = 0;

    public int getMaxHeartRate() {
        return this.maxHR;
    }

    public void setMaxHeartRate(int i) {
        this.maxHR = i;
    }

    public int getMinHeartRate() {
        return this.minHR;
    }

    public void setMinHeartRate(int i) {
        this.minHR = i;
    }

    public int getLastHeartRate() {
        return this.lastHR;
    }

    public void setLastHeartRate(int i) {
        this.lastHR = i;
    }

    public int getAvgRestHeartRate() {
        return this.avgRestHR;
    }

    public void setAvgRestHeartRate(int i) {
        this.avgRestHR = i;
    }

    public String toString() {
        return "HeartRateSummary{maxHR=" + this.maxHR + ", minHR=" + this.minHR + ", lastHR=" + this.lastHR + ", avgRestHR=" + this.avgRestHR + '}';
    }

    public void initHeartRateSummary1() {
    }

    public void initHeartRateSummary2() {
    }

    public void initHeartRateSummary3() {
    }

    public void initHeartRateSummary4() {
    }

    public void initHeartRateSummary5() {
    }

    public void initHeartRateSummary6() {
    }

    public void initHeartRateSummary7() {
    }
}
