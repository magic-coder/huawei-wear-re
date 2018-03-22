package com.huawei.hwcommonmodel.fitnessdatatype;

public class HeartRateDetail {
    public static final int HEART_RATE_TYPE_SPORT = 600;
    public static final int HEART_RATE_TYPE_TRANQUILLIZATION = 601;
    private int hrValue = 0;
    private long timeStamp = 0;
    private int type = HEART_RATE_TYPE_TRANQUILLIZATION;

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(long j) {
        this.timeStamp = j;
    }

    public int getHeartRateType() {
        return this.type;
    }

    public void setHeartRateType(int i) {
        this.type = i;
    }

    public int getHeartRateValue() {
        return this.hrValue;
    }

    public void setHeartRateValue(int i) {
        this.hrValue = i;
    }

    public String toString() {
        return "HeartRateDetail{timeStamp=" + this.timeStamp + ", type=" + this.type + ", hrValue=" + this.hrValue + '}';
    }

    public void initHeartRateDetail1() {
    }

    public void initHeartRateDetail2() {
    }

    public void initHeartRateDetail3() {
    }

    public void initHeartRateDetail4() {
    }

    public void initHeartRateDetail5() {
    }

    public void initHeartRateDetail6() {
    }
}
